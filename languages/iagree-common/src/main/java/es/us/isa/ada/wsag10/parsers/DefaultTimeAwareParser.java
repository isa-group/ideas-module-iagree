/**
 * 	This file is part of ADA.
 *
 *     ADA is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ADA is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with ADA.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.us.isa.ada.wsag10.parsers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.us.isa.ada.exceptions.BadSyntaxException;
import es.us.isa.ada.exceptions.PeriodDefinitionException;
import es.us.isa.ada.exceptions.PeriodDefinitionWarningException;
import es.us.isa.temporalAlgorithms.DisjointRealTemporalInterval;
import es.us.isa.temporalAlgorithms.DisjointTemporalInterval;
import es.us.isa.temporalAlgorithms.ExceptRealTemporalInterval;
import es.us.isa.temporalAlgorithms.RealTemporalInterval;
import es.us.isa.temporalAlgorithms.SinglePeriodicRealTemporalInterval;
import es.us.isa.temporalAlgorithms.SingleRealTemporalInterval;
import es.us.isa.temporalAlgorithms.TemporalMetric;

public class DefaultTimeAwareParser implements TimeAwareParser{
	
	private String taNamespace;
	
	private Map<String, RealTemporalInterval> definedPeriods;
	
	private String gmtZone;
	
	private String dateFormat;
	
	/**
	 * Stores last parsed interval, periodical or periodicalWeekly. When a except is detected, this interval
	 * is the first part of the except.
	 */
	private RealTemporalInterval lastInterval;
	
	/**
	 * Milisegundos en un d�a
	 */
	private final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
	
	/**
	 * Milisegundos en una hora
	 */
	private final long MILLSECS_PER_SECOND = 1000;
	
	public DefaultTimeAwareParser(){
		definedPeriods = new HashMap<String, RealTemporalInterval>();
	}
	
	@Override
	public RealTemporalInterval parseGlobalValidityPeriod(Node globalValidityPeriodNode){
//		String globalPeriodName = globalValidityPeriodNode.getAttributes().getNamedItem("name").getNodeValue().trim();
		// Obligamos a que la macro del global period sea GlobalPeriod
		String globalPeriodName = "GlobalPeriod";
		SingleRealTemporalInterval result = null;
		// Global period solo puede tener un hijo y ser de tipo Interval
		NodeList globalPeriodChilds = globalValidityPeriodNode.getChildNodes();
		for(int i=0; i<globalPeriodChilds.getLength(); i++){
			Node child = globalPeriodChilds.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE){
				if(child.getNodeName().equalsIgnoreCase(taNamespace+"Interval")){
					result = parseInterval(child, gmtZone, dateFormat);
				}
			}
		}
		if(result == null){
			throw new PeriodDefinitionException("GlobalValidityPeriod must contain an Interval element");
		}
		result.setName(globalPeriodName);
		// Global period siempre ser� un intervalo sencillo
		this.definedPeriods.put(globalPeriodName, result);
		return result;
	}
	
	@Override
	public Map<String, RealTemporalInterval> parseDefinedValidityPeriodSet(Node definedValidityPeriodSetNode){
//		Map<String, RealTemporalInterval> result = new HashMap<String, RealTemporalInterval>();
		if(definedValidityPeriodSetNode.getNodeName().equalsIgnoreCase(taNamespace+"DefinedValidityPeriodSet")){
			NodeList validityPeriods = definedValidityPeriodSetNode.getChildNodes();
			for(int i=0; i<validityPeriods.getLength(); i++){
				Node validityPeriod = validityPeriods.item(i);
				if(validityPeriod.getNodeType() == Node.ELEMENT_NODE){
					if(validityPeriod.getNodeName().equalsIgnoreCase(taNamespace+"ValidityPeriod")){
						String periodName = validityPeriod.getAttributes().getNamedItem("name").getNodeValue().trim();
						RealTemporalInterval period = parseValidityPeriod(validityPeriod); // dentro de un definedValidityPeriodSet no se pueden usar periodos ya definidos 
						period.setName(periodName);
						this.definedPeriods.put(periodName, period);
					}
				}
			}
		}
//		this.definedPeriods = result;
		return this.definedPeriods;
	}

	@Override
	public RealTemporalInterval parseValidityPeriod(Node validityPeriodNode){
//		String periodName = null;
//		try {
//			periodName = validityPeriodNode.getAttributes().getNamedItem("name").getNodeValue().trim();
//		} catch (NullPointerException e) {
//			throw new BadSyntaxException("Required name attribute is missing in a ValidityPeriod");
//		}
		RealTemporalInterval result = null;
		NodeList periodChilds = validityPeriodNode.getChildNodes();
		for(int i=0; i<periodChilds.getLength(); i++){
			Node child = periodChilds.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE){
				if(child.getNodeName().equalsIgnoreCase(taNamespace+"Disjoint")){
					result = parseDisjoint(child);
				}
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param disjointNode dom node with several intervals in a disjoint element
	 * @param isDefinedPeriod true if node to be parsed is a period inside DefinedValidityPeriodSet; false otherwise.
	 * @return dijoint interval with given intervals
	 * @throws PeriodDefinitionException
	 * @throws BadSyntaxException
	 */
	private RealTemporalInterval parseDisjoint(Node disjointNode){
		String name = null;
		ArrayList<RealTemporalInterval> intervals = new ArrayList<RealTemporalInterval>();
		NodeList disjointChilds = disjointNode.getChildNodes();
		for(int i=0; i<disjointChilds.getLength(); i++){
			Node child = disjointChilds.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE){
				if(child.getNodeName().equalsIgnoreCase(taNamespace+"ValidityPeriodName")){
					name = child.getTextContent().trim();
					RealTemporalInterval rti = definedPeriods.get(name);
					if(rti != null){
						intervals.add(rti);
					}else{
						throw new BadSyntaxException("ValidityPeriodName "+name+" doesn�t exist. A ValidityPeriodName must be defined before use it");
					}
					lastInterval = rti;
				}else if(child.getNodeName().equalsIgnoreCase(taNamespace+"Interval")){
					RealTemporalInterval rti = parseInterval(child, gmtZone, dateFormat);
					intervals.add(rti);
					lastInterval = rti;
				}else if(child.getNodeName().equalsIgnoreCase(taNamespace+"Periodical")){
					RealTemporalInterval rti = parsePeriodical(child, gmtZone, dateFormat);
					intervals.add(rti);
					lastInterval = rti;
				}else if(child.getNodeName().equalsIgnoreCase(taNamespace+"PeriodicalWeekly")){
					RealTemporalInterval rti = parsePeriodicalWeekly(child, gmtZone, dateFormat);
					intervals.add(rti);
					lastInterval = rti;
				}else if(child.getNodeName().equalsIgnoreCase(taNamespace+"Except")){
					intervals.add(parseExcept(child));
					// sacamos el �ltimo intervalo (lastInterval) del disjoint ya que en el
					// except ya se incluye, as� no duplicamos ese periodo
					intervals.remove(lastInterval);
				}
			}
		}
		DisjointRealTemporalInterval drti = new DisjointRealTemporalInterval(intervals);
		// Si el periodo que se ha parseado no est� dentro
		// de DefinedValidityPeriodSet le asignamos como nombre
		// el nombre del validityPeriodName
		
		// TODO por ahora, asumimos que los periodos s�lo pueden
		// definirse en el contexto dentro de DefinedValidityPeriodSet,
		// por lo que en los t�rminos s�lo se pueden hacer referencias
		// por su nombre a periodos ya definidos.
		// Si queremos permitir que se definan nuevos periodos en los
		// t�rminos, habr� que asignar como nombre el valor del atributo
		// 'name' del nodo ValidityPeriod.
		if(name != null){
			drti.setName(name);
		}
		return drti;
	}
	
	/**
	 * 
	 * @param interval dom node with information about an interval
	 * @return interval with given interval information
	 * @throws PeriodDefinitionException
	 * @throws BadSyntaxException
	 */
	private SingleRealTemporalInterval parseInterval(Node interval, String gmtZone, String dateFormat){
		Node initDateNode = interval.getAttributes().getNamedItem("initDate");
		Node endDateNode = interval.getAttributes().getNamedItem("endDate");
		if(initDateNode == null){
			throw new BadSyntaxException("initDate attribute is required inside an Interval element");
		}
		if(endDateNode == null){
			throw new BadSyntaxException("endDate attribute is required inside an Interval element");
		}
		String initDate = initDateNode.getNodeValue().trim();
		String endDate = endDateNode.getNodeValue().trim();
		
		Calendar initPoint = parseDate(initDate, gmtZone, dateFormat);
		Calendar endPoint = parseDate(endDate, gmtZone, dateFormat);
		// sumamos uno al resultado porque la fecha final tambi�n est� incluida
		long initPointMillis = initPoint.getTimeInMillis();
		long endPointMillis = endPoint.getTimeInMillis();
		Integer diasEntreFechas = (int) ((endPointMillis-initPointMillis)/MILLSECS_PER_DAY)+1;
		if(diasEntreFechas <= 0){
			throw new PeriodDefinitionException("Init date "+initDate+" is later than end date "+endDate);
		}
		SingleRealTemporalInterval result = new SingleRealTemporalInterval(initPoint, diasEntreFechas, TemporalMetric.DAYS);
		return result;
	}
	
	/**
	 * 
	 * @param periodical dom node with information about a periodical interval
	 * @return interval with given periodical interval information
	 * @throws PeriodDefinitionException
	 * @throws BadSyntaxException
	 */
	private SinglePeriodicRealTemporalInterval parsePeriodical(Node periodical, String gmtZone, String dateFormat){
		Node initHourNode = periodical.getAttributes().getNamedItem("initHour");
		Node endHourNode = periodical.getAttributes().getNamedItem("endHour");
		if(initHourNode == null){
			throw new BadSyntaxException("initHour attribute is required inside a Periodical element");
		}
		if(endHourNode == null){
			throw new BadSyntaxException("endHour attribute is required inside a Periodical element");
		}
		// el peri�dico empieza a una hora concreta, as� que tenemos que 
		// especificarla en el calendar
		SingleRealTemporalInterval srti = null;
		NodeList periodicalChilds = periodical.getChildNodes();
		for(int i=0; i<periodicalChilds.getLength(); i++){
			Node child = periodicalChilds.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE){
				if(child.getNodeName().equalsIgnoreCase(taNamespace+"Interval")){
					srti = parseInterval(child, gmtZone, dateFormat);
				}
			}
		}
		if(srti == null){
			throw new BadSyntaxException("Periodical elements must contain an interval element");
		}
		// parseamos las horas
		String initHourString = initHourNode.getNodeValue().trim();
		String endHourString = endHourNode.getNodeValue().trim();
		
		// en este caso, la duraci�n del periodo ser� la diferencia entre las horas,
		// la frecuencia es el tiempo entre el inicio de un periodo y el inicio de otro
		// que en este caso ser� siempre de un d�a
		// y el n�mero de repeticiones ser� el n�mero de d�as entre fechas, que ya
		// lo tenemos calculado en la duraci�n de srti
		Calendar initHour = parseHour(initHourString, gmtZone);
		Calendar endHour = parseHour(endHourString, gmtZone);
		Calendar initPoint = mixHourAndDate(srti.getInitialTimePoint(), initHour);
		// calculamos en segundos la diferencia entre las horas
		Integer diferenciaEntreHoras = (int) ((endHour.getTimeInMillis()-initHour.getTimeInMillis())/MILLSECS_PER_SECOND);
		TemporalMetric tempMetric = TemporalMetric.SECONDS;
		// si la diferencia entre horas es multiplo de 3600, pasamos a horas
		if(diferenciaEntreHoras % 3600 == 0){
			diferenciaEntreHoras = diferenciaEntreHoras / 3600;
			tempMetric = TemporalMetric.HOURS;
		}
		Integer duracion = diferenciaEntreHoras;
		Integer repeticiones = srti.getDuration();
		if(diferenciaEntreHoras < 0){
			// si la diferencia de horas es negativa suponemos que el periodo
			// contiene horas de dos d�as distintos, por ejemplo de 22:00
			// de un d�a cualquiera a las 8:00 del d�a siguiente
			// por lo tanto, la duraci�n del periodo ser�a 24+(resultadoNegativo)
			duracion = 24+diferenciaEntreHoras;
			// tambi�n en este caso, el n�mero de repeticiones ser�a la
			// duraci�n del Interval ya calculado menos uno. Si suponemos
			// un periodo entre 12:00 y 24:00 entre 10/11/2011 y 12/11/2011, las
			// repeticiones ser�an de 2, pero si fuera entre 22:00 y 8:00 entre 
			// 10/11/2011 y 12/11/2011, en n�mero de repeticiones ser�a de uno, ya que
			// la primera repetici�n empieza a las 22:00 del 10/11/2011 y termina a
			// las 8:00 del 11/11/2011, la segunda repetici�n empezar�a a las 22:00
			// del 11/11/2011 y terminar�a a las 8:00 del 12/11/2011 y esto se pasa
			// de la duraci�n del periodo
			repeticiones--;
		}else if(diferenciaEntreHoras == 0){
			throw new PeriodDefinitionException("There is no time between initHour: "+initHourString+" and endHour: "+endHourString);
		}
		SinglePeriodicRealTemporalInterval prti = new SinglePeriodicRealTemporalInterval(initPoint, duracion, tempMetric, repeticiones, 1, TemporalMetric.DAYS);
		
		return prti;
	}
	
	private RealTemporalInterval parsePeriodicalWeekly(Node periodicalWeekly, String gmtZone, String dateFormat){
		Node initDayNode = periodicalWeekly.getAttributes().getNamedItem("initDay");
		Node endDayNode = periodicalWeekly.getAttributes().getNamedItem("endDay");
		// endDay es opcional, por lo que puede ser null
		if(initDayNode == null){
			throw new BadSyntaxException("initDay attribute is required inside a PeriodicalWeekly element");
		}
		// parseamos el Periodic contenido obligatoriamente en PeriodicalWeekly
		SinglePeriodicRealTemporalInterval periodic = null;
		NodeList periodicalWeeklyChilds = periodicalWeekly.getChildNodes();
		for(int i=0; i<periodicalWeeklyChilds.getLength(); i++){
			Node child = periodicalWeeklyChilds.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE){
				if(child.getNodeName().equalsIgnoreCase(taNamespace+"Periodical")){
					periodic = parsePeriodical(child, gmtZone, dateFormat);
				}
			}
		}
		if(periodic == null){
			throw new BadSyntaxException("PeriodicalWeekly elements must contain a Periodical element");
		}
		// parseamos los d�as
		String initDayString = initDayNode.getTextContent().trim();
		if(endDayNode == null){ // solo se repite un d�a a la semana
			SinglePeriodicRealTemporalInterval result = parseOnceAWeekPeriodic(initDayString, periodic);
			return result;
		}else{ // se repite varios d�as a la semana
			String endDayString = endDayNode.getTextContent().trim();
			// por cada d�a que se repite sacamos un periodo, 
			// y metemos cada uno de ellos en un disjoint de peri�dicos
			ArrayList<RealTemporalInterval> periodicIntervalsList = new ArrayList<RealTemporalInterval>();
			// para saber que d�as se repite hacemos resta entre los d�as
			Integer initDay = parseDay(initDayString);
			Integer endDay = parseDay(endDayString);
			Integer diff = endDay - initDay;
			if(diff == 0){
				throw new PeriodDefinitionException("There aren�t days between initDay: "+initDayString+" and endDay: "+endDayString);
			}else if(diff > 0){
				for(int i=initDay; i<=endDay; i++){
					SinglePeriodicRealTemporalInterval sprti = parseOnceAWeekPeriodic(parseDay(i), periodic);
					periodicIntervalsList.add(sprti);
				}
			}else if(diff < 0){ // este caso ser�a por ejemplo, de SAT a TUE
				// recorremos desde inicio del periodo hasta el final de la semana
				// y luego desde el inicio de la semana hasta el final del periodo
				for(int i=initDay; i<=Calendar.SATURDAY; i++){
					SinglePeriodicRealTemporalInterval sprti = parseOnceAWeekPeriodic(parseDay(i), periodic);
					periodicIntervalsList.add(sprti);
				}
				for(int i=Calendar.SUNDAY; i<=endDay; i++){
					SinglePeriodicRealTemporalInterval sprti = parseOnceAWeekPeriodic(parseDay(i), periodic);
					periodicIntervalsList.add(sprti);
				}
			}
			DisjointRealTemporalInterval result = new DisjointRealTemporalInterval(periodicIntervalsList);
			return result;
		}
	}
	
//	private TemporalMetric parseTemporalMetric(String temporalMetricInput){
//		TemporalMetric temporalMetric = null;
//		if(temporalMetricInput.equalsIgnoreCase("seconds")){
//			temporalMetric = TemporalMetric.SECONDS;
//		}else if(temporalMetricInput.equalsIgnoreCase("days")){
//			temporalMetric = TemporalMetric.DAYS;
//		}else if(temporalMetricInput.equalsIgnoreCase("hours")){
//			temporalMetric = TemporalMetric.HOURS;
//		}else if(temporalMetricInput.equalsIgnoreCase("months")){
//			temporalMetric = TemporalMetric.MONTHS;
//		}else{
//			System.err.println(temporalMetricInput+" is not a valid DurationMetric value. Valid ones are Seconds, Days, Hours and Months");
//		}
//		return temporalMetric;
//	}
	
	/**
	 * 
	 * @param day day of the week as a string. Supported values: MON, TUE, WED, THU, FRI, SAT, SUN
	 * @param periodic this interval will be repeated once a week 
	 * @return a periodic interval as the given periodic but repeated once a week instead of every day
	 * @throws PeriodDefinitionException
	 * @throws BadSyntaxException
	 */
	private SinglePeriodicRealTemporalInterval parseOnceAWeekPeriodic(String day, SinglePeriodicRealTemporalInterval periodic){
		Integer initDay = parseDay(day);
		Calendar initDate = (Calendar) periodic.getInitialTimePoint().clone();
		Calendar endDate = (Calendar) initDate.clone();
		// a�adimos a endDate las horas que tenga initDate para que luego
		// el c�lculo de la diferencia de d�as entre ellas sea de d�as 
		// exactos
		endDate.add(Calendar.DAY_OF_MONTH, periodic.getRepetitions()-1);
		if(periodic.getDurationMetric().equals(TemporalMetric.SECONDS)){
			endDate.add(Calendar.SECOND, periodic.getDuration());
		}else if(periodic.getDurationMetric().equals(TemporalMetric.HOURS)){
			endDate.add(Calendar.HOUR_OF_DAY, periodic.getDuration());
		}
		// el inicio del periodo ser� el primer d�a desde el inicio del intervalo
		// que coincida con initDay
		Integer dayOfWeek = initDate.get(Calendar.DAY_OF_WEEK);
		Integer diff = initDay - dayOfWeek;
		if(diff < 0){
			diff += 7;
		}
		initDate.add(Calendar.DAY_OF_WEEK, diff);			
		// el n�mero de repeticiones es el n�mero de initDay que hay entre
		// las fechas del intervalo. Para calcularlo, cogemos el n�mero de d�as
		// entre initDate y endDate, y lo dividimos entre 7; el cociente ser�
		// nuestro resultado
		Integer repeticiones = (int) (((endDate.getTimeInMillis()-initDate.getTimeInMillis())/MILLSECS_PER_DAY)/7)+1;
		if(repeticiones <= 0){
			throw new PeriodDefinitionException("There isn�t a "+day+" between initDate and endDate");
		}
		// la duraci�n ser� la misma que la del Periodic
		// la frequencia ser� de una semana ya que endDay es null
		return new SinglePeriodicRealTemporalInterval(initDate, periodic.getDuration(), periodic.getDurationMetric(), repeticiones, 7, TemporalMetric.DAYS);
	}
	
	private RealTemporalInterval parseExcept(Node exceptNode) throws BadSyntaxException, PeriodDefinitionException{
		RealTemporalInterval exceptInterval = null;
		String validityPeriodName = null;
		NodeList exceptChilds = exceptNode.getChildNodes();
		for(int i=0; i<exceptChilds.getLength(); i++){
			Node child = exceptChilds.item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE){
				if(child.getNodeName().equalsIgnoreCase(taNamespace+"ValidityPeriodName")){
					validityPeriodName = child.getTextContent().trim();
					RealTemporalInterval rti = definedPeriods.get(validityPeriodName);
					if(rti != null){
						exceptInterval = rti;
					}else{
						throw new BadSyntaxException("ValidityPeriodName "+validityPeriodName+" doesn�t exist. A ValidityPeriodName must be defined before use it");
					}
				}else if(child.getNodeName().equalsIgnoreCase(taNamespace+"Interval")){
					exceptInterval = parseInterval(child, gmtZone, dateFormat);
				}else if(child.getNodeName().equalsIgnoreCase(taNamespace+"Periodical")){
					exceptInterval = parsePeriodical(child, gmtZone, dateFormat);
				}else if(child.getNodeName().equalsIgnoreCase(taNamespace+"PeriodicalWeekly")){
					exceptInterval = parsePeriodicalWeekly(child, gmtZone, dateFormat);
				}
			}
		}
		DisjointTemporalInterval dti1 = new DisjointTemporalInterval(this.lastInterval.toDisjointTemporalInterval());
		DisjointTemporalInterval dti2 = new DisjointTemporalInterval(exceptInterval.toDisjointTemporalInterval());
		DisjointTemporalInterval exceptResult = dti1.except(dti2);
		
		if(dti1.equals(exceptResult)){
			if(validityPeriodName != null && this.lastInterval.getName() != null){
				String first = this.lastInterval.getName();
				String second = validityPeriodName;
				throw new PeriodDefinitionWarningException(second+" period does not overlaps with "+first+". Then, '"+first+" except "+second+"' returns the "+first+" period because it is a 'out-ranged' except. You may remove the except clause.");
			}else{
				throw new PeriodDefinitionWarningException("B period does not overlaps with A. Then, 'A except B' returns the A period because it is a 'out-ranged' except. You may remove the except clause.");
			}
		}
		
		if(exceptResult.isEmpty()){
			if(validityPeriodName != null && this.lastInterval.getName() != null){
				String first = this.lastInterval.getName();
				String second = validityPeriodName;
				throw new PeriodDefinitionWarningException(first+" period is covered by "+second+". Then '"+first+" except "+second+"' returns an empty period because it is a 'full-ranged' except. You may revise the except clause.");
			}else{
				throw new PeriodDefinitionWarningException("A period is covered by B. Then 'A except B' returns an empty period because it is a 'full-ranged' except. You may revise the except clause.");
			}
		}
		return new ExceptRealTemporalInterval(this.lastInterval, exceptInterval);
	}
	
	/**
	 * 
	 * @param dateString date in the format MM/DD/YYYY or DD/MM/YYYY
	 * @return calendar with the given date
	 * @throws BadSyntaxException 
	 */
	private static Calendar parseDate(String dateString, String gmtZone, String dateFormat){
//		Calendar result = Calendar.getInstance(TimeZone.getTimeZone("GMT"+gmtZone));
		DateFormat formatter = null;
		// solo permitimos los formatos MM/DD/YYYY y DD/MM/YYYY
		// le a�adimos el gmt zone para el parseo
		dateString = dateString+":GMT"+gmtZone;
		if(dateFormat.equalsIgnoreCase("MM/DD/YYYY")){
			formatter = new SimpleDateFormat("MM/dd/yyyy");
		}else if(dateFormat.equalsIgnoreCase("DD/MM/YYYY")){
			formatter = new SimpleDateFormat("dd/MM/yyyy");
		}
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"+gmtZone));
		Date date;
		try{
			date = formatter.parse(dateString);
		}catch(ParseException e){
			e.printStackTrace();
			throw new BadSyntaxException("There was a problem parsing "+dateString);
		}catch(NullPointerException e){
			throw new BadSyntaxException("There was a problem parsing DateFormat. Just MM/DD/YYYY and DD/MM/YYYY patterns can be used");
		}
		Calendar result = Calendar.getInstance();
		result.setTime(date);
		return result;
	}
	
	/**
	 * 
	 * @param hourString hour in format HH:MM
	 * @return a calendar with hour and a generic date
	 * @throws BadSyntaxException
	 */
	private Calendar parseHour(String hourString, String gmtZone){
		Calendar result = Calendar.getInstance(TimeZone.getTimeZone("GMT"+gmtZone));
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		Date hour;
		try {
			hour = formatter.parse(hourString);
		} catch (ParseException e) {
			throw new BadSyntaxException("There was a problem parsing "+hourString+". Format must be HH:MM");
		}
		result.setTime(hour);
		return result;
	}
	
	/**
	 * 
	 * @param dayString day of week: MON, TUE, WED, THU, FRI, SAT, SUN
	 * @return value of the day of week indicated by Calendar
	 * @throws BadSyntaxException 
	 */
	private Integer parseDay(String dayString){
		Integer result = -1;
		if(dayString.equalsIgnoreCase("MON")){
			result = Calendar.MONDAY;
		}else if(dayString.equalsIgnoreCase("TUE")){
			result = Calendar.TUESDAY;
		}else if(dayString.equalsIgnoreCase("WED")){
			result = Calendar.WEDNESDAY;
		}else if(dayString.equalsIgnoreCase("THU")){
			result = Calendar.THURSDAY;
		}else if(dayString.equalsIgnoreCase("FRI")){
			result = Calendar.FRIDAY;
		}else if(dayString.equalsIgnoreCase("SAT")){
			result = Calendar.SATURDAY;
		}else if(dayString.equalsIgnoreCase("SUN")){
			result = Calendar.SUNDAY;
		}else{
			throw new BadSyntaxException(dayString+" isn�t a valid day of the week. Just MON, TUE, WED, THU, FRI, SAT and SUN are supported");
		}
		return result;
	}
	
	private String parseDay (Integer day){
		String result = null;
		switch(day){
			case Calendar.SUNDAY: result = "SUN"; break;
			case Calendar.MONDAY: result = "MON"; break;
			case Calendar.TUESDAY: result = "TUE"; break;
			case Calendar.WEDNESDAY: result = "WED"; break;
			case Calendar.THURSDAY: result = "THU"; break;
			case Calendar.FRIDAY: result = "FRI"; break;
			case Calendar.SATURDAY: result = "SAT"; break;
		}
		if(result == null){
			throw new BadSyntaxException();
		}
		return result;
	}
	
	/**
	 * Creates a new Calendar with day, month and year from given date and hour and minute from given hour
	 * @param date Calendar with day, month and year
	 * @param hour Calendar with hour and minute
	 * @return new Calendar with day, month and year from given date and hour and minute from given hour
	 */
	private Calendar mixHourAndDate(Calendar date, Calendar hour){
		date.set(Calendar.HOUR_OF_DAY, hour.get(Calendar.HOUR_OF_DAY));
		date.set(Calendar.MINUTE, hour.get(Calendar.MINUTE));
		return date;
	}

	@Override
	public void resetDefinedPeriods() {
		this.definedPeriods.clear();
	}

	@Override
	public void setGMTZone(String gmtZone) {
		this.gmtZone = gmtZone;
	}

	@Override
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	@Override
	public void setTimeAwareNamespace(String namespace){
		this.taNamespace = namespace;
	}
}

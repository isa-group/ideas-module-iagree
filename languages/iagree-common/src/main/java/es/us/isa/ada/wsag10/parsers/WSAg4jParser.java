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

import java.util.HashSet;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.us.isa.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ada.wsag10.Item;
import es.us.isa.ada.wsag10.Location;
import es.us.isa.ada.wsag10.Restriction;
import es.us.isa.ada.wsag10.ServiceDescriptionTerm;
import es.us.isa.ada.wsag10.ServiceProperties;
import es.us.isa.ada.wsag10.Term;
import es.us.isa.ada.wsag10.Variable;
import es.us.isa.ada.wsag10.domain.Domain;

public class WSAg4jParser extends AbstractWsagParser {

	private String auxDocument;

	@Override
	protected SDTParser initSDTParser() {
		return new ADASDTParser();
	}
	
	@Override
	protected TimeAwareParser initTimeAwareParser(){
		return new DefaultTimeAwareParser();
	}

	public AbstractAgreementDocument parseFile(String agFileName, String... options) {
		if (options.length == 1) {
			// la ruta al archivo de properties
			// o a otro archivo que referenciemos
			// con expresiones XQuery
			auxDocument = options[0];
		}
		return super.parseFile(agFileName, options);
	}

	protected Item parseItem(Node nextNodeCC){
		//XXX Si el item es analizable por ADA, lo parseamos
		//sino devolvemos un item vac�o con Analysable = false
		Item res = new Item();
		Boolean isAnalysableNodeExists = false;
		NodeList itemChilds = nextNodeCC.getChildNodes();
		for(int i=0; i<itemChilds.getLength() && !isAnalysableNodeExists; i++){
			Node itemChild = itemChilds.item(i);
			if(itemChild.getNodeType() == Node.ELEMENT_NODE){
				if(itemChild.getNodeName().equalsIgnoreCase("ada:analysable")){
					isAnalysableNodeExists = true;
					String isAnalysableString = itemChild.getAttributes().getNamedItem("value").getTextContent();
					if(isAnalysableString.equalsIgnoreCase("true")){
						res = super.parseItem(nextNodeCC);
					}//en otro caso ya tenemos la variable a false
				}
			}
		}
		if(!isAnalysableNodeExists){
			res.setAnalysable(false);
		}
		return res;
	}

	protected ServiceProperties parseSP(List<Term> node, Node nextNode) {
		// XXX variacion en el parseo: Service Properties
		ServiceProperties sp = new ServiceProperties();
		sp.setTermName(nextNode.getAttributes().getNamedItem("wsag:Name").getNodeValue());
		sp.setServiceName(nextNode.getAttributes().getNamedItem("wsag:ServiceName").getNodeValue());

		NodeList servicePropertiesRootNodes = nextNode.getChildNodes();
		Node rootServiceProperties = servicePropertiesRootNodes.item(1);

		// creamos un SDT con el mismo nombre, en el cual
		// almacenaremos las asignaciones hechas con los location
		ServiceDescriptionTerm sdt = null;

		if (!rootServiceProperties.getNodeName().equalsIgnoreCase("wsag:VariableSet")) {

		} else {
			// System.out
			// .println("La estructura del service properties es correcta");
			NodeList variableNodes = rootServiceProperties.getChildNodes();
			// ////System.out.println(variableNodes.getLength());
			HashSet<Variable> variables = new HashSet<Variable>();
			for (int j = 0; j < variableNodes.getLength(); j++) {
				Node nextVarNode = variableNodes.item(j);
				// ////System.out.println(serviceFeaturesNodes.item(j).getNodeName());
				if (nextVarNode.getNodeType() == Node.ELEMENT_NODE) {
					Variable v = new Variable();
					v.setUniqueName(nextVarNode.getAttributes().getNamedItem("wsag:Name").getNodeValue());
					// ////System.out.println(v.getUniqueName);
					String metricStr = nextVarNode.getAttributes().getNamedItem("wsag:Metric").getNodeValue();

					MetricParser metricParser = new ADAMetricParser();
					Domain d = metricParser.getValue(metricStr);
					v.setDomain(d);

					NodeList locationNodes = nextVarNode.getChildNodes();
					for (int k = 0; k < locationNodes.getLength(); k++) {
						Node locationNode = locationNodes.item(k);
						if ((locationNode.getNodeType() == Node.ELEMENT_NODE) && (locationNode.getNodeName().equalsIgnoreCase("wsag:Location"))) {

							if (auxDocument != null) {

								if (sdt == null) {
									// si es el primer location al que
									// accedemos, inicializamos este sdt
									// de mentira
									sdt = new ServiceDescriptionTerm();
									sdt.setName(sp.getTermName());
									sdt.setServiceName(sp.getServiceName());
								}

								String expr = locationNode.getTextContent();
								v.setLocation(new Location(expr));

								LocationLinker locLinker = new Wsag4jLocationLinker();

								// asignamos el valor recuperado al sdt
								// ficticio creado
								String s = locLinker.parseLocation(expr, auxDocument);
								System.out.println("Location en docs WSAG4J: " + s);
								Restriction r = new Restriction();
								r.setFixedValue(s);
								// sdt.setFeature(v, r);
								// o esto?
								sdt.setFeature(v.getName(), r);
							}

						}
					}
					variables.add(v);
					vars.put(v.getName(), v);

				}

			}
			sp.setVariableSet(variables);
		}
		if (node == null) {
			// docTerms.getRoot().addElement(sp);
			docTerms.addComprisedTerm(sp);
			docTerms.addComprisedTerm(sdt);
		} else {
			node.add(sp);
			if (sdt != null) {
				node.add(sdt);
			}
		}
		return sp;
	}

}

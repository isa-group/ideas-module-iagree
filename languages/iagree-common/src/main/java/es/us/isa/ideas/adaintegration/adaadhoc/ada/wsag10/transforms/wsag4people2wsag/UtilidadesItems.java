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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.transforms.wsag4people2wsag;

import java.util.LinkedList;


public class UtilidadesItems {

	String recorrido = "";
	
	public static String imprimeItems(LinkedList<Item> listaItems){
		String resultado = "";
		//primero crearemos un item ALL que será el padre de todos recorreremos la lista Items buscando a los padres de cada elemento y los iremos añadiendo
		// a su lista de hijos para luego imprimirlo en orden
		
		Item padre = new Item();
		padre.setNombre("all");
		padre.setPrefijo("0");
		String valorDeBusqueda = "";
		boolean enc = false;
		
		for(int i = 0 ; i < listaItems.size(); i++){
			
			valorDeBusqueda = valorDeBusqueda(listaItems.get(i).getPrefijo());
			if(valorDeBusqueda.equals("0")){
				padre.agregaHijo(listaItems.get(i));
			}else{
				enc = false;
				for(int j = 0; j < listaItems.size() && !enc; j++){
					if(listaItems.get(j).getPrefijo().equals(valorDeBusqueda)){
						enc = true;
						listaItems.get(j).agregaHijo(listaItems.get(i));
					}
				}
			}
			
			
		}
		//Ahora recorremos el item padre y cuadno encontrmeos un ALL, ExactlyONe o OneOrmore pues extendemos a sus hijos
		
  	//resultado = "<wsag:All>"+recorre(padre.getHijos())+"\n</wsag:All>";
		resultado =recorre(padre.getHijos(),7);
		//System.out.println("RESULTADO:\n"+resultado+"\nFIN RESULTADO");
		return resultado;
		
		
	}
	
	private static String recorre(LinkedList<Item> hijos,int numEspacios){
		String resultado = "";
		for(int i = 0; i < hijos.size();i++){
			if(hijos.get(i).getNombre().equals("all")){
				resultado += "\n"+espaciado(numEspacios)+"<wsag:All>\n"+recorre(hijos.get(i).getHijos(),numEspacios+2)+"\n"+espaciado(numEspacios)+"</wsag:All>";
			}else if(hijos.get(i).getNombre().equals("eob")){
				resultado += "\n"+espaciado(numEspacios)+"<wsag:ExactlyOne>\n"+recorre(hijos.get(i).getHijos(),numEspacios+2)+"\n"+espaciado(numEspacios)+"</wsag:ExactlyOne>";
			}else if(hijos.get(i).getNombre().equals("omb")){
				resultado += "\n"+espaciado(numEspacios)+"<wsag:OneOrMore>\n"+recorre(hijos.get(i).getHijos(),numEspacios+2)+"\n"+espaciado(numEspacios)+"</wsag:OneOrMore>"; 
			}else{
				resultado +=agregaEspacios(hijos.get(i).getContenido(),numEspacios);
			}
			
		}
		
		
		
		return resultado;
	}
	
	private static String valorDeBusqueda(String prefijo){
		String resultado = "0";
		
		for(int i = prefijo.length()-1; i >= 0 && resultado.equals("0") ; i--){
			if ('.' == prefijo.charAt(i)){
				resultado = prefijo.substring(0,i);
				
			}
			
			
		}
		//System.out.println("PREFIJO:"+resultado);
		
		return resultado;
		
	}
	
	public static String eliminaMayorYMenor(String texto){
		String stringAdaptado ="";
		for(int i = 0; i <texto.length();i++){
			if(texto.charAt(i) == '>'){
				stringAdaptado+= "&gt;";
			}else if(texto.charAt(i) == '<'){
				stringAdaptado+="&lt;";
				
			}else
				stringAdaptado+=texto.charAt(i);
			
		}
		return stringAdaptado;
	}
	
	
	public static String espaciado( int num){
		String resultado= "";
		for(int x = 0; x < num; x++){
			resultado+=" ";
		}
		return resultado;
	}
	
	//Esta función coge los \n y le agrega tantos espacio para tabular los diferentes elementos
	public static String agregaEspacios(String s,int numEspacios){
		String resultado= "";
		for(int i =0 ; i < s.length();i++){
			if(s.charAt(i)=='\n'){
				resultado+="\n"+espaciado(numEspacios);
			}else{
				resultado+=s.charAt(i);
			}
		}
		
		return resultado;
		
	}
}

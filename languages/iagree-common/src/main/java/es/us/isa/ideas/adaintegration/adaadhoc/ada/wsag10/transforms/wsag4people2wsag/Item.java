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


public class Item {

	
	private LinkedList<Integer> listaNumeros;
	private String nombre;
	private String contenido;
	private String prefijo;
	private LinkedList<Item> hijos;
	
	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public Item (){
		listaNumeros = new LinkedList<Integer>();
		nombre = "";
		contenido = "";
		prefijo = "";
		hijos = new LinkedList<Item>();
	}
	
	public Item(LinkedList<Integer> lista, String nombre, String contenido, String prefijo){
		listaNumeros = lista;
		this.nombre = nombre;
		this.contenido = contenido;
		this.prefijo = prefijo;
	}
	
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public LinkedList<Integer> getListaNumeros() {
		return listaNumeros;
	}
	public void setListaNumeros(LinkedList<Integer> listaNumeros) {
		this.listaNumeros = listaNumeros;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void agregaNumerosALista(String numero){
		int j = 0;
		//System.out.println("Nuevo tema :)");
		for(int i = 0 ; i < numero.length();i++){
			if('.' == numero.charAt(i)){
				Integer entero = new Integer (numero.substring(j, i));
				j = i+1;
				listaNumeros.add(entero);
				System.out.println(entero.intValue()+"weee");
			}
			
		}
		Integer entero = new Integer (numero.substring(j, numero.length()));
		listaNumeros.add(entero);
		//System.out.println(entero.intValue()+"weee");
	}

	public LinkedList<Item> getHijos() {
		return hijos;
	}

	public void setHijos(LinkedList<Item> hijos) {
		this.hijos = hijos;
	}
	public void agregaHijo(Item i){
		
		hijos.add(i);
	}
	
	public int numeroHijos(){
		
		return hijos.size();
	}
	
}

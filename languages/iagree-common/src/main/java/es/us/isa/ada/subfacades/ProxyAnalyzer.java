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

package es.us.isa.ada.subfacades;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import es.us.isa.ada.Analyzer;
import es.us.isa.ada.Operation;

/**
 * Clase que encapsula un analizador y todas sus operaciones
 * @author Jesus
 *
 */
public class ProxyAnalyzer {
	
	private String id;
	private Analyzer an;
	//nombreInterfaz -> nombreClaseImpl
	private Map<String,Class<? extends Operation>> opsImpls;
	
	public ProxyAnalyzer(String id, Analyzer an){
		this(id, an, new HashMap<String,Class<? extends Operation>>());
	}
	
	public ProxyAnalyzer(String id, Analyzer an, 
			Map<String,Class<? extends Operation>> opsImpls){
		this.id = id;
		this.an = an;
		this.opsImpls = opsImpls;
	}
	
	public void addOperation(String interfaceName, Class<? extends Operation> impl){
		opsImpls.put(interfaceName, impl);
	}
	
	public boolean hasOperation(String id){
//		String interfaceName = op.getName();
		return opsImpls.containsKey(id);
	}
	
	public Operation createOperation(String id){
		Class<? extends Operation> c = opsImpls.get(id);
		Operation res = null;
		if (c != null){
			try {
				res = c.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public boolean isMine(Operation op){
		Collection<Class<? extends Operation>> values = opsImpls.values();
		Class<? extends Operation> c = op.getClass();
		return values.contains(c);
	}
	
	public void analyze(Operation op){
		an.analyze(op);
	}
	
	public String getId(){
		return id;
	}
	
	public boolean equals(Object obj){
		boolean res = false;
		if (obj instanceof ProxyAnalyzer){
			ProxyAnalyzer p = (ProxyAnalyzer) obj;
			if (p.getId().equals(id)){
				res = true;
			}
		}
		return res;
	}
	
}

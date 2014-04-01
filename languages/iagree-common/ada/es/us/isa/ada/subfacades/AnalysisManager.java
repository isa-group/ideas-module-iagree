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
import java.util.Iterator;
import java.util.Map;

import es.us.isa.ada.Operation;
import es.us.isa.ada.document.OperationParameters;
import es.us.isa.ada.selectors.SelectorCriteria;

/**
 * Fachada del subsistema encargado de coordinar las tareas de analisis
 * de documentos de acuerdo
 * @author Jesus
 *
 */
public class AnalysisManager {
	
	//id operacion -> Class interfaz
//	private Map<String,Class<? extends Operation>> operationsId;
	
	private Collection<ProxyAnalyzer> proxys;
	
	private SelectorCriteria selector;
	
//	private Map<String,OperationParameters> opParams;
	
	
	public AnalysisManager(Collection<ProxyAnalyzer> proxys, 
			SelectorCriteria selector) {
		this.proxys = proxys;
		this.selector = selector;
	}
	

	public SelectorCriteria getSelector() {
		return selector;
	}

	

	public void setSelector(SelectorCriteria selector) {
		this.selector = selector;
	}

	public void analyze(Operation op){
		Iterator<ProxyAnalyzer> it = proxys.iterator();
		boolean enc = false;
		while (it.hasNext() && !enc){
			ProxyAnalyzer pan = it.next();
			if (pan.isMine(op)){
				pan.analyze(op);
				enc = true;
			}
		}
	}
	
	public Operation createQuestion(String id){
		Operation op = null;
//		Class<? extends Operation> c = operationsId.get(id);
		if (id != null){
			ProxyAnalyzer pan = selector.selectAnalyzer(id, proxys);
			op = pan.createOperation(id);
		}
		return op;
	}

}

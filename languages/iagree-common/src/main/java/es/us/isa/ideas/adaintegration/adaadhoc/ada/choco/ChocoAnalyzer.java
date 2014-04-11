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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.choco;

import java.util.Collection;
import java.util.Iterator;

import choco.cp.model.CPModel;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.Analyzer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.Operation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;

public class ChocoAnalyzer extends Analyzer{

	
	public Model chocoProblem;
	
	public ChocoAnalyzer(){
		reset();
	}
	
	//TODO como vamos a hacer el mapeo?
	public void reset(){
		chocoProblem = new CPModel();
	}
	
	@Override
	public void analyze(Operation op) {
		reset();
		if (op instanceof ChocoOperation){
			ChocoOperation chop = (ChocoOperation) op;
			chop.execute(this);
		}
		else{
			//error
		}
		
	}
	
	public void addToChoco(AbstractDocument d){
		chocoProblem = new CPModel();
		ChocoTranslator translator = new ChocoTranslator(d);
		translator.translate();
		Collection<Variable> vars = translator.getChocoVars().values();
		Collection<Constraint> constraints = translator.getChocoConstraints().values();
		
		Iterator<Variable> itVars = vars.iterator();
		while (itVars.hasNext()){
			Variable v = itVars.next();
			chocoProblem.addVariable(v);
		}
		
		Iterator<Constraint> itCons = constraints.iterator();
		while (itCons.hasNext()){
			Constraint c = itCons.next();
			chocoProblem.addConstraint(c);
		}
		
		//TODO guardar el mapeo despues de esto
	}
	
	
	public Model getChocoProblem(){
		return chocoProblem;
	}
	
	public Model getChocoProblem(Collection<Constraint> constraints){
		CPModel problem = new CPModel();
		Iterator<Constraint> it = constraints.iterator();
		while (it.hasNext()){
			Constraint c = it.next();
			problem.addConstraint(c);
		}
		return problem;
	}

}

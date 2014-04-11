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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.translators;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import choco.Choco;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.model.variables.real.RealVariable;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceDescriptionTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceReference;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.StringSLO;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.TermCompositor;

public class ChocoTranslator4Alternative {

	private AbstractAgreementDocument doc;
	private Collection<Constraint> chocoConstraints;
	private Map<IntegerVariable, Term> varsToTerms;
	//XXX con este atributo a cierto, mapeamos los term compositor OneOrMore como All
	private boolean orToAnd;

	public ChocoTranslator4Alternative(AbstractDocument d) {
		this(d,false);
	}
	
	public ChocoTranslator4Alternative(AbstractDocument d, boolean orToAnd) {
		doc = (AbstractAgreementDocument) d;
		this.orToAnd = orToAnd;
		reset();
	}

	protected void reset() {
		varsToTerms = new HashMap<IntegerVariable, Term>();
		chocoConstraints = new LinkedList<Constraint>();
	}

	public void translate() {

		Term term = doc.getTerms();
		IntegerVariable var = termToChoco(term);
		chocoConstraints.add(Choco.eq(var, 1));

	}

	protected IntegerVariable termToChoco(Term term) {
		IntegerVariable res = null;
		
		if (term instanceof TermCompositor) {
			TermCompositor compositor = (TermCompositor) term;

			List<Term> termList = compositor.getComprisedTerms();
			Iterator<Term> it = termList.iterator();
			IntegerVariable[] array = new IntegerVariable[termList.size()];
			int i = 0;

			while (it.hasNext()) {
				Term t = it.next();
				IntegerVariable aux = termToChoco(t);
				array[i] = aux;
				i++;

			}
			IntegerExpressionVariable iev = Choco.sum(array);
			res = Choco.makeBooleanVar(term.getName());
			Constraint c = null;
			String type = compositor.getType();

			if (type.equals(TermCompositor.ALL)) {
				
				c = Choco.ifThenElse(Choco.eq(res, 1), Choco.eq(iev,
						array.length),Choco.eq(iev,0));
				
			} else if (type.equals(TermCompositor.EXACTLY_ONE)) {
				
				c = Choco.ifThenElse(Choco.eq(res, 1), Choco.eq(iev, 1),Choco.eq(iev,0));
			
			} else if (type.equals(TermCompositor.ONE_OR_MORE)) {
				
				if (orToAnd){
					c = Choco.ifThenElse(Choco.eq(res, 1), Choco.eq(iev,
							array.length),Choco.eq(iev,0));
				}
				else{
					c = Choco.ifThenElse(Choco.eq(res, 1), Choco.geq(iev, 1),Choco.eq(iev,0));
				}
				
			}
			
			chocoConstraints.add(c);

		} else {
			res = Choco.makeBooleanVar(term.getName());
			varsToTerms.put(res, term);
		}
		return res;
	}

	public Collection<Constraint> getChocoConstraints() {
		return chocoConstraints;
	}

	public Map<IntegerVariable, Term> getVarsToTerms() {
		return varsToTerms;
	}
	

}

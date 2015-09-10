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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.antlr;

import java.io.ByteArrayInputStream;
import java.util.Map;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import antlr.collections.AST;
import antlr.debug.misc.ASTFrame;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.utils.ParsingResult;

//TODO hay que tocar en el parser para cambiar las constantes enumeradas
//por su valor
public class ChocoParser {

	private Map<String,Variable> vars;

	public ParsingResult parseConstraint(String c){
		ParsingResult res = null;
		if (c == null){
			System.err.println("Atencion, se esta intentando parsear un string null a constraint!");
			return null;
		}
		ByteArrayInputStream fis = new ByteArrayInputStream(c.getBytes());
		ChocoAnalex analex = new ChocoAnalex(fis);
		ChocoAnasint anasint = new ChocoAnasint(analex);
		AST arbol = null;
		
		try {
			anasint.expresion();
			arbol = anasint.getAST();
//			ASTFrame frame = new ASTFrame("arbol",arbol);
//			frame.setVisible(true);
			ChocoTreeParser anasem = new ChocoTreeParser(); 
//			anasem.setVars(vars);
			res = anasem.entrada(arbol,vars);
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (TokenStreamException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void setVariables(Map<String,Variable> v){
		vars = v;
	}
	
}

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



import antlr.*;
import antlr.collections.*;

public class MyTree extends CommonAST{
	int linea;
		
	public MyTree(){}
	
	public MyTree(Token t)
	{
		initialize(t);
	}
	
	public MyTree(AST a)
	{
		initialize(a);
	}
	
	public void initialize(Token t)
	{
		super.initialize(t);
		setLine(t.getLine());
		
	}
	
	public void initialize(AST a)
	{
		super.initialize(a);
		if(a instanceof MyTree){
			setLine(((MyTree) a).getLine());
		
		}
	}
	
	public void setLine(int l){
		linea = l;
	}
	

	
	public int getLine(){
		return linea;
	}
	

}

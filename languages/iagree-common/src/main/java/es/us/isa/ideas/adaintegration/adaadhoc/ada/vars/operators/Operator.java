package es.us.isa.ideas.adaintegration.adaadhoc.ada.vars.operators;
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

//package es.us.isa.ada.vars.operators;
//
//public class Operator {
//
//	/*
//	 * Operator types
//	 */
//	
//	//logicals
//	public static final int NOT = 0;
//	
//	public static final int AND = 1;
//	
//	public static final int OR = 2;
//	
//	public static final int IMPLIES = 3;
//	
//	public static final int IF_ONLY_IF = 4;
//	
//	//relationals
//	public static final int GREATER = 5;
//	
//	public static final int GREATER_EQUAL = 6;
//	
//	public static final int LESS = 7;
//	
//	public static final int LESS_EQUAL = 8;
//	
//	public static final int EQUAL = 9;
//	
//	public static final int NON_EQUAL = 10;
//	
//	//arithmetics
//	public static final int PLUS = 11;
//	
//	public static final int MINUS = 12;
//	
//	public static final int MULT = 13;
//	
//	public static final int DIV = 14;
//	
//	public static final int MOD = 15;
//	
//	public static final int POWER = 16;
//	
//	
//	private int operator;
//	
//	
//	public boolean isArithmetic(){
//		return ((operator >= PLUS) && (operator <= POWER));
//	}
//	
//	public boolean isRelational(){
//		return ((operator >= GREATER) && (operator <= NON_EQUAL));
//	}
//	
//	public boolean isLogical(){
//		return ((operator >= NOT) && (operator <= IF_ONLY_IF));
//	}
//	
//	public int getOperator(){
//		return operator;
//	}
//	
//}

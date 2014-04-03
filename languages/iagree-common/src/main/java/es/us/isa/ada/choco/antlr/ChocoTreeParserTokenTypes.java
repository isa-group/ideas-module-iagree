// $ANTLR 2.7.7 (20060906): "ChocoTreeParser.g" -> "ChocoTreeParser.java"$

	package es.us.isa.ada.choco.antlr;
	import es.us.isa.ada.choco.utils.ParsingResult;
	import es.us.isa.ada.wsag10.domain.*;
	import es.us.isa.ada.choco.utils.Utils;
	import java.util.*;	
	import choco.Choco;
	import choco.kernel.model.constraints.Constraint;
	import choco.kernel.model.variables.Variable;
	import choco.kernel.model.variables.integer.IntegerVariable;
	import choco.kernel.model.variables.integer.IntegerConstantVariable;
	import choco.kernel.model.variables.real.*;
	import choco.kernel.model.variables.integer.IntegerExpressionVariable;
	import choco.kernel.model.variables.real.RealExpressionVariable;

public interface ChocoTreeParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int MENOS_UNARIO = 4;
	int IFF = 5;
	int IMPLIES = 6;
	int OR = 7;
	int AND = 8;
	int NOT = 9;
	int MAYOR = 10;
	int MENOR = 11;
	int MAYOR_IGUAL = 12;
	int MENOR_IGUAL = 13;
	int IGUAL = 14;
	int DISTINTO = 15;
	int MAS = 16;
	int MENOS = 17;
	int MULT = 18;
	int DIV = 19;
	int MOD = 20;
	int POW = 21;
	int IDENT = 22;
	int LIT_REAL = 23;
	int LIT_ENTERO = 24;
	int LIT_STRING = 25;
	int PARENTESIS_ABRIR = 26;
	int PARENTESIS_CERRAR = 27;
}

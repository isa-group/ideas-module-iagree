// $ANTLR 2.7.7 (20060906): "Anasint.g" -> "Anasint.java"$

	package es.us.isa.ada.wsag10.transforms.wsag4people2wsag;
	import java.util.*;
	import antlr.*;
	

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

public class Anasint extends antlr.LLkParser       implements AnasintTokenTypes
 {

	
//Variables globales
	String resultado = "";
	String cabecera = "";
	String pie = "";
	int numTab = 3;
	String numero = "";
	LinkedList<Item> listaItems = new LinkedList<Item>();
	Item itemActual = new Item();
	String contenido = "";
	String nombre = "";
	String prefijo = "";
	String tipoConstraint = "";
	String acumuladorDeTexto = "";
	String acumulador1 = "";
	String acumulador2 = "";
	String acumulador3 = "";
	
	
	public String eliminaMayorYMenor(String texto){
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
	
	public String eliminaEspaciosTexto(String texto){
	String resultado ="";
	
	for(int i = 0; i <texto.length();i++){
		if(texto.charAt(i) != ' ')
			resultado+=texto.charAt(i);
		
	}
	return resultado;	
		
		
	}
	

protected Anasint(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Anasint(TokenBuffer tokenBuf) {
  this(tokenBuf,3);
}

protected Anasint(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Anasint(TokenStream lexer) {
  this(lexer,3);
}

public Anasint(ParserSharedInputState state) {
  super(state,3);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final boolean  declaracion_modulo() throws RecognitionException, TokenStreamException {
		boolean error = false;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaracion_modulo_AST = null;
		AST d_AST = null;
		
		try {      // for error handling
			
					 resultado += "<?xml version=\"1.0\" encoding = \"UTF-8\"?>\n";
					 
				
			
				
			documentowsag();
			d_AST = (AST)returnAST;
			AST tmp1_AST = null;
			tmp1_AST = astFactory.create(LT(1));
			match(Token.EOF_TYPE);
			
				
				//System.out.println("RESULTADO:\n"+resultado);
				WSAgForPeopleToXML.setResultado(resultado);
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = declaracion_modulo_AST;
		return error;
	}
	
	public final void documentowsag() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST documentowsag_AST = null;
		
		try {      // for error handling
			context();
			astFactory.addASTChild(currentAST, returnAST);
			documentowsag_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = documentowsag_AST;
	}
	
	public final void nombre_modulo() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST nombre_modulo_AST = null;
		
		try {      // for error handling
			match(MODULO);
			AST tmp3_AST = null;
			tmp3_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp3_AST);
			match(IDENT);
			nombre_modulo_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = nombre_modulo_AST;
	}
	
	public final void context() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST context_AST = null;
		
		try {      // for error handling
			inicio();
			astFactory.addASTChild(currentAST, returnAST);
			
				resultado+=cabecera;
			
			contextItems();
			astFactory.addASTChild(currentAST, returnAST);
			terms();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case CREATION:
			{
				creationConstraints();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
				resultado+=pie;	
			
			context_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = context_AST;
	}
	
	public final void inicio() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inicio_AST = null;
		AST k_AST = null;
		AST texao_AST = null;
		AST tex_AST = null;
		
		try {      // for error handling
			
				acumulador1="";
				acumulador2="";
			
			tipoInicio();
			k_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			{
			int _cnt8=0;
			_loop8:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					texao_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador1+=texao_AST+" ";
				}
				else {
					if ( _cnt8>=1 ) { break _loop8; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt8++;
			} while (true);
			}
			AST tmp4_AST = null;
			tmp4_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp4_AST);
			match(MENOS);
			{
			int _cnt10=0;
			_loop10:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					tex_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador2+=tex_AST+" ";
				}
				else {
					if ( _cnt10>=1 ) { break _loop10; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt10++;
			} while (true);
			}
			AST tmp5_AST = null;
			tmp5_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp5_AST);
			match(DOS_PUNTOS);
			AST s = k_AST;
			
			String t = s.getText();
				if(t.equalsIgnoreCase("Template")){
					cabecera+= "<wsag:Template wsag:TemplateId=\""+ acumulador1+" \" \n xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\">";
					pie="\n</wsag:Template>";
					
				}else{
					cabecera+= "<wsag:AgreementOffer wsag:AgreementId=\""+acumulador1+"\" \n xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\">";
					pie="\n</wsag:AgreementOffer>";
				}
			
				cabecera+="\n   <wsag:Name>\n     "+ acumulador2+" \n   </wsag:Name>";
			
			inicio_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = inicio_AST;
	}
	
	public final void contextItems() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contextItems_AST = null;
		
		try {      // for error handling
			
			resultado +="\n   <wsag:Context>";	
			
			{
			int _cnt23=0;
			_loop23:
			do {
				if ((LA(1)==LIT_ENTERO||LA(1)==LIT_REAL||LA(1)==PUNTO)) {
					contextItem();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt23>=1 ) { break _loop23; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt23++;
			} while (true);
			}
			
			resultado +="\n   </wsag:Context>";	
			
			contextItems_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = contextItems_AST;
	}
	
	public final void terms() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST terms_AST = null;
		Token  i = null;
		AST i_AST = null;
		AST c_AST = null;
		
		try {      // for error handling
			AST tmp6_AST = null;
			tmp6_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp6_AST);
			match(TERMS);
			AST tmp7_AST = null;
			tmp7_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp7_AST);
			match(MENOS);
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(IDENT);
			AST tmp8_AST = null;
			tmp8_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp8_AST);
			match(DOS_PUNTOS);
			conjunto_term();
			c_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			
					/*
					System.out.println("items");	
					
					for(int i = 0; i < listaItems.size();i++){
						System.out.println("nombre:"+listaItems.get(i).getNombre()+"\n");
						for(int j  = 0; j < listaItems.get(i).getListaNumeros().size();j++){
							System.out.println(listaItems.get(i).getListaNumeros().get(j).intValue());
							
						}	
						//System.out.println("tamao:"+listaItems.get(i).getListaNumeros().size()+"\n");
						//System.out.println("contenido:"+listaItems.get(i).getContenido()+"\n");
						//System.out.println("prefijo:"+listaItems.get(i).getPrefijo()+"\n\n"); 
					}*/
					resultado += "\n   <wsag:Terms wsag:Name=\""+i_AST+"\">";
					resultado += "\n     <wsag:All>" +UtilidadesItems.imprimeItems(listaItems)+"\n     </wsag:All>";
					resultado += "\n   </wsag:Terms>";	
			
					
					
				
			terms_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = terms_AST;
	}
	
	public final void creationConstraints() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST creationConstraints_AST = null;
		
		try {      // for error handling
			AST tmp9_AST = null;
			tmp9_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp9_AST);
			match(CREATION);
			AST tmp10_AST = null;
			tmp10_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp10_AST);
			match(CONSTRAINT);
			
				resultado +="\n   <wsag:CreationConstraints>";	
			
			AST tmp11_AST = null;
			tmp11_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp11_AST);
			match(DOS_PUNTOS);
			{
			switch ( LA(1)) {
			case ITEMS:
			{
				conjuntoitems();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			case CONSTRAINT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case CONSTRAINT:
			{
				conjuntoconstraints();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
				resultado +="\n   </wsag:CreationConstraints>";	
			
			creationConstraints_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = creationConstraints_AST;
	}
	
	public final void tipoInicio() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tipoInicio_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case AGREEMENTOFFER:
			{
				AST tmp12_AST = null;
				tmp12_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp12_AST);
				match(AGREEMENTOFFER);
				tipoInicio_AST = (AST)currentAST.root;
				break;
			}
			case TEMPLATE:
			{
				AST tmp13_AST = null;
				tmp13_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp13_AST);
				match(TEMPLATE);
				tipoInicio_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = tipoInicio_AST;
	}
	
	public final void texto_ao_ac() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST texto_ao_ac_AST = null;
		
		try {      // for error handling
			{
			{
			AST tmp14_AST = null;
			tmp14_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp14_AST);
			match(_tokenSet_1);
			}
			}
			texto_ao_ac_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = texto_ao_ac_AST;
	}
	
	public final void texto_menos_ac() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST texto_menos_ac_AST = null;
		
		try {      // for error handling
			{
			{
			AST tmp15_AST = null;
			tmp15_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp15_AST);
			match(_tokenSet_6);
			}
			}
			texto_menos_ac_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = texto_menos_ac_AST;
	}
	
	public final void texto_cierre_frase_ac() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST texto_cierre_frase_ac_AST = null;
		
		try {      // for error handling
			{
			{
			AST tmp16_AST = null;
			tmp16_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp16_AST);
			match(_tokenSet_7);
			}
			}
			texto_cierre_frase_ac_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = texto_cierre_frase_ac_AST;
	}
	
	public final void contextItem() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contextItem_AST = null;
		AST i_AST = null;
		AST t_AST = null;
		
		try {      // for error handling
			{
			int _cnt26=0;
			_loop26:
			do {
				switch ( LA(1)) {
				case LIT_ENTERO:
				{
					AST tmp17_AST = null;
					tmp17_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp17_AST);
					match(LIT_ENTERO);
					break;
				}
				case LIT_REAL:
				{
					AST tmp18_AST = null;
					tmp18_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp18_AST);
					match(LIT_REAL);
					break;
				}
				case PUNTO:
				{
					AST tmp19_AST = null;
					tmp19_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp19_AST);
					match(PUNTO);
					break;
				}
				default:
				{
					if ( _cnt26>=1 ) { break _loop26; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				}
				_cnt26++;
			} while (true);
			}
			
			acumulador1="";	
			
			itemType();
			i_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp20_AST = null;
			tmp20_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp20_AST);
			match(DOS_PUNTOS);
			{
			int _cnt28=0;
			_loop28:
			do {
				if ((_tokenSet_7.member(LA(1)))) {
					texto_contextItem();
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					
						acumulador1+=t_AST+" ";	
					
				}
				else {
					if ( _cnt28>=1 ) { break _loop28; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt28++;
			} while (true);
			}
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
				
				AST s = i_AST;
				String context = s.getText();
					
				if(context.equals("Initiator")||context.equals("Responder")){
					resultado+="\n     <wsag:Agreement"+i_AST+">\n       "+eliminaMayorYMenor(acumulador1)+"\n     </wsag:Agreement"+i_AST+">   ";
				}else if(context.equals("ExpirationTime")){
					resultado+="\n     <wsag:"+i_AST+">\n       "+eliminaMayorYMenor(eliminaEspaciosTexto(acumulador1))+"\n     </wsag:"+i_AST+">   ";
				}else{
					resultado+="\n     <wsag:"+i_AST+">\n       "+eliminaMayorYMenor(acumulador1)+"\n     </wsag:"+i_AST+">   ";
				}
				
			
			contextItem_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
		returnAST = contextItem_AST;
	}
	
	public final void itemType() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST itemType_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case INITIATOR:
			{
				AST tmp21_AST = null;
				tmp21_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp21_AST);
				match(INITIATOR);
				itemType_AST = (AST)currentAST.root;
				break;
			}
			case RESPONDER:
			{
				AST tmp22_AST = null;
				tmp22_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp22_AST);
				match(RESPONDER);
				itemType_AST = (AST)currentAST.root;
				break;
			}
			case SERVICEPROVIDER:
			{
				AST tmp23_AST = null;
				tmp23_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp23_AST);
				match(SERVICEPROVIDER);
				itemType_AST = (AST)currentAST.root;
				break;
			}
			case EXPIRATIONTIME:
			{
				AST tmp24_AST = null;
				tmp24_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp24_AST);
				match(EXPIRATIONTIME);
				itemType_AST = (AST)currentAST.root;
				break;
			}
			case TEMPLATEID:
			{
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp25_AST);
				match(TEMPLATEID);
				itemType_AST = (AST)currentAST.root;
				break;
			}
			case TEMPLATENAME:
			{
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(TEMPLATENAME);
				itemType_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = itemType_AST;
	}
	
	public final void texto_contextItem() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST texto_contextItem_AST = null;
		
		try {      // for error handling
			{
			{
			AST tmp27_AST = null;
			tmp27_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp27_AST);
			match(_tokenSet_7);
			}
			}
			texto_contextItem_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = texto_contextItem_AST;
	}
	
	public final void cierre_frase() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cierre_frase_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case COMA:
			{
				AST tmp28_AST = null;
				tmp28_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp28_AST);
				match(COMA);
				break;
			}
			case PUNTO_Y_COMA:
			{
				AST tmp29_AST = null;
				tmp29_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp29_AST);
				match(PUNTO_Y_COMA);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			cierre_frase_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_10);
		}
		returnAST = cierre_frase_AST;
	}
	
	public final void conjunto_term() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST conjunto_term_AST = null;
		
		try {      // for error handling
			{
			int _cnt36=0;
			_loop36:
			do {
				if ((LA(1)==LIT_ENTERO||LA(1)==LIT_REAL||LA(1)==PUNTO)) {
					term();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt36>=1 ) { break _loop36; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt36++;
			} while (true);
			}
			conjunto_term_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = conjunto_term_AST;
	}
	
	public final void term() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST term_AST = null;
		AST i_AST = null;
		
		try {      // for error handling
			lista_numeros();
			i_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			termino();
			astFactory.addASTChild(currentAST, returnAST);
			
				itemActual.setContenido(contenido);
				itemActual.setNombre(nombre);
				listaItems.add(itemActual);
				itemActual = new Item();
				contenido = "";
				nombre = "";
			
			term_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = term_AST;
	}
	
	public final void lista_numeros() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST lista_numeros_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  j = null;
		AST j_AST = null;
		Token  k = null;
		AST k_AST = null;
		
		try {      // for error handling
			
				numero = "";	
			
			{
			int _cnt40=0;
			_loop40:
			do {
				switch ( LA(1)) {
				case LIT_REAL:
				{
					i = LT(1);
					i_AST = astFactory.create(i);
					astFactory.makeASTRoot(currentAST, i_AST);
					match(LIT_REAL);
					numero+=i_AST;
					break;
				}
				case PUNTO:
				{
					j = LT(1);
					j_AST = astFactory.create(j);
					astFactory.makeASTRoot(currentAST, j_AST);
					match(PUNTO);
					numero+=j_AST;
					break;
				}
				case LIT_ENTERO:
				{
					k = LT(1);
					k_AST = astFactory.create(k);
					astFactory.makeASTRoot(currentAST, k_AST);
					match(LIT_ENTERO);
					numero+=k_AST;
					break;
				}
				default:
				{
					if ( _cnt40>=1 ) { break _loop40; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				}
				_cnt40++;
			} while (true);
			}
			
				
				Item it = new Item();
				itemActual.agregaNumerosALista(numero);
				itemActual.setPrefijo(numero);
				
				
			lista_numeros_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = lista_numeros_AST;
	}
	
	public final void termino() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST termino_AST = null;
		
		try {      // for error handling
			if ((LA(1)==GUARANTEE||LA(1)==SERVICE) && (_tokenSet_13.member(LA(2))) && (LA(3)==IDENT||LA(3)==MENOS||LA(3)==TERM)) {
				simple();
				astFactory.addASTChild(currentAST, returnAST);
				termino_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==GUARANTEES||LA(1)==SERVICE) && (_tokenSet_14.member(LA(2))) && (LA(3)==DOS_PUNTOS||LA(3)==TERMS||LA(3)==ALMOHADILLA)) {
				agrupados();
				astFactory.addASTChild(currentAST, returnAST);
				termino_AST = (AST)currentAST.root;
			}
			else if (((LA(1) >= ALL && LA(1) <= ONE))) {
				recursivos();
				astFactory.addASTChild(currentAST, returnAST);
				termino_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = termino_AST;
	}
	
	public final void simple() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simple_AST = null;
		
		try {      // for error handling
			if ((LA(1)==SERVICE) && (LA(2)==REFERENCE)) {
				serviceReferences();
				astFactory.addASTChild(currentAST, returnAST);
				simple_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==SERVICE) && (LA(2)==PROPERTIES)) {
				serviceProperties();
				astFactory.addASTChild(currentAST, returnAST);
				simple_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==SERVICE) && (LA(2)==DESCRIPTION)) {
				serviceDescriptionTerm();
				astFactory.addASTChild(currentAST, returnAST);
				simple_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==GUARANTEE)) {
				guarantee();
				astFactory.addASTChild(currentAST, returnAST);
				simple_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = simple_AST;
	}
	
	public final void agrupados() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST agrupados_AST = null;
		
		try {      // for error handling
			if ((LA(1)==SERVICE) && (LA(2)==PROPERTIES)) {
				servicePropertiesAgrupado();
				astFactory.addASTChild(currentAST, returnAST);
				agrupados_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==SERVICE) && (LA(2)==REFERENCES)) {
				serviceReferencesAgrupado();
				astFactory.addASTChild(currentAST, returnAST);
				agrupados_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==SERVICE) && (LA(2)==DESCRIPTION)) {
				serviceDescriptionTermAgrupado();
				astFactory.addASTChild(currentAST, returnAST);
				agrupados_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==GUARANTEES)) {
				guaranteeAgrupado();
				astFactory.addASTChild(currentAST, returnAST);
				agrupados_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = agrupados_AST;
	}
	
	public final void recursivos() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST recursivos_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case ALL:
			{
				all();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EXACTLY:
			{
				exactlyOne();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ONE:
			{
				oneOrMoreBetween();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			recursivos_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = recursivos_AST;
	}
	
	public final void serviceReferences() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST serviceReferences_AST = null;
		Token  i1 = null;
		AST i1_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		AST t_AST = null;
		
		try {      // for error handling
			
				acumulador1="";	
			
			AST tmp30_AST = null;
			tmp30_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp30_AST);
			match(SERVICE);
			AST tmp31_AST = null;
			tmp31_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp31_AST);
			match(REFERENCE);
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(MENOS);
			i1 = LT(1);
			i1_AST = astFactory.create(i1);
			astFactory.addASTChild(currentAST, i1_AST);
			match(IDENT);
			AST tmp33_AST = null;
			tmp33_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp33_AST);
			match(MENOS);
			i2 = LT(1);
			i2_AST = astFactory.create(i2);
			astFactory.addASTChild(currentAST, i2_AST);
			match(IDENT);
			AST tmp34_AST = null;
			tmp34_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp34_AST);
			match(DOS_PUNTOS);
			{
			int _cnt134=0;
			_loop134:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador1+=t_AST + " ";
				}
				else {
					if ( _cnt134>=1 ) { break _loop134; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt134++;
			} while (true);
			}
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			
				nombre+="ServiceReferences";	
				contenido+= "\n<wsag:ServiceReferences wsag:Name=\""+i1_AST+"\" \n wsag:ServiceName=\""+i2_AST+"\"> \n "+eliminaMayorYMenor(acumulador1)+"\n";
				contenido+= "\n</wsag:ServiceReferences>";	
			
			serviceReferences_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = serviceReferences_AST;
	}
	
	public final void serviceProperties() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST serviceProperties_AST = null;
		AST i1_AST = null;
		AST i2_AST = null;
		
		try {      // for error handling
			
			acumulador1="";
			acumulador2="";
			
			AST tmp35_AST = null;
			tmp35_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp35_AST);
			match(SERVICE);
			AST tmp36_AST = null;
			tmp36_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp36_AST);
			match(PROPERTIES);
			AST tmp37_AST = null;
			tmp37_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp37_AST);
			match(MENOS);
			{
			int _cnt146=0;
			_loop146:
			do {
				if ((_tokenSet_6.member(LA(1)))) {
					texto_menos_ac();
					i1_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					
						acumulador1+=i1_AST+" ";
					
				}
				else {
					if ( _cnt146>=1 ) { break _loop146; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt146++;
			} while (true);
			}
			AST tmp38_AST = null;
			tmp38_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp38_AST);
			match(MENOS);
			{
			int _cnt148=0;
			_loop148:
			do {
				if ((_tokenSet_15.member(LA(1)))) {
					texto_dos_puntos_ac();
					i2_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					
						
						acumulador2+=i2_AST+" ";	
					
				}
				else {
					if ( _cnt148>=1 ) { break _loop148; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt148++;
			} while (true);
			}
			AST tmp39_AST = null;
			tmp39_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp39_AST);
			match(DOS_PUNTOS);
			
					nombre+="ServiceProperties";
					contenido+= "\n<wsag:ServiceProperties wsag:Name=\""+i1_AST+"\" \n wsag:ServiceName=\""+i2_AST+"\"> \n  <wsag:VariableSet> ";
			
			{
			int _cnt150=0;
			_loop150:
			do {
				if ((LA(1)==LIT_ENTERO) && (LA(2)==IDENT)) {
					elementosServicePropertiesTerm();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt150>=1 ) { break _loop150; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt150++;
			} while (true);
			}
			
					contenido+= "\n  </wsag:VariableSet> \n</wsag:ServiceProperties>";	
			
			serviceProperties_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = serviceProperties_AST;
	}
	
	public final void serviceDescriptionTerm() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST serviceDescriptionTerm_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  id2 = null;
		AST id2_AST = null;
		
		try {      // for error handling
			AST tmp40_AST = null;
			tmp40_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp40_AST);
			match(SERVICE);
			AST tmp41_AST = null;
			tmp41_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp41_AST);
			match(DESCRIPTION);
			AST tmp42_AST = null;
			tmp42_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp42_AST);
			match(TERM);
			AST tmp43_AST = null;
			tmp43_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp43_AST);
			match(MENOS);
			id = LT(1);
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(IDENT);
			AST tmp44_AST = null;
			tmp44_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp44_AST);
			match(MENOS);
			id2 = LT(1);
			id2_AST = astFactory.create(id2);
			astFactory.addASTChild(currentAST, id2_AST);
			match(IDENT);
			AST tmp45_AST = null;
			tmp45_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp45_AST);
			match(DOS_PUNTOS);
			
			nombre = "ServiceDescriptionTerm";
			contenido+="\n<wsag:ServiceDescriptionTerm wsag:Name=\""+id_AST+"\" \n wsag:ServiceName=\""+id2_AST+"\">";
			
			elementosServiceDescriptionTerm();
			astFactory.addASTChild(currentAST, returnAST);
			
			contenido+="\n</wsag:ServiceDescriptionTerm>";
			
			serviceDescriptionTerm_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = serviceDescriptionTerm_AST;
	}
	
	public final void guarantee() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST guarantee_AST = null;
		Token  id1 = null;
		AST id1_AST = null;
		AST p_AST = null;
		
		try {      // for error handling
			AST tmp46_AST = null;
			tmp46_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp46_AST);
			match(GUARANTEE);
			AST tmp47_AST = null;
			tmp47_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp47_AST);
			match(MENOS);
			id1 = LT(1);
			id1_AST = astFactory.create(id1);
			astFactory.addASTChild(currentAST, id1_AST);
			match(IDENT);
			AST tmp48_AST = null;
			tmp48_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp48_AST);
			match(PARENTESIS_ABIERTO);
			AST tmp49_AST = null;
			tmp49_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp49_AST);
			match(BY);
			proveedor();
			p_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp50_AST = null;
			tmp50_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp50_AST);
			match(PARENTESIS_CERRADO);
			AST tmp51_AST = null;
			tmp51_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp51_AST);
			match(DOS_PUNTOS);
			
			nombre = "Gurantee";	
			contenido+="\n<wsag:GuaranteeTerm wsag:Name=\""+id1_AST+"\" wsag:Obligated=\""+p_AST+"\" >";
			
			
			elementos_guarantee();
			astFactory.addASTChild(currentAST, returnAST);
			
				contenido+="\n</wsag:GuaranteeTerm>";	
			
			guarantee_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = guarantee_AST;
	}
	
	public final void servicePropertiesAgrupado() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST servicePropertiesAgrupado_AST = null;
		
		try {      // for error handling
			AST tmp52_AST = null;
			tmp52_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp52_AST);
			match(SERVICE);
			AST tmp53_AST = null;
			tmp53_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp53_AST);
			match(PROPERTIES);
			AST tmp54_AST = null;
			tmp54_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp54_AST);
			match(DOS_PUNTOS);
			{
			int _cnt158=0;
			_loop158:
			do {
				if ((LA(1)==IDENT)) {
					servicePropertiesAnidados();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt158>=1 ) { break _loop158; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt158++;
			} while (true);
			}
			servicePropertiesAgrupado_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = servicePropertiesAgrupado_AST;
	}
	
	public final void serviceReferencesAgrupado() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST serviceReferencesAgrupado_AST = null;
		
		try {      // for error handling
			AST tmp55_AST = null;
			tmp55_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp55_AST);
			match(SERVICE);
			AST tmp56_AST = null;
			tmp56_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp56_AST);
			match(REFERENCES);
			AST tmp57_AST = null;
			tmp57_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp57_AST);
			match(DOS_PUNTOS);
			{
			int _cnt137=0;
			_loop137:
			do {
				if ((LA(1)==LIT_ENTERO) && (LA(2)==IDENT)) {
					serviceReferencesAnidados();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt137>=1 ) { break _loop137; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt137++;
			} while (true);
			}
			serviceReferencesAgrupado_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = serviceReferencesAgrupado_AST;
	}
	
	public final void serviceDescriptionTermAgrupado() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST serviceDescriptionTermAgrupado_AST = null;
		
		try {      // for error handling
			AST tmp58_AST = null;
			tmp58_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp58_AST);
			match(SERVICE);
			AST tmp59_AST = null;
			tmp59_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp59_AST);
			match(DESCRIPTION);
			AST tmp60_AST = null;
			tmp60_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp60_AST);
			match(TERMS);
			AST tmp61_AST = null;
			tmp61_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp61_AST);
			match(DOS_PUNTOS);
			{
			int _cnt130=0;
			_loop130:
			do {
				if ((LA(1)==LIT_ENTERO) && (LA(2)==IDENT)) {
					serviceDescriptionTermnAnidados();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt130>=1 ) { break _loop130; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt130++;
			} while (true);
			}
			serviceDescriptionTermAgrupado_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = serviceDescriptionTermAgrupado_AST;
	}
	
	public final void guaranteeAgrupado() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST guaranteeAgrupado_AST = null;
		
		try {      // for error handling
			AST tmp62_AST = null;
			tmp62_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp62_AST);
			match(GUARANTEES);
			AST tmp63_AST = null;
			tmp63_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp63_AST);
			match(DOS_PUNTOS);
			{
			int _cnt46=0;
			_loop46:
			do {
				if ((LA(1)==ALMOHADILLA)) {
					guaranteesAnidados();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt46>=1 ) { break _loop46; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt46++;
			} while (true);
			}
			guaranteeAgrupado_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = guaranteeAgrupado_AST;
	}
	
	public final void guaranteesAnidados() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST guaranteesAnidados_AST = null;
		Token  id1 = null;
		AST id1_AST = null;
		AST p_AST = null;
		
		try {      // for error handling
			AST tmp64_AST = null;
			tmp64_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp64_AST);
			match(ALMOHADILLA);
			texto_almohadilla();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp65_AST = null;
			tmp65_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp65_AST);
			match(MENOS);
			id1 = LT(1);
			id1_AST = astFactory.create(id1);
			astFactory.addASTChild(currentAST, id1_AST);
			match(IDENT);
			AST tmp66_AST = null;
			tmp66_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp66_AST);
			match(PARENTESIS_ABIERTO);
			AST tmp67_AST = null;
			tmp67_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp67_AST);
			match(BY);
			proveedor();
			p_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp68_AST = null;
			tmp68_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp68_AST);
			match(PARENTESIS_CERRADO);
			AST tmp69_AST = null;
			tmp69_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp69_AST);
			match(DOS_PUNTOS);
			
			nombre = "Gurantee";	
			contenido+="\n<wsag:GuaranteeTerm wsag:Name=\""+id1_AST+"\" wsag:Obligated=\""+p_AST+"\" >";
			
			
			elementos_guarantee();
			astFactory.addASTChild(currentAST, returnAST);
			
				contenido+="\n</wsag:GuaranteeTerm>";	
			
			guaranteesAnidados_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = guaranteesAnidados_AST;
	}
	
	public final void texto_almohadilla() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST texto_almohadilla_AST = null;
		
		try {      // for error handling
			{
			int _cnt50=0;
			_loop50:
			do {
				if ((_tokenSet_17.member(LA(1)))) {
					{
					AST tmp70_AST = null;
					tmp70_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp70_AST);
					match(_tokenSet_17);
					}
				}
				else {
					if ( _cnt50>=1 ) { break _loop50; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt50++;
			} while (true);
			}
			texto_almohadilla_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_18);
		}
		returnAST = texto_almohadilla_AST;
	}
	
	public final void proveedor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST proveedor_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case SERVICECONSUMER:
			{
				AST tmp71_AST = null;
				tmp71_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp71_AST);
				match(SERVICECONSUMER);
				break;
			}
			case SERVICEPROVIDER:
			{
				AST tmp72_AST = null;
				tmp72_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp72_AST);
				match(SERVICEPROVIDER);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			proveedor_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_19);
		}
		returnAST = proveedor_AST;
	}
	
	public final void elementos_guarantee() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementos_guarantee_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case SCOPES:
			{
				serviceScope();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SLO:
			case KPI:
			case QUALIFYING:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case QUALIFYING:
			{
				qualifyingCondition();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SLO:
			case KPI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case SLO:
			{
				slo();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case KPI:
			{
				kpi();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case BUSINESS:
			{
				businesValueList();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			case LIT_ENTERO:
			case LIT_REAL:
			case PUNTO:
			case ALMOHADILLA:
			case CREATION:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			elementos_guarantee_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = elementos_guarantee_AST;
	}
	
	public final void serviceScope() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST serviceScope_AST = null;
		
		try {      // for error handling
			AST tmp73_AST = null;
			tmp73_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp73_AST);
			match(SCOPES);
			{
			elementosScopes();
			astFactory.addASTChild(currentAST, returnAST);
			}
			AST tmp74_AST = null;
			tmp74_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp74_AST);
			match(PUNTO_Y_COMA);
			serviceScope_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_20);
		}
		returnAST = serviceScope_AST;
	}
	
	public final void qualifyingCondition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST qualifyingCondition_AST = null;
		AST t1_AST = null;
		
		try {      // for error handling
			
				acumulador1 ="";	
			
			AST tmp75_AST = null;
			tmp75_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp75_AST);
			match(QUALIFYING);
			AST tmp76_AST = null;
			tmp76_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp76_AST);
			match(CONDITION);
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp77_AST);
			match(DOS_PUNTOS);
			{
			int _cnt103=0;
			_loop103:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					t1_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					
						
						acumulador1+=t1_AST+"";
					
				}
				else {
					if ( _cnt103>=1 ) { break _loop103; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt103++;
			} while (true);
			}
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(PUNTO_Y_COMA);
			
				
			contenido+="\n   <wsag:QualifyingCondition>\n     "+eliminaMayorYMenor(acumulador1)+"\n   </wsag:QualifyingCondition>";	
			
			qualifyingCondition_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_21);
		}
		returnAST = qualifyingCondition_AST;
	}
	
	public final void slo() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST slo_AST = null;
		AST t_AST = null;
		
		try {      // for error handling
			AST tmp79_AST = null;
			tmp79_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp79_AST);
			match(SLO);
			AST tmp80_AST = null;
			tmp80_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp80_AST);
			match(DOS_PUNTOS);
			
				
				contenido+="\n   <wsag:ServiceLevelObjective>\n     <wsag:CustomServiceLevel>"+
				          "\n       ";	
			
			{
			int _cnt95=0;
			_loop95:
			do {
				if ((_tokenSet_22.member(LA(1)))) {
					contenido_slo();
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					
						AST arbol = t_AST;
						
						contenido+=""+eliminaMayorYMenor(arbol.getText())+" ";
						
					
				}
				else {
					if ( _cnt95>=1 ) { break _loop95; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt95++;
			} while (true);
			}
			
				contenido+="\n     </wsag:CustomServiceLevel>\n   </wsag:ServiceLevelObjective>";
				
			
			AST tmp81_AST = null;
			tmp81_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp81_AST);
			match(PUNTO_Y_COMA);
			slo_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_23);
		}
		returnAST = slo_AST;
	}
	
	public final void kpi() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST kpi_AST = null;
		AST t_AST = null;
		AST t2_AST = null;
		
		try {      // for error handling
			
				acumulador1="";
				acumulador2="";	
			
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp82_AST);
			match(KPI);
			AST tmp83_AST = null;
			tmp83_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp83_AST);
			match(DOS_PUNTOS);
			{
			int _cnt98=0;
			_loop98:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador1+=t_AST + " ";
				}
				else {
					if ( _cnt98>=1 ) { break _loop98; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt98++;
			} while (true);
			}
			AST tmp84_AST = null;
			tmp84_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp84_AST);
			match(COMA);
			{
			int _cnt100=0;
			_loop100:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					t2_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador2+=t2_AST + " ";
				}
				else {
					if ( _cnt100>=1 ) { break _loop100; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt100++;
			} while (true);
			}
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			
				
				contenido+="\n   <wsag:ServiceLevelObjective>\n     <wsag:KPITarget>\n       <wsag:KPIName>"+
				          "\n         "+eliminaMayorYMenor(acumulador1)+"\n       </wsag:KPIName>\n       <wsag:Target>\n         "+ eliminaMayorYMenor(acumulador2) +"\n       </wsag:Target>\n     </wsag:KPITarget>\n   <wsag:ServiceLevelObjective>\n"; 	
			
			kpi_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_23);
		}
		returnAST = kpi_AST;
	}
	
	public final void businesValueList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST businesValueList_AST = null;
		
		try {      // for error handling
			businessValue();
			astFactory.addASTChild(currentAST, returnAST);
			utility();
			astFactory.addASTChild(currentAST, returnAST);
			custom();
			astFactory.addASTChild(currentAST, returnAST);
			businesValueList_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = businesValueList_AST;
	}
	
	public final void businessValue() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST businessValue_AST = null;
		Token  l = null;
		AST l_AST = null;
		
		try {      // for error handling
			AST tmp85_AST = null;
			tmp85_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp85_AST);
			match(BUSINESS);
			AST tmp86_AST = null;
			tmp86_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp86_AST);
			match(VALUE);
			AST tmp87_AST = null;
			tmp87_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp87_AST);
			match(DOS_PUNTOS);
			AST tmp88_AST = null;
			tmp88_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp88_AST);
			match(RELATIVE);
			AST tmp89_AST = null;
			tmp89_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp89_AST);
			match(IMPORTANCE);
			AST tmp90_AST = null;
			tmp90_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp90_AST);
			match(BETWEENMINUS);
			AST tmp91_AST = null;
			tmp91_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp91_AST);
			match(GUARANTEESMINUS);
			AST tmp92_AST = null;
			tmp92_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp92_AST);
			match(DOS_PUNTOS);
			l = LT(1);
			l_AST = astFactory.create(l);
			astFactory.addASTChild(currentAST, l_AST);
			match(LIT_ENTERO);
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			
				contenido+="\n   <wsag:BusinessValueList>\n     <wsag:Importance>"+l_AST+"</wsag:Importance>";
			
			{
			_loop69:
			do {
				if ((LA(1)==PENALTY)) {
					penalty();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop69;
				}
				
			} while (true);
			}
			{
			_loop71:
			do {
				if ((LA(1)==REWARD)) {
					reward();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop71;
				}
				
			} while (true);
			}
			
				contenido+="\n   </wsag:BusinessValueList>";
			
			businessValue_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_24);
		}
		returnAST = businessValue_AST;
	}
	
	public final void utility() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST utility_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		Token  l2 = null;
		AST l2_AST = null;
		
		try {      // for error handling
			AST tmp93_AST = null;
			tmp93_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp93_AST);
			match(UTILITY);
			AST tmp94_AST = null;
			tmp94_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp94_AST);
			match(IFMINUS);
			AST tmp95_AST = null;
			tmp95_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp95_AST);
			match(SELECTED);
			AST tmp96_AST = null;
			tmp96_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp96_AST);
			match(DOS_PUNTOS);
			
					contenido+="\n   "+"<wsag:Preference>"; ;	
				
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(IDENT);
			AST tmp97_AST = null;
			tmp97_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp97_AST);
			match(IGUAL);
			AST tmp98_AST = null;
			tmp98_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp98_AST);
			match(MAYOR);
			l = LT(1);
			l_AST = astFactory.create(l);
			astFactory.addASTChild(currentAST, l_AST);
			match(LIT_REAL);
			
					contenido+="\n     <wsag:ServiceTermReference>\n"+i_AST+"\n     </wsag:ServiceTermReference>\n"+
					 "     <wsag:Utility>\n"+l_AST+"\n     </wsag:Utility>";	
					
				
			{
			_loop63:
			do {
				if ((LA(1)==COMA)) {
					AST tmp99_AST = null;
					tmp99_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp99_AST);
					match(COMA);
					i2 = LT(1);
					i2_AST = astFactory.create(i2);
					astFactory.addASTChild(currentAST, i2_AST);
					match(IDENT);
					AST tmp100_AST = null;
					tmp100_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp100_AST);
					match(IGUAL);
					AST tmp101_AST = null;
					tmp101_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp101_AST);
					match(MAYOR);
					l2 = LT(1);
					l2_AST = astFactory.create(l2);
					astFactory.addASTChild(currentAST, l2_AST);
					match(LIT_REAL);
					
							contenido+="\n     <wsag:ServiceTermReference>\n"+i2_AST+"\n     </wsag:ServiceTermReference>\n"+
							 "     <wsag:Utility>\n"+l2_AST+"\n     </wsag:Utility>";	
							
						
				}
				else {
					break _loop63;
				}
				
			} while (true);
			}
			AST tmp102_AST = null;
			tmp102_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp102_AST);
			match(PUNTO_Y_COMA);
			
					contenido+="\n   "+"</wsag:Preference>"; ;	
				
			utility_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_25);
		}
		returnAST = utility_AST;
	}
	
	public final void custom() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST custom_AST = null;
		AST t_AST = null;
		
		try {      // for error handling
			
				acumulador1 = "";	
			
			AST tmp103_AST = null;
			tmp103_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp103_AST);
			match(CUSTOM);
			AST tmp104_AST = null;
			tmp104_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp104_AST);
			match(BUSINESS);
			AST tmp105_AST = null;
			tmp105_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp105_AST);
			match(VALUE);
			AST tmp106_AST = null;
			tmp106_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp106_AST);
			match(DOS_PUNTOS);
			{
			int _cnt66=0;
			_loop66:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador1+=t_AST + " ";
				}
				else {
					if ( _cnt66>=1 ) { break _loop66; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt66++;
			} while (true);
			}
			AST tmp107_AST = null;
			tmp107_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp107_AST);
			match(PUNTO_Y_COMA);
			
					contenido+="\n   <CustomBusinessValue>\n"+eliminaMayorYMenor(acumulador1)+"\n   </CustomBusinessValue>";
				
			custom_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_16);
		}
		returnAST = custom_AST;
	}
	
	public final void penalty() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST penalty_AST = null;
		AST t_AST = null;
		AST un_AST = null;
		AST t2_AST = null;
		Token  i = null;
		AST i_AST = null;
		
		try {      // for error handling
			
				acumulador1="";
				acumulador2="";
				acumulador3="";
			
			AST tmp108_AST = null;
			tmp108_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp108_AST);
			match(PENALTY);
			AST tmp109_AST = null;
			tmp109_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp109_AST);
			match(DOS_PUNTOS);
			{
			int _cnt82=0;
			_loop82:
			do {
				if ((_tokenSet_26.member(LA(1)))) {
					texto_ai();
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador1+=t_AST+" ";
				}
				else {
					if ( _cnt82>=1 ) { break _loop82; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt82++;
			} while (true);
			}
			AST tmp110_AST = null;
			tmp110_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp110_AST);
			match(COMA);
			{
			int _cnt84=0;
			_loop84:
			do {
				if ((_tokenSet_26.member(LA(1)))) {
					texto_ai();
					un_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador2+=un_AST+" ";
				}
				else {
					if ( _cnt84>=1 ) { break _loop84; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt84++;
			} while (true);
			}
			AST tmp111_AST = null;
			tmp111_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp111_AST);
			match(PUNTO);
			AST tmp112_AST = null;
			tmp112_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp112_AST);
			match(ASSESSED);
			AST tmp113_AST = null;
			tmp113_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp113_AST);
			match(IN);
			{
			int _cnt86=0;
			_loop86:
			do {
				if ((_tokenSet_26.member(LA(1)))) {
					texto_ai();
					t2_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador3+=t2_AST+" ";
				}
				else {
					if ( _cnt86>=1 ) { break _loop86; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt86++;
			} while (true);
			}
			{
			switch ( LA(1)) {
			case INVOCATION:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(INVOCATION);
				break;
			}
			case COMA:
			case PUNTO_Y_COMA:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			
				contenido+="\n   <wsag:Penalty>";
				contenido+="\n     <wsag:AssesmentInterval>";
			if(i == null)
			contenido+="\n       <wsag:TimeInterval>\n       "+eliminaMayorYMenor(acumulador3)+"\n       </wsag:TimeInterval>";
			else 	
			contenido+="\n       <wsag:Count>\n       "+eliminaMayorYMenor(acumulador3)+"\n       </wsag:Count>";
			
			contenido+="\n     </wsag:AssesmentInterval>";     	
			contenido+="\n     <wsag:ValueUnit>\n     "+eliminaMayorYMenor(acumulador2)+"\n     </wsag:ValueUnit>\n     <wsag:ValueExpr>\n     "+eliminaMayorYMenor(acumulador1)+"\n     </wsag:ValueExpr>\n   </wsag:Penalty>";
			
			penalty_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_27);
		}
		returnAST = penalty_AST;
	}
	
	public final void reward() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST reward_AST = null;
		AST t_AST = null;
		AST un_AST = null;
		AST t2_AST = null;
		Token  i = null;
		AST i_AST = null;
		
		try {      // for error handling
			
				acumulador1="";
				acumulador2="";
				acumulador3="";
			
			AST tmp114_AST = null;
			tmp114_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp114_AST);
			match(REWARD);
			AST tmp115_AST = null;
			tmp115_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp115_AST);
			match(DOS_PUNTOS);
			{
			int _cnt74=0;
			_loop74:
			do {
				if ((_tokenSet_26.member(LA(1)))) {
					texto_ai();
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador1+=t_AST+" ";
				}
				else {
					if ( _cnt74>=1 ) { break _loop74; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt74++;
			} while (true);
			}
			AST tmp116_AST = null;
			tmp116_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp116_AST);
			match(COMA);
			{
			int _cnt76=0;
			_loop76:
			do {
				if ((_tokenSet_26.member(LA(1)))) {
					texto_ai();
					un_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador2+=un_AST+" ";
				}
				else {
					if ( _cnt76>=1 ) { break _loop76; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt76++;
			} while (true);
			}
			AST tmp117_AST = null;
			tmp117_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp117_AST);
			match(PUNTO);
			AST tmp118_AST = null;
			tmp118_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp118_AST);
			match(ASSESSED);
			AST tmp119_AST = null;
			tmp119_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp119_AST);
			match(IN);
			{
			int _cnt78=0;
			_loop78:
			do {
				if ((_tokenSet_26.member(LA(1)))) {
					texto_ai();
					t2_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador3+=t2_AST+" ";
				}
				else {
					if ( _cnt78>=1 ) { break _loop78; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt78++;
			} while (true);
			}
			{
			switch ( LA(1)) {
			case INVOCATION:
			{
				i = LT(1);
				i_AST = astFactory.create(i);
				astFactory.addASTChild(currentAST, i_AST);
				match(INVOCATION);
				break;
			}
			case COMA:
			case PUNTO_Y_COMA:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			
				contenido+="\n   <wsag:Reward>";
				contenido+="\n     <wsag:AssesmentInterval>";
			if(i == null)
			contenido+="\n       <wsag:TimeInterval>\n       "+eliminaMayorYMenor(acumulador3)+"\n       </wsag:TimeInterval>";
			else 	
			contenido+="\n       <wsag:Count>\n       "+eliminaMayorYMenor(acumulador3)+"\n       </wsag:Count>";
			
			contenido+="\n     </wsag:AssesmentInterval>";     	
			contenido+="\n     <wsag:ValueUnit>\n     "+eliminaMayorYMenor(acumulador2)+"\n     </wsag:ValueUnit>\n     <wsag:ValueExpr>\n     "+eliminaMayorYMenor(acumulador1)+"\n     </wsag:ValueExpr>\n   </wsag:Reward>";
			
			reward_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_28);
		}
		returnAST = reward_AST;
	}
	
	public final void texto_ai() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST texto_ai_AST = null;
		
		try {      // for error handling
			{
			{
			AST tmp120_AST = null;
			tmp120_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp120_AST);
			match(_tokenSet_26);
			}
			}
			texto_ai_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = texto_ai_AST;
	}
	
	public final void contenido_slo() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contenido_slo_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LIT_ENTERO:
			{
				AST tmp121_AST = null;
				tmp121_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp121_AST);
				match(LIT_ENTERO);
				break;
			}
			case MAS:
			{
				AST tmp122_AST = null;
				tmp122_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp122_AST);
				match(MAS);
				break;
			}
			case MENOS:
			{
				AST tmp123_AST = null;
				tmp123_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp123_AST);
				match(MENOS);
				break;
			}
			case DIVISION:
			{
				AST tmp124_AST = null;
				tmp124_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp124_AST);
				match(DIVISION);
				break;
			}
			case POR:
			{
				AST tmp125_AST = null;
				tmp125_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp125_AST);
				match(POR);
				break;
			}
			case IGUAL:
			{
				AST tmp126_AST = null;
				tmp126_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp126_AST);
				match(IGUAL);
				break;
			}
			case IDENT:
			{
				AST tmp127_AST = null;
				tmp127_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp127_AST);
				match(IDENT);
				break;
			}
			case MAYOR:
			{
				AST tmp128_AST = null;
				tmp128_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp128_AST);
				match(MAYOR);
				break;
			}
			case MENOR:
			{
				AST tmp129_AST = null;
				tmp129_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp129_AST);
				match(MENOR);
				break;
			}
			case DISTINTO:
			{
				AST tmp130_AST = null;
				tmp130_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp130_AST);
				match(DISTINTO);
				break;
			}
			case MENOR_IGUAL:
			{
				AST tmp131_AST = null;
				tmp131_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp131_AST);
				match(MENOR_IGUAL);
				break;
			}
			case MAYOR_IGUAL:
			{
				AST tmp132_AST = null;
				tmp132_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp132_AST);
				match(MAYOR_IGUAL);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			contenido_slo_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_29);
		}
		returnAST = contenido_slo_AST;
	}
	
	public final void condicion() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST condicion_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case MAYOR:
			{
				AST tmp133_AST = null;
				tmp133_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp133_AST);
				match(MAYOR);
				condicion_AST = (AST)currentAST.root;
				break;
			}
			case MENOR:
			{
				AST tmp134_AST = null;
				tmp134_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp134_AST);
				match(MENOR);
				condicion_AST = (AST)currentAST.root;
				break;
			}
			case IGUAL:
			{
				AST tmp135_AST = null;
				tmp135_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp135_AST);
				match(IGUAL);
				condicion_AST = (AST)currentAST.root;
				break;
			}
			case MAYOR_IGUAL:
			{
				AST tmp136_AST = null;
				tmp136_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp136_AST);
				match(MAYOR_IGUAL);
				condicion_AST = (AST)currentAST.root;
				break;
			}
			case MENOR_IGUAL:
			{
				AST tmp137_AST = null;
				tmp137_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp137_AST);
				match(MENOR_IGUAL);
				condicion_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = condicion_AST;
	}
	
	public final void elementosScopes() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementosScopes_AST = null;
		AST id1_AST = null;
		AST id2_AST = null;
		AST id3_AST = null;
		AST id4_AST = null;
		
		try {      // for error handling
			
				acumulador1="";
				acumulador2="";	
			
			AST tmp138_AST = null;
			tmp138_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp138_AST);
			match(DOS_PUNTOS);
			{
			int _cnt109=0;
			_loop109:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					id1_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador1+=id1_AST + " ";
				}
				else {
					if ( _cnt109>=1 ) { break _loop109; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt109++;
			} while (true);
			}
			AST tmp139_AST = null;
			tmp139_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp139_AST);
			match(MENOS);
			{
			int _cnt111=0;
			_loop111:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					id2_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador2+=id2_AST + " ";
				}
				else {
					if ( _cnt111>=1 ) { break _loop111; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt111++;
			} while (true);
			}
			
				contenido+="\n   <wsag:ServiceScope wsag:ServiceName=\""+eliminaMayorYMenor(acumulador1)+"\" >\n     "+eliminaMayorYMenor(acumulador2)+"\n   </wsag:ServiceScope>";
						
			
			{
			_loop117:
			do {
				if ((LA(1)==COMA)) {
					
						acumulador1="";
						acumulador2="";	
					
					AST tmp140_AST = null;
					tmp140_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp140_AST);
					match(COMA);
					{
					int _cnt114=0;
					_loop114:
					do {
						if ((_tokenSet_1.member(LA(1)))) {
							texto_ao_ac();
							id3_AST = (AST)returnAST;
							astFactory.addASTChild(currentAST, returnAST);
							acumulador1+=id3_AST + " ";
						}
						else {
							if ( _cnt114>=1 ) { break _loop114; } else {throw new NoViableAltException(LT(1), getFilename());}
						}
						
						_cnt114++;
					} while (true);
					}
					AST tmp141_AST = null;
					tmp141_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp141_AST);
					match(MENOS);
					{
					int _cnt116=0;
					_loop116:
					do {
						if ((_tokenSet_1.member(LA(1)))) {
							texto_ao_ac();
							id4_AST = (AST)returnAST;
							astFactory.addASTChild(currentAST, returnAST);
							acumulador2+=id4_AST + " ";
						}
						else {
							if ( _cnt116>=1 ) { break _loop116; } else {throw new NoViableAltException(LT(1), getFilename());}
						}
						
						_cnt116++;
					} while (true);
					}
					
						contenido+="\n   <wsag:ServiceScope wsag:ServiceName=\""+eliminaMayorYMenor(acumulador1)+"\" >\n     "+eliminaMayorYMenor(acumulador2)+"\n   </wsag:ServiceScope>";	
					
				}
				else {
					break _loop117;
				}
				
			} while (true);
			}
			elementosScopes_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_30);
		}
		returnAST = elementosScopes_AST;
	}
	
	public final void elementosServiceDescriptionTerm() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementosServiceDescriptionTerm_AST = null;
		
		try {      // for error handling
			mas_variables();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop121:
			do {
				if ((LA(1)==COMA) && (LA(2)==IDENT)) {
					AST tmp142_AST = null;
					tmp142_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp142_AST);
					match(COMA);
					mas_variables();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop121;
				}
				
			} while (true);
			}
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			elementosServiceDescriptionTerm_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = elementosServiceDescriptionTerm_AST;
	}
	
	public final void mas_variables() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST mas_variables_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		Token  l2 = null;
		AST l2_AST = null;
		AST d1_AST = null;
		String value = "";String metric = "";
		
		try {      // for error handling
			{
			i2 = LT(1);
			i2_AST = astFactory.create(i2);
			astFactory.addASTChild(currentAST, i2_AST);
			match(IDENT);
			{
			switch ( LA(1)) {
			case IGUAL:
			{
				AST tmp143_AST = null;
				tmp143_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp143_AST);
				match(IGUAL);
				l2 = LT(1);
				l2_AST = astFactory.create(l2);
				astFactory.addASTChild(currentAST, l2_AST);
				match(LIT_ENTERO);
				value=l2_AST.getText();
				break;
			}
			case MENOS:
			case COMA:
			case PUNTO_Y_COMA:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case MENOS:
			{
				AST tmp144_AST = null;
				tmp144_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp144_AST);
				match(MENOS);
				AST tmp145_AST = null;
				tmp145_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp145_AST);
				match(MEASURED);
				AST tmp146_AST = null;
				tmp146_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp146_AST);
				match(BY);
				metric = "wsag:Metric=\"";
				{
				int _cnt127=0;
				_loop127:
				do {
					if ((_tokenSet_7.member(LA(1)))) {
						texto_cierre_frase_ac();
						d1_AST = (AST)returnAST;
						astFactory.addASTChild(currentAST, returnAST);
						metric+=d1_AST.getText();
					}
					else {
						if ( _cnt127>=1 ) { break _loop127; } else {throw new NoViableAltException(LT(1), getFilename());}
					}
					
					_cnt127++;
				} while (true);
				}
				metric+="\"";
				break;
			}
			case COMA:
			case PUNTO_Y_COMA:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
				
				contenido += "\n <OfferItem name=\""+i2_AST+"\"";
				if (!metric.isEmpty()){
					contenido += " "+metric;
				}
				
				if (!value.isEmpty()){
					contenido += ">"+value+"</OfferItem>";
				}
				else{
				   contenido += "/>";	
				}
				//contenido+=	"\n <OfferItem name=\""+#i2+"\""+metric+" >"+value+"</OfferItem>"; 
			
			}
			mas_variables_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_31);
		}
		returnAST = mas_variables_AST;
	}
	
	public final void serviceDescriptionTermnAnidados() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST serviceDescriptionTermnAnidados_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  id2 = null;
		AST id2_AST = null;
		
		try {      // for error handling
			AST tmp147_AST = null;
			tmp147_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp147_AST);
			match(LIT_ENTERO);
			id = LT(1);
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(IDENT);
			AST tmp148_AST = null;
			tmp148_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp148_AST);
			match(MENOS);
			id2 = LT(1);
			id2_AST = astFactory.create(id2);
			astFactory.addASTChild(currentAST, id2_AST);
			match(IDENT);
			AST tmp149_AST = null;
			tmp149_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp149_AST);
			match(DOS_PUNTOS);
			
			nombre = "ServiceDescriptionTerm";
			contenido+="\n<wsag:ServiceDescriptionTerm wsag:Name=\""+id_AST+"\" \n wsag:ServiceName=\""+id2_AST+"\">";
			
			elementosServiceDescriptionTerm();
			astFactory.addASTChild(currentAST, returnAST);
			
			contenido+="\n</wsag:ServiceDescriptionTerm>";
			
			serviceDescriptionTermnAnidados_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = serviceDescriptionTermnAnidados_AST;
	}
	
	public final void serviceReferencesAnidados() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST serviceReferencesAnidados_AST = null;
		Token  i1 = null;
		AST i1_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		AST t_AST = null;
		
		try {      // for error handling
			
				acumulador1="";	
			
			AST tmp150_AST = null;
			tmp150_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp150_AST);
			match(LIT_ENTERO);
			i1 = LT(1);
			i1_AST = astFactory.create(i1);
			astFactory.addASTChild(currentAST, i1_AST);
			match(IDENT);
			AST tmp151_AST = null;
			tmp151_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp151_AST);
			match(MENOS);
			i2 = LT(1);
			i2_AST = astFactory.create(i2);
			astFactory.addASTChild(currentAST, i2_AST);
			match(IDENT);
			AST tmp152_AST = null;
			tmp152_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp152_AST);
			match(DOS_PUNTOS);
			{
			int _cnt140=0;
			_loop140:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					texto_ao_ac();
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					acumulador1+=t_AST + " ";
				}
				else {
					if ( _cnt140>=1 ) { break _loop140; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt140++;
			} while (true);
			}
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			
				contenido+= "\n<wsag:ServiceReferences wsag:Name=\""+i1_AST+"\" \n wsag:ServiceName=\""+i2_AST+"\"> \n"+eliminaMayorYMenor(acumulador1)+"\n";
				contenido+= "\n </wsag:ServiceReferences>";	
				
			serviceReferencesAnidados_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = serviceReferencesAnidados_AST;
	}
	
	public final void texto_dos_puntos_ac() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST texto_dos_puntos_ac_AST = null;
		
		try {      // for error handling
			{
			{
			AST tmp153_AST = null;
			tmp153_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp153_AST);
			match(_tokenSet_15);
			}
			}
			texto_dos_puntos_ac_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
		returnAST = texto_dos_puntos_ac_AST;
	}
	
	public final void elementosServicePropertiesTerm() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elementosServicePropertiesTerm_AST = null;
		Token  i = null;
		AST i_AST = null;
		AST d1_AST = null;
		AST d2_AST = null;
		
		try {      // for error handling
			
				acumulador1="";
				acumulador2="";
				
			
			AST tmp154_AST = null;
			tmp154_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp154_AST);
			match(LIT_ENTERO);
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(IDENT);
			AST tmp155_AST = null;
			tmp155_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp155_AST);
			match(MENOS);
			AST tmp156_AST = null;
			tmp156_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp156_AST);
			match(MEASURED);
			AST tmp157_AST = null;
			tmp157_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp157_AST);
			match(BY);
			{
			int _cnt153=0;
			_loop153:
			do {
				if ((_tokenSet_6.member(LA(1)))) {
					texto_menos_ac();
					d1_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					
						acumulador1+=d1_AST+" ";	
						
					
				}
				else {
					if ( _cnt153>=1 ) { break _loop153; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt153++;
			} while (true);
			}
			AST tmp158_AST = null;
			tmp158_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp158_AST);
			match(MENOS);
			AST tmp159_AST = null;
			tmp159_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp159_AST);
			match(RELATED);
			AST tmp160_AST = null;
			tmp160_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp160_AST);
			match(TO);
			{
			int _cnt155=0;
			_loop155:
			do {
				if ((_tokenSet_7.member(LA(1)))) {
					texto_cierre_frase_ac();
					d2_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					
						acumulador2+=d2_AST+"";
					
				}
				else {
					if ( _cnt155>=1 ) { break _loop155; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt155++;
			} while (true);
			}
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			
					contenido+="\n    <wsag:Variable wsag:Name=\""+i_AST+"\" wsag:Metric=\""+eliminaMayorYMenor(eliminaEspaciosTexto(acumulador1))+"\"> \n     <wsag:Location> \n       "+eliminaMayorYMenor(acumulador2) +"\n     </wsag:Location>\n    </wsag:Variable>";
			
			
			elementosServicePropertiesTerm_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_32);
		}
		returnAST = elementosServicePropertiesTerm_AST;
	}
	
	public final void servicePropertiesAnidados() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST servicePropertiesAnidados_AST = null;
		Token  i1 = null;
		AST i1_AST = null;
		Token  i2 = null;
		AST i2_AST = null;
		
		try {      // for error handling
			i1 = LT(1);
			i1_AST = astFactory.create(i1);
			astFactory.addASTChild(currentAST, i1_AST);
			match(IDENT);
			AST tmp161_AST = null;
			tmp161_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp161_AST);
			match(MENOS);
			i2 = LT(1);
			i2_AST = astFactory.create(i2);
			astFactory.addASTChild(currentAST, i2_AST);
			match(IDENT);
			AST tmp162_AST = null;
			tmp162_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp162_AST);
			match(DOS_PUNTOS);
			
					nombre ="ServiceProperties";
					contenido+= "\n<wsag:ServiceProperties wsag:Name=\""+i1_AST+"\" \n wsag:ServiceName=\""+i2_AST+"\"> \n  <wsag:VariableSet> \n";
				
			{
			int _cnt161=0;
			_loop161:
			do {
				if ((LA(1)==LIT_ENTERO) && (LA(2)==IDENT)) {
					elementosServicePropertiesTerm();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt161>=1 ) { break _loop161; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt161++;
			} while (true);
			}
			
					contenido+= "\n  </wsag:VariableSet> \n</wsag:ServiceProperties>";	
				
			servicePropertiesAnidados_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_32);
		}
		returnAST = servicePropertiesAnidados_AST;
	}
	
	public final void all() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST all_AST = null;
		
		try {      // for error handling
			
				nombre ="all";
				contenido += "\n<wsag:all>";	
			
			AST tmp163_AST = null;
			tmp163_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp163_AST);
			match(ALL);
			AST tmp164_AST = null;
			tmp164_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp164_AST);
			match(DOS_PUNTOS);
			all_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = all_AST;
	}
	
	public final void exactlyOne() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exactlyOne_AST = null;
		
		try {      // for error handling
			
				nombre ="eob";
				contenido += "\n<wsag:exactlyOne>";	
			
			AST tmp165_AST = null;
			tmp165_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp165_AST);
			match(EXACTLY);
			AST tmp166_AST = null;
			tmp166_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp166_AST);
			match(ONE);
			AST tmp167_AST = null;
			tmp167_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp167_AST);
			match(BETWEENMINUS);
			AST tmp168_AST = null;
			tmp168_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp168_AST);
			match(DOS_PUNTOS);
			exactlyOne_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = exactlyOne_AST;
	}
	
	public final void oneOrMoreBetween() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST oneOrMoreBetween_AST = null;
		
		try {      // for error handling
			
				nombre ="omb";
				contenido += "\n<wsag:OneOrMore>";	
			
			AST tmp169_AST = null;
			tmp169_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp169_AST);
			match(ONE);
			AST tmp170_AST = null;
			tmp170_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp170_AST);
			match(OR);
			AST tmp171_AST = null;
			tmp171_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp171_AST);
			match(MORE);
			AST tmp172_AST = null;
			tmp172_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp172_AST);
			match(BETWEENMINUS);
			AST tmp173_AST = null;
			tmp173_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp173_AST);
			match(DOS_PUNTOS);
			oneOrMoreBetween_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_11);
		}
		returnAST = oneOrMoreBetween_AST;
	}
	
	public final void conjuntoitems() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST conjuntoitems_AST = null;
		
		try {      // for error handling
			AST tmp174_AST = null;
			tmp174_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp174_AST);
			match(ITEMS);
			AST tmp175_AST = null;
			tmp175_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp175_AST);
			match(DOS_PUNTOS);
			items();
			astFactory.addASTChild(currentAST, returnAST);
			conjuntoitems_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_33);
		}
		returnAST = conjuntoitems_AST;
	}
	
	public final void conjuntoconstraints() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST conjuntoconstraints_AST = null;
		
		try {      // for error handling
			AST tmp176_AST = null;
			tmp176_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp176_AST);
			match(CONSTRAINT);
			AST tmp177_AST = null;
			tmp177_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp177_AST);
			match(DOS_PUNTOS);
			constraints();
			astFactory.addASTChild(currentAST, returnAST);
			conjuntoconstraints_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = conjuntoconstraints_AST;
	}
	
	public final void items() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST items_AST = null;
		
		try {      // for error handling
			{
			int _cnt173=0;
			_loop173:
			do {
				if ((LA(1)==LIT_ENTERO)) {
					item();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt173>=1 ) { break _loop173; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt173++;
			} while (true);
			}
			items_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_33);
		}
		returnAST = items_AST;
	}
	
	public final void item() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST item_AST = null;
		Token  id = null;
		AST id_AST = null;
		Token  d = null;
		AST d_AST = null;
		
		try {      // for error handling
			AST tmp178_AST = null;
			tmp178_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp178_AST);
			match(LIT_ENTERO);
			id = LT(1);
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(IDENT);
			AST tmp179_AST = null;
			tmp179_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp179_AST);
			match(DOS_PUNTOS);
			AST tmp180_AST = null;
			tmp180_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp180_AST);
			match(VALUE);
			AST tmp181_AST = null;
			tmp181_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp181_AST);
			match(OF);
			d = LT(1);
			d_AST = astFactory.create(d);
			astFactory.addASTChild(currentAST, d_AST);
			match(DIRECCION);
			AST tmp182_AST = null;
			tmp182_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp182_AST);
			match(IS);
			
				resultado += "\n      <wsag:Item wsag:Name=\""+id_AST+"\">"
				          +  "\n         <wsag:Location>\n          "+d_AST+"\n         </wsag:Location>"
				          +  "\n         <wsag:ItemConstraint>";
			
			
			tipo_datos();
			astFactory.addASTChild(currentAST, returnAST);
			
				
				resultado += "\n         </wsag:ItemConstraint>"
				          +  "\n      </wsag:Item>";	
			
			item_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_34);
		}
		returnAST = item_AST;
	}
	
	public final void tipo_datos() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tipo_datos_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case INTEGER:
			case FLOAT:
			case XS:
			{
				basico();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case IDENT:
			{
				enumerado();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			tipo_datos_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_34);
		}
		returnAST = tipo_datos_AST;
	}
	
	public final void basico() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST basico_AST = null;
		AST td_AST = null;
		AST ab_AST = null;
		Token  min = null;
		AST min_AST = null;
		Token  max = null;
		AST max_AST = null;
		AST c_AST = null;
		
		try {      // for error handling
			tipo_dato_exacto();
			td_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			abertura();
			ab_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			min = LT(1);
			min_AST = astFactory.create(min);
			astFactory.addASTChild(currentAST, min_AST);
			match(LIT_ENTERO);
			AST tmp183_AST = null;
			tmp183_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp183_AST);
			match(COMA);
			max = LT(1);
			max_AST = astFactory.create(max);
			astFactory.addASTChild(currentAST, max_AST);
			match(LIT_ENTERO);
			cerratura();
			c_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			
				
				resultado+= "\n              <xs:restriction base = \""+tipoConstraint+"\" >";
				          
				          
				AST s = ab_AST;
				
				char abertura = s.getText().charAt(0);
				
				if(abertura == '('){
				resultado+=" \n                 <xs:minExclusive value=\""+min_AST+"\" />";
				}else{
				resultado+=" \n                 <xs:minInclusive value=\""+min_AST+"\" />";
				}
				;
				
				s = c_AST;
				
				char cerratura = s.getText().charAt(0);
				
				if(cerratura == ')'){
				resultado+=" \n                 <xs:maxExclusive value=\""+max_AST+"\" />";
				}else{
				resultado+=" \n                 <xs:maxInclusive value=\""+max_AST+"\" />";
				}
				;          
				          
			
				
				
				resultado+= "\n              </xs:restriction>";
				
			
			basico_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_34);
		}
		returnAST = basico_AST;
	}
	
	public final void enumerado() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumerado_AST = null;
		Token  i = null;
		AST i_AST = null;
		Token  id = null;
		AST id_AST = null;
		
		try {      // for error handling
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(IDENT);
			AST tmp184_AST = null;
			tmp184_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp184_AST);
			match(ENUM);
			AST tmp185_AST = null;
			tmp185_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp185_AST);
			match(LLAVE_ABIERTA);
			id = LT(1);
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(IDENT);
			
				resultado+= "\n              <xs:simpleType name=\""+i_AST+"\">"
				          + "\n                 <xs:restriction base = \""+tipoConstraint+"\" >"
				          + "\n                    <xs:enumeration value=\""+id_AST+"\" />";
				          
			
			mas_elementos_enum();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp186_AST = null;
			tmp186_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp186_AST);
			match(LLAVE_CERRADA);
			cierre_frase();
			astFactory.addASTChild(currentAST, returnAST);
			
				
				resultado+= "\n                 </xs:restriction>"
				          + "\n              </xs:simpleType>";	
				
				
			
			enumerado_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_34);
		}
		returnAST = enumerado_AST;
	}
	
	public final void tipo_dato_exacto() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tipo_dato_exacto_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case INTEGER:
			{
				AST tmp187_AST = null;
				tmp187_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp187_AST);
				match(INTEGER);
				tipoConstraint="integer";
				break;
			}
			case FLOAT:
			{
				AST tmp188_AST = null;
				tmp188_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp188_AST);
				match(FLOAT);
				tipoConstraint="float";
				break;
			}
			default:
				if ((LA(1)==XS) && (LA(2)==DOS_PUNTOS) && (LA(3)==INTEGER)) {
					{
					AST tmp189_AST = null;
					tmp189_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp189_AST);
					match(XS);
					AST tmp190_AST = null;
					tmp190_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp190_AST);
					match(DOS_PUNTOS);
					AST tmp191_AST = null;
					tmp191_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp191_AST);
					match(INTEGER);
					}
					tipoConstraint="xs:integer";
				}
				else if ((LA(1)==XS) && (LA(2)==DOS_PUNTOS) && (LA(3)==FLOAT)) {
					{
					AST tmp192_AST = null;
					tmp192_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp192_AST);
					match(XS);
					AST tmp193_AST = null;
					tmp193_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp193_AST);
					match(DOS_PUNTOS);
					AST tmp194_AST = null;
					tmp194_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp194_AST);
					match(FLOAT);
					}
					tipoConstraint="xs:float";
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			tipo_dato_exacto_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_35);
		}
		returnAST = tipo_dato_exacto_AST;
	}
	
	public final void abertura() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST abertura_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case CORCHETE_ABIERTO:
			{
				AST tmp195_AST = null;
				tmp195_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp195_AST);
				match(CORCHETE_ABIERTO);
				break;
			}
			case PARENTESIS_ABIERTO:
			{
				AST tmp196_AST = null;
				tmp196_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp196_AST);
				match(PARENTESIS_ABIERTO);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			abertura_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_36);
		}
		returnAST = abertura_AST;
	}
	
	public final void cerratura() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST cerratura_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case CORCHETE_CERRADO:
			{
				AST tmp197_AST = null;
				tmp197_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp197_AST);
				match(CORCHETE_CERRADO);
				break;
			}
			case PARENTESIS_CERRADO:
			{
				AST tmp198_AST = null;
				tmp198_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp198_AST);
				match(PARENTESIS_CERRADO);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			cerratura_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_31);
		}
		returnAST = cerratura_AST;
	}
	
	public final void mas_elementos_enum() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST mas_elementos_enum_AST = null;
		Token  id = null;
		AST id_AST = null;
		
		try {      // for error handling
			{
			_loop189:
			do {
				if ((LA(1)==COMA)) {
					AST tmp199_AST = null;
					tmp199_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp199_AST);
					match(COMA);
					id = LT(1);
					id_AST = astFactory.create(id);
					astFactory.addASTChild(currentAST, id_AST);
					match(IDENT);
					
						resultado+="\n                    <xs:enumeration value=\""+id_AST+"\" />";
						
					
				}
				else {
					break _loop189;
				}
				
			} while (true);
			}
			mas_elementos_enum_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_37);
		}
		returnAST = mas_elementos_enum_AST;
	}
	
	public final void constraints() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constraints_AST = null;
		
		try {      // for error handling
			{
			int _cnt195=0;
			_loop195:
			do {
				if ((LA(1)==LIT_ENTERO||LA(1)==LIT_REAL||LA(1)==PUNTO)) {
					constraint();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt195>=1 ) { break _loop195; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt195++;
			} while (true);
			}
			constraints_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = constraints_AST;
	}
	
	public final void constraint() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constraint_AST = null;
		Token  id = null;
		AST id_AST = null;
		AST t_AST = null;
		
		try {      // for error handling
			{
			int _cnt198=0;
			_loop198:
			do {
				switch ( LA(1)) {
				case LIT_ENTERO:
				{
					AST tmp200_AST = null;
					tmp200_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp200_AST);
					match(LIT_ENTERO);
					break;
				}
				case LIT_REAL:
				{
					AST tmp201_AST = null;
					tmp201_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp201_AST);
					match(LIT_REAL);
					break;
				}
				case PUNTO:
				{
					AST tmp202_AST = null;
					tmp202_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp202_AST);
					match(PUNTO);
					break;
				}
				default:
				{
					if ( _cnt198>=1 ) { break _loop198; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				}
				_cnt198++;
			} while (true);
			}
			id = LT(1);
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(IDENT);
			AST tmp203_AST = null;
			tmp203_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp203_AST);
			match(DOS_PUNTOS);
			
				
				resultado += "\n      <wsag:Constraint>"
				          +  "\n          <Name>\n            "+id_AST;	
			
				
				
				resultado += "\n          </Name>";
				resultado += "\n          <Content>\n            ";
			
			{
			int _cnt200=0;
			_loop200:
			do {
				if ((_tokenSet_7.member(LA(1)))) {
					contenidoConstraint();
					t_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					
						AST arbol = t_AST;
						
						resultado += eliminaMayorYMenor(arbol.getText())+" ";
					
				}
				else {
					if ( _cnt200>=1 ) { break _loop200; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt200++;
			} while (true);
			}
			{
			switch ( LA(1)) {
			case COMA:
			{
				AST tmp204_AST = null;
				tmp204_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp204_AST);
				match(COMA);
				break;
			}
			case PUNTO_Y_COMA:
			{
				AST tmp205_AST = null;
				tmp205_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp205_AST);
				match(PUNTO_Y_COMA);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			
				
				resultado += "\n          </Content>";
				resultado += "\n      </wsag:Constraint>";	
			
			
			constraint_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_38);
		}
		returnAST = constraint_AST;
	}
	
	public final void contenidoConstraint() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contenidoConstraint_AST = null;
		
		try {      // for error handling
			{
			AST tmp206_AST = null;
			tmp206_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp206_AST);
			match(_tokenSet_7);
			}
			contenidoConstraint_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = contenidoConstraint_AST;
	}
	
	public final void condicionada() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST condicionada_AST = null;
		Token  id1 = null;
		AST id1_AST = null;
		Token  id2 = null;
		AST id2_AST = null;
		Token  id3 = null;
		AST id3_AST = null;
		Token  id4 = null;
		AST id4_AST = null;
		
		try {      // for error handling
			AST tmp207_AST = null;
			tmp207_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp207_AST);
			match(IF);
			id1 = LT(1);
			id1_AST = astFactory.create(id1);
			astFactory.addASTChild(currentAST, id1_AST);
			match(IDENT);
			AST tmp208_AST = null;
			tmp208_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp208_AST);
			match(IGUAL);
			id2 = LT(1);
			id2_AST = astFactory.create(id2);
			astFactory.addASTChild(currentAST, id2_AST);
			match(IDENT);
			AST tmp209_AST = null;
			tmp209_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp209_AST);
			match(IMPLICACION);
			id3 = LT(1);
			id3_AST = astFactory.create(id3);
			astFactory.addASTChild(currentAST, id3_AST);
			match(IDENT);
			AST tmp210_AST = null;
			tmp210_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp210_AST);
			match(IGUAL);
			id4 = LT(1);
			id4_AST = astFactory.create(id4);
			astFactory.addASTChild(currentAST, id4_AST);
			match(IDENT);
			AST tmp211_AST = null;
			tmp211_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp211_AST);
			match(COMA);
			condicionada_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = condicionada_AST;
	}
	
	public final void no_se_usan() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST no_se_usan_AST = null;
		
		try {      // for error handling
			AST tmp212_AST = null;
			tmp212_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp212_AST);
			match(EXCLAMACION);
			no_se_usan_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = no_se_usan_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"LIT_ENTERO",
		"LIT_REAL",
		"PROGRAMA",
		"VISIBLE",
		"OCULTO",
		"NO_INST",
		"ATRIBUTO",
		"METODO",
		"PROTOTIPO",
		"PARAMETRO",
		"PARAMETROS",
		"EXPRESIONES",
		"RESULTADO",
		"DEFINICION",
		"VACIO",
		"VARIABLE_LOCAL",
		"VARIABLES_LOCALES",
		"INSTRUCCION",
		"INSTRUCCIONES",
		"MENOSUNARIO",
		"LLAMADA",
		"ACCESO_TABLA",
		"ACCESO_OBJETO",
		"ACCESO_SIMPLE",
		"ACCESO_PREDEFINIDO",
		"LISTA_ENTEROS",
		"MODULO",
		"IDENT",
		"MENOS",
		"DOS_PUNTOS",
		"AGREEMENTOFFER",
		"TEMPLATE",
		"COMA",
		"PUNTO_Y_COMA",
		"PUNTO",
		"INITIATOR",
		"RESPONDER",
		"SERVICEPROVIDER",
		"EXPIRATIONTIME",
		"TEMPLATEID",
		"TEMPLATENAME",
		"TERMS",
		"GUARANTEES",
		"ALMOHADILLA",
		"PARENTESIS_ABIERTO",
		"BY",
		"PARENTESIS_CERRADO",
		"GUARANTEE",
		"SERVICECONSUMER",
		"UTILITY",
		"IFMINUS",
		"SELECTED",
		"IGUAL",
		"MAYOR",
		"CUSTOM",
		"BUSINESS",
		"VALUE",
		"RELATIVE",
		"IMPORTANCE",
		"BETWEENMINUS",
		"GUARANTEESMINUS",
		"REWARD",
		"ASSESSED",
		"IN",
		"INVOCATION",
		"PENALTY",
		"MAS",
		"DIVISION",
		"POR",
		"MENOR",
		"DISTINTO",
		"MENOR_IGUAL",
		"MAYOR_IGUAL",
		"SLO",
		"KPI",
		"QUALIFYING",
		"CONDITION",
		"SCOPES",
		"SERVICE",
		"DESCRIPTION",
		"TERM",
		"MEASURED",
		"REFERENCE",
		"REFERENCES",
		"PROPERTIES",
		"RELATED",
		"TO",
		"ALL",
		"EXACTLY",
		"ONE",
		"OR",
		"MORE",
		"CREATION",
		"CONSTRAINT",
		"ITEMS",
		"OF",
		"DIRECCION",
		"IS",
		"CORCHETE_ABIERTO",
		"CORCHETE_CERRADO",
		"INTEGER",
		"FLOAT",
		"XS",
		"ENUM",
		"LLAVE_ABIERTA",
		"LLAVE_CERRADA",
		"IF",
		"IMPLICACION",
		"EXCLAMACION"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { -219043332112L, 562949953421311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 274877906992L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 35184372088832L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 2L, 4294967296L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { -16L, 562949953421311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { -4294967312L, 562949953421311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { -206158430224L, 562949953421311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 35459249995824L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 8589934592L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 585644150443999282L, 12884901922L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 274877906994L, 4294967296L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 2322168557862912L, 939786240L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 4294967296L, 21495808L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 8589934592L, 25690112L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { -12884901904L, 562949953421311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 141012366262322L, 4294967296L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { -140741783322640L, 562949953421311L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 4294967296L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 1125899906842624L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 0L, 57344L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 0L, 24576L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = { 216172788556234768L, 8128L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = { 576601764669685810L, 4294967296L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = { 9007199254740992L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = { 288230376151711744L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = new long[8];
		data[0]=-481036337168L;
		data[1]=562949953421295L;
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = { 9007199254740992L, 34L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = { 9007199254740992L, 2L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = { 216172925995188240L, 8128L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = { 137438953472L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = { 206158430208L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = { 277025390642L, 4294967296L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = { 2L, 8589934592L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = { 18L, 8589934592L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = { 281474976710656L, 274877906944L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = { 16L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = { 0L, 35184372088832L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = { 274877906994L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	
	}

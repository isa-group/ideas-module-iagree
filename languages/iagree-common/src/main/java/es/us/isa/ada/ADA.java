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

package es.us.isa.ada;

import es.us.isa.ada.document.AbstractDocument;
import es.us.isa.ada.loaders.ExtensionsLoader;
import es.us.isa.ada.operations.ExplainMoreRestrictiveOfferOperation;
import es.us.isa.ada.subfacades.AnalysisManager;
import es.us.isa.ada.subfacades.DocumentsManager;
import es.us.isa.ada.subfacades.TransformManager;

public class ADA {

	protected ExtensionsLoader extLoader;
	protected AnalysisManager anManager;	
	protected DocumentsManager docManager;
	protected TransformManager transManager;
	
	//TODO cargar estos valores desde el fichero de config
	public final static String CONSISTENCY = "Consistency";
	public final static String TEMPORAL_CONSISTENCY = "TemporalConsistency";
	public final static String EXPLAIN_NON_CONSISTENCY = "ExplainNonConsistency";
	public final static String TEMPORAL_EXPLAIN_NO_CONSISTENCY = "TemporalExplainNonConsistency";
	public final static String ALTERNATIVE_DOCUMENTS = "AlternativeDocuments";
	public final static String NUMBER_OF_ALTERNATIVES = "NumberOfAlternatives";
	public final static String COMPLIANCE = "Compliance";
	public final static String LESSRESTRICTIVEOFFERCOMPLIANCE = "LessRestrictiveOfferCompliance";
	public final static String EXPLAIN_MORE_RESTRICTIVE_OFFER = "ExplainMoreRestrictiveOffer";
	public final static String MORERESTRICTIVETEMPLATETERMSCOMPLIANCE = "MoreRestrictiveTemplateTermsCompliance";
	public final static String EXPLAIN_LESS_RESTRICTIVE_TEMPLATE_TERMS = "ExplainLessRestrictiveTemplateTerms";
	public final static String TEMPORAL_COMPLIANCE = "TemporalCompliance";
	public final static String EXPLAIN_NON_COMPLIANCE = "ExplainNonCompliance";
	public final static String LUDICROUS_TERMS = "LudicrousTerms";
	public final static String DEAD_TERMS = "DeadTerms";
	public final static String EXPLAIN_LUDICROUS_TERMS = "ExplainLudicrousTerms";
	public final static String EXPLAIN_DEAD_TERMS = "ExplainDeadTerms";
	public final static String AGREEMENT_FULFILMENT = "AgreementFulfilment";
	public final static String VIOLATION_EXPLANATIONS = "ViolationExplanations";
	public final static String VIEWS = "Views";
	
	
	
	/**
	 * Default constructor
	 */
	public ADA(ExtensionsLoader extLoader){
        anManager = extLoader.getAnalysisManager();
        docManager = extLoader.getDocumentsManager();
        transManager = extLoader.getTransformManager();
	}


	/**
	 * Loads a document from the path specified and returns it
	 * @param path
	 * @return AbstractDocument
	 */
	public AbstractDocument loadDocument(String path){
		return docManager.loadDocument(path);
	}
	
	/**
	 * Writes into file a document. Under construction
	 * @param doc AbstractDocument the document to write
	 * @param path String path of the file
	 */
	public void writeDocument(AbstractDocument doc, String path){
		docManager.writeDocument(doc, path);
	}
	
	/**
	 * Creates an operation from its id. Ids are available
	 * at this class as public final static attributes
	 * @param id String 
	 * @return Operation
	 */
	public Operation createOperation(String id){
		return anManager.createQuestion(id);
	}
	
	/**
	 * It analyses an operation. Previously, all parameters have been
	 * set on the operation
	 * @param op Operation 
	 */
	public void analyze(Operation op){
		anManager.analyze(op);
	}
	
	/**
	 * Transforms an input file defining a model into
	 * another type of input file. It returns the model
	 * converted into the new type
	 * 
	 * @param source String original input format
	 * @param sourceFormat original input format id or extension
	 * @param destFormat new input format it or extension
	 * @return String new input format
	 */
	public String transformTo(String source, String sourceFormat, String destFormat){
		String res = transManager.transformTo(source, sourceFormat, destFormat);
		return res;
	}
	
	/**
	 * Writes the source file represented by the first pathname
	 * into another format on the path represented by the
	 * second pathname
	 * 
	 * @param source
	 * @param dest
	 */
	public void transformTo(String source, String dest){
		transManager.transformTo(source, dest);
	}
	
}

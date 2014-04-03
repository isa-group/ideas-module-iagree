package es.us.isa.ada.choco.utils;
///**
// * 	This file is part of ADA.
// *
// *     ADA is free software: you can redistribute it and/or modify
// *     it under the terms of the GNU Lesser General Public License as published by
// *     the Free Software Foundation, either version 3 of the License, or
// *     (at your option) any later version.
// *
// *     ADA is distributed in the hope that it will be useful,
// *     but WITHOUT ANY WARRANTY; without even the implied warranty of
// *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// *     GNU Lesser General Public License for more details.
// *
// *     You should have received a copy of the GNU Lesser General Public License
// *     along with ADA.  If not, see <http://www.gnu.org/licenses/>.
// */
//
//package es.us.isa.ada.choco.utils;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//
//import es.us.isa.ada.ADA;
//import es.us.isa.ada.Analyzer;
//import es.us.isa.ada.Operation;
//import es.us.isa.ada.choco.ChocoAnalyzer;
//import es.us.isa.ada.choco.questions.ChocoAlternativeDocumentsOp;
//import es.us.isa.ada.choco.questions.ChocoComplianceOp;
//import es.us.isa.ada.choco.questions.ChocoConsistencyOp;
//import es.us.isa.ada.choco.questions.ChocoExplainNoConsistencyOp;
//import es.us.isa.ada.choco.questions.ChocoQuickxplainNoComplianceOp;
//import es.us.isa.ada.document.OperationParameters;
//import es.us.isa.ada.loaders.ExtensionsLoader;
//import es.us.isa.ada.operations.AlternativeDocumentsOperation;
//import es.us.isa.ada.operations.ComplianceOperation;
//import es.us.isa.ada.operations.ConsistencyOperation;
//import es.us.isa.ada.operations.ExplainNoConsistencyOperation;
//import es.us.isa.ada.operations.ExplainNonComplianceOperation;
//import es.us.isa.ada.selectors.DefaultSelectorCriteria;
//import es.us.isa.ada.selectors.SelectorCriteria;
//import es.us.isa.ada.subfacades.ADAManager;
//import es.us.isa.ada.subfacades.AnalysisManager;
//import es.us.isa.ada.subfacades.DocumentsManager;
//import es.us.isa.ada.subfacades.ProxyAnalyzer;
//import es.us.isa.ada.subfacades.TransformManager;
//import es.us.isa.ada.wsag10.parsers.DefaultWSAgParser;
//
//public class ADAChocoFacade extends ADA {
//
//	public ADAChocoFacade(){
//		extLoader = new ChocoExtensionsLoader();
//		anManager = extLoader.getAnalysisManager();
//		docManager = extLoader.getDocumentsManager();
//	}
//	
//	
//	class ChocoExtensionsLoader implements ExtensionsLoader{
//
//		private AnalysisManager am;
//		private DocumentsManager dm;
//		
//		public ChocoExtensionsLoader(){
//			loadFromScratch();	
//		}
//		
//		
//		
//		private void loadFromScratch() {
//			//primero las operaciones disponibles
//			Map<String,Class<? extends Operation>> operations = new HashMap<String, Class<? extends Operation>>();
//			operations.put(ADA.CONSISTENCY, ConsistencyOperation.class);
//			operations.put(ADA.COMPLIANCE, ComplianceOperation.class);
//			operations.put(ADA.ALTERNATIVE_DOCUMENTS, AlternativeDocumentsOperation.class);
//			operations.put(ADA.EXPLAIN_NON_CONSISTENCY, ExplainNoConsistencyOperation.class);
//			operations.put(ADA.EXPLAIN_NON_COMPLIANCE, ExplainNonComplianceOperation.class);
////			operations.put(ADA.expl, ExplainComplianceOperation.class);
//			
//			// TODO ahora los analizadores (solo choco) con sus operaciones implementadas
//			Collection<ProxyAnalyzer> analyzers = new LinkedList<ProxyAnalyzer>();
//			Analyzer choco = new ChocoAnalyzer();
//			Map<String,Class<? extends Operation>> chocoOps = new HashMap<String, Class<? extends Operation>>();
//			chocoOps.put(ADA.CONSISTENCY, ChocoConsistencyOp.class);
//			chocoOps.put(ADA.COMPLIANCE, ChocoComplianceOp.class);
//			chocoOps.put(ADA.ALTERNATIVE_DOCUMENTS, ChocoAlternativeDocumentsOp.class);
//			chocoOps.put(ADA.EXPLAIN_NON_CONSISTENCY, ChocoExplainNoConsistencyOp.class);
//			chocoOps.put(ADA.EXPLAIN_NON_COMPLIANCE, ChocoQuickxplainNoComplianceOp.class);
////			chocoOps.put("explainCompliance", ChocoExplainComplianceOp.class);
//			
//			ProxyAnalyzer chocoProxy = new ProxyAnalyzer("Choco", choco, chocoOps);
//			analyzers.add(chocoProxy);
//			
//			// TODO tb el criteria selector (el default)
//			SelectorCriteria sc = new DefaultSelectorCriteria();
//			
//			// TODO parametros de cada operacion
//			Map<String,OperationParameters> params = new HashMap<String, OperationParameters>();
//			OperationParameters parametros;
//			parametros = new OperationParameters(-1, -1, 1);
//			params.put(ADA.CONSISTENCY, parametros);
//			params.put(ADA.ALTERNATIVE_DOCUMENTS, parametros);
//			params.put(ADA.EXPLAIN_NON_CONSISTENCY, parametros);
//			parametros = new OperationParameters(1, 1, 2);
//			params.put(ADA.COMPLIANCE, parametros);
//			params.put(ADA.EXPLAIN_NON_COMPLIANCE, parametros);
////			params.put("explainCompliance", parametros);
//			
//			//finalmente, creamos el AnalysisManager
//			am = new AnalysisManager(analyzers, sc);
//			
//			//TODO por ultimo, el reader para los documentos
//			dm = new DocumentsManager();
//			dm.addParser("wsag", new DefaultWSAgParser());
//			dm.addParser("xml", new DefaultWSAgParser());
//		}
//
//		@Override
//		public AnalysisManager getAnalysisManager() {
//			return am;
//		}
//
//		@Override
//		public DocumentsManager getDocumentsManager() {
//			return dm;
//		}
//
//
//
//		@Override
//		public TransformManager getTransformManager() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//
//
//		@Override
//		public ADAManager getADAManager() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//	}
//	
//	
//}

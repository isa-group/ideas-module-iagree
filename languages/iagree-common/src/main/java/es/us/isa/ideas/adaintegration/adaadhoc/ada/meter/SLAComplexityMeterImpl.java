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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.meter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.ADA;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders.ExtensionsLoader;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders.ReflexionExtensionsLoader;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.AlternativeDocumentsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.DecomposeIntoViewsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceScope;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.TermCompositor;

public class SLAComplexityMeterImpl implements SLAComplexityMeter{

	private ADA ada;
	
	public SLAComplexityMeterImpl(){
		ExtensionsLoader el = new ReflexionExtensionsLoader();
		ada = new ADA(el);
	}

	@Override
	public Integer amountOfGT(String doc) throws BadSyntaxException {
		try{
			File f = toTempFile(doc);
			String docPath = f.getAbsolutePath();
			AbstractDocument absDoc = ada.loadDocument(docPath);
			
			Integer amountOfGT = 0;
			AbstractAgreementDocument agDoc = (AbstractAgreementDocument) absDoc;
			amountOfGT = getNumberOfGT(agDoc.getAllTerms());
	
			deleteTempFiles(f);
			return amountOfGT;
		}catch(NullPointerException e){
			e.printStackTrace();
			throw new BadSyntaxException();
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer amountOfVariants(String doc) throws BadSyntaxException {
		try{
			File f = toTempFile(doc);
			String docPath = f.getAbsolutePath();
			AbstractDocument absDoc = ada.loadDocument(docPath);
			
			AlternativeDocumentsOperation altDocsOp = (AlternativeDocumentsOperation) ada.createOperation(ADA.ALTERNATIVE_DOCUMENTS);
			altDocsOp.addDocument(absDoc);
			ada.analyze(altDocsOp);
			Integer amountOfVariants = altDocsOp.getNumberOfDocuments();
			deleteTempFiles(f);
			return amountOfVariants;
		}catch(NullPointerException e){
			e.printStackTrace();
			throw new BadSyntaxException();
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer amountOfServiceOperations(String doc) throws BadSyntaxException {
		try{
			File f = toTempFile(doc);
			String docPath = f.getAbsolutePath();
			AbstractDocument absDoc = ada.loadDocument(docPath);
			
			DecomposeIntoViewsOperation viewsOp = (DecomposeIntoViewsOperation) ada.createOperation(ADA.VIEWS);
			viewsOp.addDocument(absDoc);
			ada.analyze(viewsOp);
			Map<ServiceScope, AbstractDocument> views = viewsOp.getScopes2Views();
			Integer amountOfServiceOperations = views.keySet().size();
			deleteTempFiles(f);
			return amountOfServiceOperations;
		}catch(NullPointerException e){
			e.printStackTrace();
			throw new BadSyntaxException();
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	private Integer getNumberOfGT(Collection<Term> terms){
		Integer numberOfGT = 0;
		for(Term t:terms){
			if(t instanceof GuaranteeTerm){
				numberOfGT++;
			}else if(t instanceof TermCompositor){
				numberOfGT += getNumberOfGT(((TermCompositor) t).getComprisedTerms());
			}
		}
		return numberOfGT;
	}
	
	private File toTempFile(String in) throws IOException {
		File f = File.createTempFile("tmp", ".wsag");
		FileOutputStream os = new FileOutputStream(f);
		os.write(in.getBytes());
		os.flush();
		os.close();
		return f;
	}

	private void deleteTempFiles(File... files) {
		for (int i = 0; i < files.length; i++) {
			files[i].delete();
		}
	}
}

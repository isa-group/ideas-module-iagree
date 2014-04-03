package es.us.isa.facade;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class AdaFacadeTest {
	//consistency positivo y negativo
	@Test
	public void consistency() throws IOException{
		AdaFacade ada = new AdaFacade();
		String doc = new String(Files.readAllBytes(Paths.get("consistentPrueba.xml")));
		assertTrue(ada.consistency(doc) == true);
	}
	
	@Test
	public void inconsistency() throws IOException{
		AdaFacade ada = new AdaFacade();
		String doc = new String(Files.readAllBytes(Paths.get("inconsistentPrueba.xml")));
		assertTrue(ada.consistency(doc) == false);
	}
	
	//inconsistenciesMap
	@Test
	public void inconsistenciesMap() throws IOException{
		AdaFacade ada = new AdaFacade();
		String doc = new String(Files.readAllBytes(Paths.get("inconsistentPrueba.xml")));
		String string = ada.inconsistenciesMap(doc).toString();
		assertTrue(string.contains("C5=[G2]") && string.contains("C6=[G4]"));
	}
	
	//inconsitencyExplaining
	@Test
	public void inconsitencyExplaining() throws IOException{
		AdaFacade ada = new AdaFacade();
		String doc = new String(Files.readAllBytes(Paths.get("inconsistentPrueba.xml")));
		String string = ada.inconsitencyExplaining(doc);
		assertTrue(string.contains("C5 Cause: G2") && string.contains("C6 Cause: G4"));
	}

	//isCompliant
	@Test
	public void isCompilant() throws IOException{
		AdaFacade ada = new AdaFacade();
		String template = new String(Files.readAllBytes(Paths.get("complianceTemplate2.xml")));
		String offer = new String(Files.readAllBytes(Paths.get("complianceOffer2.xml")));
		assertTrue(ada.isCompliant(template, offer));
	}
	
	@Test
	public void isNoCompilant() throws IOException{
		AdaFacade ada = new AdaFacade();
		String template = new String(Files.readAllBytes(Paths.get("complianceTemplate2.xml")));
		String offer = new String(Files.readAllBytes(Paths.get("nonComplianceOffer2.xml")));
		assertFalse(ada.isCompliant(template, offer));
	}
	
	//getNumberOfAlternatives
	@Test
	public void getNumberOfAlternatives() throws IOException{
		AdaFacade ada = new AdaFacade();
		String doc = new String(Files.readAllBytes(Paths.get("complianceTemplate2.xml")));
		assertTrue(ada.getNumberOfAlternatives(doc)==1);
	}
	
	//nonCompilanceExplaining
	@Test
	public void nonCompilanceExplaining() throws IOException{
		AdaFacade ada = new AdaFacade();
		String template = new String(Files.readAllBytes(Paths.get("complianceTemplate2.xml")));
		String offer = new String(Files.readAllBytes(Paths.get("nonComplianceOffer2.xml")));
		String string = ada.nonComplianceExplaining(template, offer);
		assertTrue(string.contains("Conflicting Template Term: G3"));
	}

}

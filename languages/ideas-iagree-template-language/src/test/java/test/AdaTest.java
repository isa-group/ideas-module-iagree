package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import es.us.isa.ideas.adaintegration.iagree.AdaFacade;

public class AdaTest{
	public static void main(String[] args) throws IOException{
		AdaFacade ada = new AdaFacade();
		String doc = new String(Files.readAllBytes(Paths.get("consistentPrueba.xml")));
		System.out.println(ada.consistency(doc));
	}
}

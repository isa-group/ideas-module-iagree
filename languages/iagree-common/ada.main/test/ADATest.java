package test;

import java.io.File;
import java.io.FileInputStream;

import es.us.isa.ada.ADA;
import es.us.isa.ada.loaders.ExtensionsLoader;
import es.us.isa.ada.loaders.ReflexionExtensionsLoader;
import es.us.isa.ada.service.ADAServiceImpl;
import es.us.isa.ada.service.ADAServiceV2;

public class ADATest {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream=null;
        File file = new File("C:\\prueba.txt");
        byte[] wsagBytes = new byte[(int) file.length()];
        fileInputStream = new FileInputStream(file);
	    fileInputStream.read(wsagBytes);
	    fileInputStream.close();
	    
	    for (int i = 0; i < wsagBytes.length; i++) {
	       	System.out.print((char)wsagBytes[i]);
            }
	    
		ExtensionsLoader extLoad = new ReflexionExtensionsLoader();
		ADA a = new ADA(extLoad);
		ADAServiceV2 ada = new ADAServiceImpl(a);
		Boolean isConsistent = false;
		
		if (ada.checkDocumentConsistency(wsagBytes)){	
			if (ada.getDeadTerms(wsagBytes).size()==0){
				if (ada.getLudicrousTerms(wsagBytes).size()==0){
					isConsistent = true;
				}
			}
		}
		System.out.println(isConsistent);

	}

}
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
		//nombre de ficheros
		String prueba = "iAgreeInconsistentTemplate.xml";
		String metricas = "iAgreeInconsistentTemplateMetrics.xml";
		//leer fichero de ejemplo
		FileInputStream fileInputStream=null;
        File file = new File(prueba);
        byte[] wsagBytes = new byte[(int) file.length()];
        fileInputStream = new FileInputStream(file);
	    fileInputStream.read(wsagBytes);
	    fileInputStream.close();
	    //mostrarlo para que veamos que se ha leido correctamente
	    for (int i = 0; i < wsagBytes.length; i++) {
	       	System.out.print((char)wsagBytes[i]);
            }
	    
	    System.out.print("\n\n");
	    
	    //leer el fichero de metricas
	    File filetwo = new File(metricas);
        byte[] data = new byte[(int) filetwo.length()];
        fileInputStream = new FileInputStream(filetwo);
	    fileInputStream.read(data);
	    fileInputStream.close();
        //mostrarlo para que veamos que se ha leido correctamente
	    for (int i = 0; i < data.length; i++) {
	       	System.out.print((char)data[i]);
            }
	    
	    System.out.print("\n\n");
	    
        //nombre del fichero
        byte[] name = metricas.getBytes();
        //mostrarlo para que veamos que se ha leido correctamente
	    for (int i = 0; i < name.length; i++) {
	       	System.out.print((char)name[i]);
            }
        
        System.out.print("\n\n");

		ExtensionsLoader extLoad = new ReflexionExtensionsLoader();
		ADA a = new ADA(extLoad);
		ADAServiceV2 ada = new ADAServiceImpl(a);
		
		String resultMetrics = ada.addMetricFile(data, name);
		
		System.out.println(resultMetrics);
		Boolean isConsistent = false;
		
		if (ada.checkDocumentConsistency(wsagBytes)){	
			if (ada.getDeadTerms(wsagBytes).size()==0){
				if (ada.getLudicrousTerms(wsagBytes).size()==0){
					isConsistent = true;
				}
			}
		}
		System.out.println(isConsistent);
		System.out.println(ada.explainInconsistencies(wsagBytes));

	}

}
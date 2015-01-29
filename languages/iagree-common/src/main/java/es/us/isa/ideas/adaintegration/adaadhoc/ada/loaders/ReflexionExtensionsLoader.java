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
package es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.Analyzer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.Operation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.selectors.DefaultSelectorCriteria;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.subfacades.*;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.parsers.DefaultWSAgParser;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.transforms.WSAg4PeopleTransform;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.transforms.WSAgPeople2XMLTransform;

import org.antlr.runtime.RecognitionException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;

/**
 * User: resinas
 * Date: 10/06/13
 * Time: 18:27
 */
public class ReflexionExtensionsLoader implements ExtensionsLoader {

    private AnalysisManager analysisManager;
    private DocumentsManager documentsManager;
    private TransformManager transformManager;

    public ReflexionExtensionsLoader() {
        loadWithReflextion();
    }

    private void loadWithReflextion() {
        // TODO use a config file
        //to load choco analyser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        InputStream adaConfig = null;
        try {
        	//File carpeta = new File("C:/workspaceADA/iAgreeStudioServerComponent/config");
        	//File carpeta = new File("C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/iAgreeStudioServerComponent/config");
//        	File carpeta = new File("config");
//    		String[] lista = carpeta.list();
//    		
//    		for (int i = 0; i < lista.length; i++) {
//    			if (lista[i].endsWith("ADAConfig.xml")) {
//    				FileInputStream fis;
//    				try {
//    					fis = new FileInputStream(carpeta+"/"+lista[i]);
//    					//fis = new FileInputStream(carpeta+"\\"+lista[i]);
//    					//fis = new FileInputStream(carpeta.getCanonicalPath()+"\\"+lista[i]);
//    					//System.out.println(carpeta+"/"+lista[i]);
//    					//System.out.println(carpeta+"\\"+lista[i]);
//    					//System.out.println("GetAbsolutePath: "+carpeta.getAbsolutePath()+"\\"+lista[i]);
//    					//System.out.println("getCanonicalPath: "+carpeta.getCanonicalPath()+"\\"+lista[i]);
//    					
//    					adaConfig = fis;
//    				}
//    				catch (FileNotFoundException e) {
//    					// TODO Auto-generated catch block
//    					e.printStackTrace();
//    				} catch (IOException e) {
//    					// TODO Auto-generated catch block
//    					e.printStackTrace();
//    				} 
//    			}
//    			}
//    			
            adaConfig = this.getClass().getClassLoader().getResourceAsStream("/config/ADAConfig.xml");
            
        	//InputStream adaConfig = this.getClass().getResourceAsStream("C:/workspaceADA/iAgreeStudioServerComponent/config/ADAConfig.xml");
        	//InputStream adaConfig = this.getClass().getClassLoader().get.getResourceAsStream("C:\\workspaceADA\\iAgreeStudioServerComponent\\config\\ADAConfig.xml");
            
        	DocumentBuilder builder = factory.newDocumentBuilder();
            Document configDocument = builder.parse(adaConfig);
            Node root = configDocument.getDocumentElement();
            NodeList children = root.getChildNodes();
            int lenght = children.getLength();

            Collection<ProxyAnalyzer> proxies = new LinkedList<ProxyAnalyzer>();

            for (int i = 0; i < lenght; i++){
                Node n = children.item(i);
                if (n.getNodeName().equalsIgnoreCase("Analyzer")){
                    //cargamos el analizador
                    NamedNodeMap atts = n.getAttributes();
                    String id = atts.getNamedItem("id").getTextContent();
                    String path = atts.getNamedItem("implementation").getTextContent();
                                        
                    Class<Analyzer> clazz = (Class<Analyzer>) Class.forName(path);
                    Analyzer an = clazz.newInstance();
                    ProxyAnalyzer proxy = new ProxyAnalyzer(id,an);

                    NodeList children2 = n.getChildNodes();
                    int lenght2 = children2.getLength();
                    for (int j = 0; j < lenght2; j++){
                        Node n2 = children2.item(j);
                        if (n2.getNodeName().equalsIgnoreCase("Operation")){
                            NamedNodeMap atts2 = n2.getAttributes();
                            String id2 = atts2.getNamedItem("id").getTextContent();
                            String path2 = atts2.getNamedItem("implementation").getTextContent();
                            Class<Operation> clazz2 = (Class<Operation>) Class.forName(path2);
                            //TODO terminar esto
                            proxy.addOperation(id2, clazz2);
                        }
                    }
                    proxies.add(proxy);

                }
            }

            analysisManager = new AnalysisManager(proxies, new DefaultSelectorCriteria());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        documentsManager = new DocumentsManager();
        documentsManager.addParser("wsag", new DefaultWSAgParser());

        transformManager = new TransformManager();
        transformManager.addTransform(new WSAg4PeopleTransform());
        transformManager.addTransform(new WSAgPeople2XMLTransform());
    }

    @Override
    public AnalysisManager getAnalysisManager() {
        return analysisManager;
    }

    @Override
    public DocumentsManager getDocumentsManager() {
        return documentsManager;
    }

    @Override
    public TransformManager getTransformManager() {
        return transformManager;
    }

    @Override
    public ADAManager getADAManager() {
        throw new UnsupportedOperationException("ADAManager is not supported in Reflexion Extensions Loader");
    }
}

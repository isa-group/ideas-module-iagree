package es.us.isa.ideas.adaintegration.adaadhoc.iagreeservercomponent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MetricRewriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File f = new File(args[0]);//esto ahora mismo es temporal
//		MetricRewriter mr = new MetricRewriter();
//		mr.renameMetric(f);
		File f = new File("/Users/jesus/Documents/workspace/Pruebas/pruebasExplainNonCompliance");
		MetricRewriter mr = new MetricRewriter();
		mr.walkDeep(f);
	}
	
	private void walkDeep(File f){
		FilenameFilter filter = new ExtensionFilter("wsag");
		File[] files = f.listFiles(filter);
		if (files != null){
			for (File file:files){
				renameMetric(file);
			}
		}
		
		
		FilenameFilter dirFilter = new DirectoryFilter();
		File[] dirs = f.listFiles(dirFilter);
		if (dirs != null){
			for (File file:dirs){
				walkDeep(file);
			}
		}
		
	}
	
	private void renameMetric(File f){
		try {
			List<String> lines = new LinkedList<String>();
			BufferedReader bf = new BufferedReader(new FileReader(f));
			String s;
			while ((s = bf.readLine()) != null){
				if (s.contains("wsag:Metric")){
					//separamos en tres partes el string
					//1 la anterior al metric
					//2 el metric
					//3 la posterior al metric
					int index1 = s.indexOf("wsag:Metric");
					String s1 = s.substring(0,index1);
					int index2 = s.lastIndexOf(":");
//					String s2 = s.substring(index1,index2);
					String s3 = s.substring(index2,s.length());
					String s2 = "wsag:Metric=\"metricXML";
					s = s1+s2+s3;
				}
				s += "\n";
				lines.add(s);
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			for (String l:lines){
				writer.write(l);
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class ExtensionFilter implements FilenameFilter{

		private String ext;
		
		public ExtensionFilter(String ext){
			this.ext = ext;
		}
		
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(ext);
		}
		
	}
	
	class DirectoryFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String name) {
			File f = new File(name);
			return f.isDirectory();
		}
		
	}

}

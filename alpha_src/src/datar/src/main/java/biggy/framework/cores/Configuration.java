package biggy.framework.cores;

import java.util.Map;
import java.util.HashMap;
import java.io.*;

/**
 * Engine Configuration
 *
 */
 class Configuration{
	 private Map<String, String> engineMap = new HashMap<String, String>();
	 
	 public Configuration(){};
	 
	 public Map getEngineConf(){
		 String fileName = "E:/BDMS/biggy/alpha_src/conf/engine.conf";
		 File confFile = new File(fileName);
		 BufferedReader br = null;
		 System.out.println("******Configuration Info******");
		 try{
			 br = new BufferedReader(new FileReader(confFile));
			 String line;
			 while((line = br.readLine())!=null){
				//System.out.println(line);
				String key = line.trim().replaceAll("\\[|\\]","").toLowerCase() + "Engine";
				line = br.readLine();
				String value = line.trim().replaceAll("moduleName = ","");
				br.readLine();
				br.readLine();
				System.out.println(key + ": " + value);
				engineMap.put(key, value);
			}
		 br.close();
		 System.out.println("******Configuration Info END******");
		 } catch (IOException e){
			 e.printStackTrace();
		 } finally {
			 if(br!=null){
				 try{
					 br.close();
				 } catch (IOException ee){
					 
				 }
			 }
		 }
		 
		 return engineMap;
	 }
 }
package biggy.framework.cores;

/**
 * Storage Engine
 *
 */
 public class StorageEngine implements Engine{
	 private String engineType = "StorageEngine";

	 @Override
	 public void start(){
		 System.out.println("Storage Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 @Override
	 public String getInfo(){
		 return getEngineType();
	 };
 }
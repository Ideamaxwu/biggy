package biggy.framework.cores;

/**
 * Storage Engine HBase
 *
 */
 public class StorageEngineHBase extends StorageWrapper{
	 private String engineName = "HBase";
	 
	 public StorageEngineHBase(Engine storageEngine){
		 super(storageEngine);
	 }
	 
	 @Override
	 public void start(){
		 storageEngine.start();
		 setStorageEngine(storageEngine);
	 }
	 
	 private void setStorageEngine(Engine storageEngine){
		 System.out.println("Add Storage Engine: HBase.");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 @Override
	 public String getInfo(){
		 return storageEngine.getInfo() + ", " + getEngineName();
	 }
 }
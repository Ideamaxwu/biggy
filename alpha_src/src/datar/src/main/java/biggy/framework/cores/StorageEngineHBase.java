package biggy.framework.cores;

/**
 * Storage Engine HBase
 *
 */
 public class StorageEngineHBase extends StorageWrapper{
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
 }
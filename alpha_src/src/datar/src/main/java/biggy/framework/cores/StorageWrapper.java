package biggy.framework.cores;

/**
 * Storage Wrapper
 *
 */
 public abstract class StorageWrapper implements Engine{
	 protected Engine storageEngine;
	 
	 public StorageWrapper(Engine storageEngine){
		 this.storageEngine = storageEngine;
	 }
	 
	 public void start(){
		 storageEngine.start();
	 }
 }
package biggy.framework.cores;

/**
 * InstanceObject
 *
 */
public class InstanceObject {
	
	private static  InstanceObject instance = new InstanceObject();
	private InstanceObject(){}
	public static InstanceObject getInstance(){
		return instance;
	}
	
	public void showMsg(){
		System.out.println("Single Instance Object Bigo Created.");
	}
	
	public void addEngine(Engine engine){
		engine.start();
	}
}
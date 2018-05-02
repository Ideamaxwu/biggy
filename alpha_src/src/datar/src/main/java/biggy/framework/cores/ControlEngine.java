package biggy.framework.cores;

/**
 * Control Engine
 *
 */
 public class ControlEngine implements Engine{
	 private String engineType = "ControlEngine";

	 @Override
	 public void start(){
		 System.out.println("Control Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 @Override
	 public String getInfo(){
		 return getEngineType();
	 };
 }
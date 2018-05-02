package biggy.framework.cores;

/**
 * Input Engine
 *
 */
 public class InputEngine implements Engine{
	 private String engineType = "InputEngine";

	 @Override
	 public void start(){
		 System.out.println("Input Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 @Override
	 public String getInfo(){
		 return getEngineType();
	 };
 }
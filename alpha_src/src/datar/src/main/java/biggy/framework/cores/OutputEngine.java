package biggy.framework.cores;

/**
 * Output Engine
 *
 */
 public class OutputEngine implements Engine{
	 private String engineType = "OutputEngine";

	 @Override
	 public void start(){
		 System.out.println("Output Engine Initializing.");
	 }
	 
	 public String getEngineType(){
		return engineType;
	 }
	 
	 @Override
	 public String getInfo(){
		 return getEngineType();
	 };
 }
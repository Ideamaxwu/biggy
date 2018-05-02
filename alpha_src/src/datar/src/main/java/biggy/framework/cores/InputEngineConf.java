package biggy.framework.cores;

/**
 * Input Engine Conf
 *
 */
 public class InputEngineConf extends InputWrapper{
	 private String engineName = "Default XXX";
	 
	 public InputEngineConf(Engine inputEngine, String confEngineName){
		 super(inputEngine);
		 if (confEngineName != null){
			engineName = confEngineName; 
		 }
	 }
	 
	 @Override
	 public void start(){
		 inputEngine.start();
		 setInputEngine();
	 }
	 
	 private void setInputEngine(){
		 System.out.println("Add Input Engine: " + engineName + ".");
	 }
	 
	 public String getEngineName(){
		return engineName;
	 }
	 
	 @Override
	 public String getInfo(){
		 return inputEngine.getInfo() + ": " + getEngineName();
	 }
 }
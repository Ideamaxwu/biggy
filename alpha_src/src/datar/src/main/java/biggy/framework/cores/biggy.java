package biggy.framework.cores;

/**
 * biggy
 *
 */
public class biggy 
{
    public static void main( String[] args )
    {
        InstanceObject bigo = InstanceObject.getInstance();
		bigo.showMsg();
		
		Engine storageEngineHBase = new StorageEngineHBase(new StorageEngine());
		//storageEngineHBase.start();
		bigo.addEngine(storageEngineHBase);
		
		Engine computationEngineSpark = new ComputationEngineSpark(new ComputationEngine());
		//computationEngineSpark.start();
		bigo.addEngine(computationEngineSpark);
    }
}

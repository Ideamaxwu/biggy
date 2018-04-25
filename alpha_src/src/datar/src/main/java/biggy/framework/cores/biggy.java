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
		//test instance duplicate
		InstanceObject bigoCopy = InstanceObject.getInstance();
		
		Engine storageEngineHBase = new StorageEngineHBase(new StorageEngine());
		//add Storage HBase
		bigo.addEngine(storageEngineHBase);
		
		Engine computationEngineSpark = new ComputationEngineSpark(new ComputationEngine());
		//add Computation Spark
		bigo.addEngine(computationEngineSpark);
		
		//show current engines
		bigo.showInfo();
    }
}

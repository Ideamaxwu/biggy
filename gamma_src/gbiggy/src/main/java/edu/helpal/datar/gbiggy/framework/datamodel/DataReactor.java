package edu.helpal.datar.gbiggy.framework.datamodel;

public class DataReactor {
	BigData bigdata;
	DataReactor(BigData bigdata, String type, String Operator){
		if (type.equals("Action")){
			this.bigdata = new BigData(bigdata.content);
			eventRegister(Operator);
			eventListen(Operator);
			eventProcess(Operator);	
		}
		if (type.equals("Transform")){
			this.bigdata = bigdata;
			eventRegister(Operator);
			eventListen(Operator);
			eventProcess(Operator);	
		}
	}
	
	void eventRegister(String Operator){
		System.out.println(Operator + " event registering...");
	}
	
	void eventListen(String Operator){
		System.out.println(Operator + " event listening...");
	}
	
	void eventProcess(String Operator){
		if(Operator.equals("upperCase")){
			this.bigdata.content = this.bigdata.content.toUpperCase();
		}
		if(Operator.equals("addData")){
			this.bigdata.content += " add this texts";
		}
		if(Operator.equals("Count")){
			new Action().Count();
		}
		if(Operator.equals("Sort")){
			new Transform().Sort();
		}
		System.out.println(Operator + " event processing...");
	}
	
	BigData eventReturn(String Operator){
		System.out.println(Operator + " event returned.");
		return this.bigdata;
	}
}

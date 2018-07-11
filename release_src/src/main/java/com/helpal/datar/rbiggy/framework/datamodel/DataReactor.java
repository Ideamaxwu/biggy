package com.helpal.datar.rbiggy.framework.datamodel;

/**
 * 
 * Data Reactor
 *
 */
public class DataReactor {
	BigData bigdata;
	DataReactor(BigData bigdata, String type, String Operator, String cls){
		if (type.equals("Action")){
			this.bigdata = new BigData(bigdata.info);
			this.bigdata.content = bigdata.content;
			bigdata.linage.add(this.bigdata);
			eventRegister(Operator);
			eventListen(Operator);
			eventProcess(Operator, cls);	
		}
		if (type.equals("Transform")){
			this.bigdata = bigdata;
			eventRegister(Operator);
			eventListen(Operator);
			eventProcess(Operator, cls);	
		}
	}
	
	void eventRegister(String Operator){
		System.out.println(Operator + " event registering...");
	}
	
	void eventListen(String Operator){
		System.out.println(Operator + " event listening...");
	}
	
	void eventProcess(String Operator, String cls){
		System.out.println(Operator + " event processing...");
		switch(Operator){
		
		//Action Operator
		case "addData":
			this.bigdata.info += " add this texts";
			break;
		case "Count":
			this.bigdata.content = new Action().Count(this.bigdata.content);
			break;
		case "WordCount":
			this.bigdata.content = new Action().WordCount(this.bigdata.content, cls);
			break;
		case "Cluster":
			this.bigdata.content = new Action().Cluster(this.bigdata.content, cls);
			break;
		case "PageRank":
			this.bigdata.content = new Action().PageRank(this.bigdata.content, cls);
			break;
		
		//Transform Operator
		case "upperCase":
			this.bigdata.info = this.bigdata.info.toUpperCase();
			break;
		case "Sort":
			this.bigdata.content = new Transform().Sort(this.bigdata.content, cls);
			break;
		case "Filter":
			this.bigdata.content = new Transform().Filter(this.bigdata.content, cls);
			break;
			
		default:
			System.err.println("NO such operator as " + Operator + "!");
			break;
		}
	}
	
	BigData eventReturn(String Operator){
		System.out.println(Operator + " event returned.");
		return this.bigdata;
	}
}

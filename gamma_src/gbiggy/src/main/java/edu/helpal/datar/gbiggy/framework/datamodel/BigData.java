package edu.helpal.datar.gbiggy.framework.datamodel;

public class BigData {
	private BigData bigdata;
	String content;
	
	public BigData(String data){
		content = data;
		bigdata = this;
	}
	
	public BigData Tansform(String transformOperator){
		System.out.println("BigData::Transform::" + transformOperator);
		bigdata = new DataReactor(this, "Transform", transformOperator).eventReturn(transformOperator);
		return bigdata;
	}
	
	public BigData Action(String actionOperator){
		System.out.println("BigData::Action::" + actionOperator);
		bigdata = new DataReactor(this, "Action", actionOperator).eventReturn(actionOperator);
		return bigdata;
	}
	
	public void Show(){
		System.out.println("BigData id@[" + bigdata + "], content: [" + bigdata.content + "].");
	}
	
}

package edu.helpal.datar.gbiggy.framework.datamodel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BigData {
	private BigData bigdata;
	String info;
	Map<Long, String> content;
	List<BigData> linage;
	
	public BigData(String data){
		info = data;
		bigdata = this;
		content = new HashMap<Long, String>();
		linage = new LinkedList<BigData>();
		linage.add(this);
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
		System.out.println("BigData .bigdata id@[" + bigdata + "], info: [" + bigdata.info + "], content: [" + bigdata.content + "], linage: [" + bigdata.linage + "].");
		System.out.println("BigData cls.self id@[" + this + "], info: [" + this.info + "], content: [" + this.content + "], linage: [" + this.linage + "].");
	}
	
	public BigData getBD(){
		return bigdata;
	}
	
}

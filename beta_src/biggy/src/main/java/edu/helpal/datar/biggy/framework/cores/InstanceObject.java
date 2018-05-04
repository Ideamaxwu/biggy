package edu.helpal.datar.biggy.framework.cores;

import java.util.List;
import java.util.ArrayList;

/**
 * InstanceObject
 *
 */
public class InstanceObject {
	
	private static InstanceObject instance = null;
	private List<Engine> engineList = new ArrayList<Engine>();
	private InstanceObject(){}
	
	public static InstanceObject getInstance(){
		if(instance == null){
			instance = new InstanceObject();
			System.out.println("-------Welcome to biggy-------");
			System.out.println("Single Instance Object Bigo Created.");
		}
		else{
			System.out.println("Instance Object Bigo Existed. DO NOT DUPLICATE!");
		}
		return instance;
	}
	
	public void addEngine(Engine engine){
		engine.start();
		engineList.add(engine);
	}
	
	public void showInfo(){
		System.out.println("-----Status Info-----");
		for(Engine engine : engineList){
			System.out.println(engine.getInfo());
		}
		System.out.println("-----Status Info END-----");
	}
}
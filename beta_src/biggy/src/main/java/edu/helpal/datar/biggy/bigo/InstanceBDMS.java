package edu.helpal.datar.biggy.bigo;

import java.util.List;

import edu.helpal.datar.biggy.framework.cores.Engine;

import java.util.ArrayList;

/**
 * InstanceObject
 *
 */
public class InstanceBDMS {
	
	private static InstanceBDMS instance = null;
	private List<Engine> engineList = new ArrayList<Engine>();
	private InstanceBDMS(){}
	
	public static InstanceBDMS getInstance(){
		if(instance == null){
			instance = new InstanceBDMS();
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
package edu.helpal.datar.gbiggy.bigo;

import java.util.List;

import edu.helpal.datar.gbiggy.framework.cores.IEngine;

import java.util.ArrayList;

/**
 * InstanceBDMS
 *
 */
public class InstanceBDMS {
	
	private static InstanceBDMS instance = null;
	private List<IEngine> engineList = new ArrayList<IEngine>();
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
	
	public void addEngine(IEngine engine){
		engine.start();
		engineList.add(engine);
	}
	
	public void showInfo(){
		System.out.println("-----biggy Status Info-----");
		for(IEngine engine : engineList){
			System.out.println(engine.getInfo());
		}
		System.out.println("-----biggy Status Info END-----");
	}
}
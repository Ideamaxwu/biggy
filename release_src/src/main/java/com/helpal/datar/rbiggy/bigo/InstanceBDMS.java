package com.helpal.datar.rbiggy.bigo;

import java.util.List;

import com.helpal.datar.rbiggy.framework.cores.IEngine;
import com.helpal.datar.rbiggy.framework.utils.BusKeeper;

import java.util.ArrayList;

/**
 * 
 * InstanceBDMS
 *
 */
public class InstanceBDMS {

	private static InstanceBDMS instance = null;
	private List<IEngine> engineList = new ArrayList<IEngine>();
	public BusKeeper bk = null;
	
	private InstanceBDMS() {
	}

	public static InstanceBDMS getInstance() {
		if (instance == null) {
			instance = new InstanceBDMS();
			System.out.println("Single Instance BDMS Bigo Created.");
		} else {
			System.out.println("Instance Object Bigo Existed. DO NOT DUPLICATE!");
		}
		return instance;
	}
	
	public void bundleContext(BusKeeper bk){
		this.bk = bk;
	}
	public void addEngine(IEngine engine) {
		engine.start();
		engineList.add(engine);
	}

	public void startServer() {
		new Server(this.bk).start();
	}

	public void showInfo() {
		System.out.println("-----biggy Status Info-----");
		for (IEngine engine : engineList) {
			System.out.println(engine.getInfo());
		}
		System.out.println("-----biggy Status Info END-----");
	}
}
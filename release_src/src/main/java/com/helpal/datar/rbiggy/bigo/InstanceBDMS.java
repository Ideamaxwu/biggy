package com.helpal.datar.rbiggy.bigo;

import java.util.List;

import com.helpal.datar.rbiggy.framework.cores.IEngine;
import com.helpal.datar.rbiggy.framework.utils.BusKeeper;
import com.helpal.datar.rbiggy.framework.utils.JetBrain;

import java.util.ArrayList;
import java.util.Date;

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
	//BusKeeper
	public void bundleContext(){
		System.out.println("\n->->->   start BusKeeper");
		BusKeeper bk = new BusKeeper();
		bk.start();
		bk.setContext("startTime", new Date().toString());
		this.bk = bk;
	}
	//JetBrain
	public void startIntelySys(){
		System.out.println("\n->->->   start JetBrain");
		JetBrain jb = new JetBrain();
		jb.start();
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
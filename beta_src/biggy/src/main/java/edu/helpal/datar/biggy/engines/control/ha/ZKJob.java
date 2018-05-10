package edu.helpal.datar.biggy.engines.control.ha;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZKJob {
	private static String connectString="192.168.1.100:2181";  
	private static int sessionTimeout=999999; 
	public void run() throws IOException, KeeperException, InterruptedException {
		System.out.println("/*******this is a ZKJob example******/");
		
		//TODO ZKJob
		System.out.println("Master: 127.0.0.1:8080; Standby: 127.0.0.3:8080.");
		
		Watcher watcher=new Watcher(){  
		public void process(WatchedEvent event) {  
		System.out.println("Listening Event: "+event);  
		}  
		};  
		final ZooKeeper zookeeper=new ZooKeeper(connectString,sessionTimeout,watcher);  
		System.out.println("Get connection: "+zookeeper);  
		final byte[] data=zookeeper.getData("/zk1", watcher, null);  
		System.out.println("Reading Data: "+new String(data));  
		zookeeper.close();  
		
		System.out.println("/*******this is the end of the ZKJob example******/");
	}

}

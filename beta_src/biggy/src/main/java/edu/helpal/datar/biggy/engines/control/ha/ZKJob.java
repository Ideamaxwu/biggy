package edu.helpal.datar.biggy.engines.control.ha;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;

/**
 * 
 * ZKJob start ZK instance then run the job
 * zkServer.cmd zkCli.cmd -sever:2181
 *
 */
public class ZKJob {
	ZooKeeper zookeeper;
	java.util.concurrent.CountDownLatch connectedSignal = new java.util.concurrent.CountDownLatch(1);
	String newnode = "/newznode";

	public void run() throws IOException, KeeperException, InterruptedException {
		System.out.println("/*******this is a ZKJob example******/");

		// TODO ZKJob
		System.out.println("Master: 127.0.0.1:8080; Standby: 127.0.0.3:8080.");
		connect("localhost");
		zookeeper = getZooKeeper();
		Stat stat = exist(newnode);
		if(stat != null){
			System.out.println("Node " + newnode + " exists and the node version is " + stat.getVersion());
		}
		else{
			System.out.println("Node " + newnode + " creating");
			zookeeper.create(newnode, "new znode".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		
		System.out.println("/*******this is the end of the ZKJob example******/");
	}

	public void connect(String host) throws IOException, InterruptedException {
		zookeeper = new ZooKeeper(host, 5000, new Watcher() {
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					connectedSignal.countDown();
				}
			}
		});
		connectedSignal.await();
	}

	public Stat exist(String path) throws KeeperException, InterruptedException{
		return zookeeper.exists(path, true);
	}
	public ZooKeeper getZooKeeper() {
		if (zookeeper == null || !zookeeper.getState().equals(States.CONNECTED)) {
			throw new IllegalStateException("ZooKeeper is not connected.");
		}
		return zookeeper;
	}
	
	public void close() throws InterruptedException {
		zookeeper.close();
	}

}

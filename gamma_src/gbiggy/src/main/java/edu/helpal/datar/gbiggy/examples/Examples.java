package edu.helpal.datar.gbiggy.examples;

import java.text.SimpleDateFormat;

/**
 * 
 * Four Examples: WordCount, Sort, KMeans, PageRank
 *
 */
public class Examples {
	public static void main(String[] args) {
		
		Runtime run = Runtime.getRuntime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");
		
		//example wordcount
		//egWordCount egWordCount = new egWordCount();
		//egWordCount.run();
		
		//example sort
		System.out.println("<TIME egSort start>: "+df.format(System.currentTimeMillis()));
		System.out.println("<Memory egSort> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		egSort egSort = new egSort();
		egSort.run();	
		System.out.println("<TIME egSort end>: "+df.format(System.currentTimeMillis()));
		System.out.println("<Memory> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		
		//example kmeans
		//egKMeans egKMeans = new egKMeans();
		//egKMeans.run();
		
		//example pagerank
		//egPageRank egPageRank = new egPageRank();
		//egPageRank.run();
	}

}

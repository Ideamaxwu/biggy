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
		System.out.println("<TIME egWordCount start>: "+df.format(System.currentTimeMillis()));
		System.out.println("<Memory egWordCount> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		egWordCount egWordCount = new egWordCount();
		egWordCount.run();
		System.out.println("<TIME egWordCount end>: "+df.format(System.currentTimeMillis()));
		System.out.println("<Memory egWordCount> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		
		//example sort
		//egSort egSort = new egSort();
		//egSort.run();	
		
		//example kmeans
		//egKMeans egKMeans = new egKMeans();
		//egKMeans.run();
		
		//example pagerank
		//egPageRank egPageRank = new egPageRank();
		//egPageRank.run();
	}

}

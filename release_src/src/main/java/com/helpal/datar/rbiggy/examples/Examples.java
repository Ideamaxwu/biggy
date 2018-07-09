package com.helpal.datar.rbiggy.examples;

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
		/*
		System.out.println("<TIME egWordCount start>: "+df.format(System.currentTimeMillis())+" @ "+System.currentTimeMillis());
		System.out.println("<Memory egWordCount> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		egWordCount egWordCount = new egWordCount();
		egWordCount.run();
		System.out.println("<TIME egWordCount end>: "+df.format(System.currentTimeMillis())+" @ "+System.currentTimeMillis());
		System.out.println("<Memory egWordCount> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		*/
		
		//example sort
		
		System.out.println("<TIME egSort start>: "+df.format(System.currentTimeMillis())+" @ "+System.currentTimeMillis());
		System.out.println("<Memory egSort> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		egSort egSort = new egSort();
		egSort.run();	
		System.out.println("<TIME egSort end>: "+df.format(System.currentTimeMillis())+" @ "+System.currentTimeMillis());
		System.out.println("<Memory egSort> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		
		
		//example kmeans
		
		System.out.println("<TIME egKMeans start>: "+df.format(System.currentTimeMillis())+" @ "+System.currentTimeMillis());
		System.out.println("<Memory egKMeans> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		egKMeans egKMeans = new egKMeans();
		egKMeans.run();
		System.out.println("<TIME egKMeans end>: "+df.format(System.currentTimeMillis())+" @ "+System.currentTimeMillis());
		System.out.println("<Memory egKMeans> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		
		
		//example pagerank
		/*
		System.out.println("<TIME egPageRank start>: "+df.format(System.currentTimeMillis())+" @ "+System.currentTimeMillis());
		System.out.println("<Memory egPageRank> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		egPageRank egPageRank = new egPageRank();
		egPageRank.run();
		System.out.println("<TIME egPageRank end>: "+df.format(System.currentTimeMillis())+" @ "+System.currentTimeMillis());
		System.out.println("<Memory egPageRank> total: " + run.totalMemory() + " free: " + run.freeMemory() + " used: " + (run.totalMemory()-run.freeMemory()) );
		*/
	}

}

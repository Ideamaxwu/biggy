package edu.helpal.datar.gbiggy.examples;

import java.text.SimpleDateFormat;

/**
 * 
 * Four Examples: WordCount, Sort, KMeans, PageRank
 *
 */
public class Examples {
	public static void main(String[] args) {
		
		//example wordcount
		//egWordCount egWordCount = new egWordCount();
		//egWordCount.run();
		
		//example sort
		System.out.println("<TIME egSort start>: "+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(System.currentTimeMillis()));
		egSort egSort = new egSort();
		egSort.run();	
		System.out.println("<TIME egSort end>: "+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(System.currentTimeMillis()));
		
		//example kmeans
		//egKMeans egKMeans = new egKMeans();
		//egKMeans.run();
		
		//example pagerank
		//egPageRank egPageRank = new egPageRank();
		//egPageRank.run();
	}

}

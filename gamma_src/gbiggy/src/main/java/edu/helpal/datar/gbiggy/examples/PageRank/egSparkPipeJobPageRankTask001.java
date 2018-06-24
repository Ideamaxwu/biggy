package edu.helpal.datar.gbiggy.examples.PageRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import com.google.common.collect.Iterables;

import scala.Tuple2;

public class egSparkPipeJobPageRankTask001 {
	private JavaSparkContext jsc;

	public Map<Long, String> run(Map<Long, String> content) {
		System.out.println("/***   Spark PageRank Task   ***/");

		Map<Long, String> result = new HashMap<Long, String>();

		// convert Map to List
		List<String> dataList = new ArrayList<String>();
		for (Entry<Long, String> entry : content.entrySet()) {
			dataList.add(entry.getValue());
		}

		// Spark working
		SparkConf conf = new SparkConf().setAppName("SparkJob").setMaster("local");
		jsc = new JavaSparkContext(conf);
		JavaRDD<String> data = jsc.parallelize(dataList);// convert List to RDD

		// Loads all URLs from input file and initialize their neighbors.
		JavaPairRDD<String, Iterable<String>> links = data.mapToPair(s -> {
			String[] parts = s.split(" ");
			return new Tuple2<>(parts[0], parts[1]);
		}).distinct().groupByKey().cache();

		// Loads all URLs with other URL(s) link to from input file and
		// initialize ranks of them to one.
		JavaPairRDD<String, Double> ranks = links.mapValues(rs -> 1.0);

		// Calculates and updates URL ranks continuously using PageRank
		// algorithm.
		int itr = 10;
		for (int current = 0; current < itr; current++) {
			// Calculates URL contributions to the rank of other URLs.
			JavaPairRDD<String, Double> contribs = links.join(ranks).values().flatMapToPair(s -> {
				int urlCount = Iterables.size(s._1());
				List<Tuple2<String, Double>> results = new ArrayList<>();
				for (String n : s._1) {
					results.add(new Tuple2<>(n, s._2() / urlCount));
				}
				return results.iterator();
			});

			// Re-calculates URL ranks based on neighbor contributions.
			ranks = contribs.reduceByKey((x, y) -> x + y).mapValues(sum -> 0.15 + sum * 0.85);
		}

		// Collects all URL ranks and dump them to console.
		List<Tuple2<String, Double>> output = ranks.collect();
		long id = 0;
		for (Tuple2<?, ?> tuple : output) {
			System.out.println(tuple._1() + " has rank: " + tuple._2() + ".");
			result.put(id, tuple._1() + ": " + tuple._2());
			id++;
		}

		jsc.stop();
		content = result;
		return content;
	}
}

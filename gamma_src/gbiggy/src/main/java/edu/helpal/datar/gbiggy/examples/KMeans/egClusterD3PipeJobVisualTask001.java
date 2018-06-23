package edu.helpal.datar.gbiggy.examples.KMeans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class egClusterD3PipeJobVisualTask001 {

	public void generate(Map<Long, String> content, String path) {

		File dataFile = new File(path);
		BufferedWriter bw = null;
		try {
			if (!dataFile.exists()) {
				dataFile.createNewFile();
			}
			bw = new BufferedWriter(new FileWriter(dataFile));
			// write header
			bw.write("{\"name\": \"kmeans\",\"children\": [");
			bw.newLine();
			// write body
			int outlen = content.size();
			int i = 0;
			for (Entry<Long, String> entry : content.entrySet()) {
				System.out.println("Generate Visual Data: " + entry.getValue());
				bw.write("{\"name\": \"cluster" + entry.getKey() + "\",\"children\": [");
				bw.newLine();
				String[] points = entry.getValue().split(" ");
				int inlen = points.length;
				int j = 0;
				for (String p : points) {
					j++;
					if (j == inlen) {
						bw.write("{\"name\": \"" + p + "\", \"size\": 5000}");
					} else {
						bw.write("{\"name\": \"" + p + "\", \"size\": 5000},");
					}
					bw.newLine();
				}
				i++;
				if (i == outlen) {
					bw.write("]}");
				} else {
					bw.write("]},");
				}
				bw.newLine();
			}
			// write footer
			bw.write("]}");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ee) {

				}
			}
		}
	}
}

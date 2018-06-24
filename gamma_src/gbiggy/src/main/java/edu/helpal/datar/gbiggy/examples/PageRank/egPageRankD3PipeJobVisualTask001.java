package edu.helpal.datar.gbiggy.examples.PageRank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class egPageRankD3PipeJobVisualTask001 {

	public void generate(Map<Long, String> content, String path) {

		File dataFile = new File(path);
		BufferedWriter bw = null;
		try {
			if (!dataFile.exists()) {
				dataFile.createNewFile();
			}
			bw = new BufferedWriter(new FileWriter(dataFile));
			//write header
			bw.write("var data = [");
			bw.newLine();
			//write body
			for (Entry<Long, String> entry : content.entrySet()) {
				System.out.println("Generate Visual Data: " + entry.getValue());
				//{Page: "A", score: 1.299},
				String[] item = entry.getValue().split(": ");
				String line = "{Page: \"" + item[0] +"\", score: " + item[1] + "},";
				bw.write(line);
				bw.newLine();
			}
			//write footer
			bw.write("];");
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

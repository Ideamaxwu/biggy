package edu.helpal.datar.gbiggy.examples.Exps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerate {
	public static void main(String[] agrs) {
		System.out.println("Data Generator for Experiments.");

		DG dg = new DG();

		dg.WordCountG();

		//dg.SortG();

		//dg.KMeansG();

		//dg.PageRankG();

	}
}

class DG {
	void WordCountG() {
		System.out.println("Generating WordCount data ...");

		String srcfile = "src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\Exps\\data\\MarkTwain.txt";
		String dstfile = "src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\Exps\\data\\WordCountData100K.txt";
		File srcFile = new File(srcfile);
		File dstFile = new File(dstfile);

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			// dstFile exist
			if (!dstFile.exists()) {
				dstFile.createNewFile();
			}

			br = new BufferedReader(new FileReader(srcFile));
			bw = new BufferedWriter(new FileWriter(dstFile));

			String line;
			
			int cnt = 0;
			int mnt = 100000;
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				String trimmedLine = line.trim();
				if (trimmedLine != ""){
					String[] items = trimmedLine.split("\\s+");
					for (String item:items){
						bw.write(item);
						bw.newLine();
						cnt+=1;
						if (cnt>mnt){
							break;
						}
					}
				}
				if (cnt>mnt){
					break;
				}
			}

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ee) {

				}
			}
		}

	}

	void SortG() {
		System.out.println("Generating Sort data ...");
		System.out.println("Similar as WordCount data.");
	}

	void KMeansG() {
		System.out.println("Generating KMeans data ...");
		
		String dstfile = "src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\Exps\\data\\KMeans1M.txt";
		File dstFile = new File(dstfile);
		BufferedWriter bw = null;

		try {
			// dstFile exist
			if (!dstFile.exists()) {
				dstFile.createNewFile();
			}

			bw = new BufferedWriter(new FileWriter(dstFile));

			String points;
			int cnt = 0;
			int mnt = 1000000;
			Random rand = new Random();
			while (cnt<mnt) {
				int x = rand.nextInt(mnt/100);
				int y = rand.nextInt(mnt/100);
				points = x + "," + y;
				bw.write(points);
				bw.newLine();
				cnt+=1;
			}

			bw.close();
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

	void PageRankG() {
		System.out.println("Generating PageRank data ...");
		
		String dstfile = "src\\main\\java\\edu\\helpal\\datar\\gbiggy\\examples\\Exps\\data\\PageRank1M.txt";
		File dstFile = new File(dstfile);
		BufferedWriter bw = null;

		try {
			// dstFile exist
			if (!dstFile.exists()) {
				dstFile.createNewFile();
			}

			bw = new BufferedWriter(new FileWriter(dstFile));

			String points;
			int cnt = 0;
			int mnt = 1000000;
			Random rand = new Random();
			while (cnt<mnt) {
				int x = rand.nextInt(mnt/1000);
				int y = rand.nextInt(mnt/1000);
				points = x + " " + y;
				bw.write(points);
				bw.newLine();
				cnt+=1;
			}

			bw.close();
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

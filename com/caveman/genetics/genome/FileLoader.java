package com.caveman.genetics.genome;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import cpw.mods.fml.common.Loader;

public class FileLoader {
	public static boolean writeJSONFile(GeneRegistry.Kingdom kingdom, String contents, String fileName) {
		boolean result = true;
		BufferedWriter writer = null;
		try {
			File output = new File(Loader.instance().getConfigDir()+ "/Genomecraft/" + kingdom.name() + "/" +  fileName + ".json");
			output.getParentFile().mkdirs();
			System.out.println("Writing to: " + output.getCanonicalPath());
			writer = new BufferedWriter(new FileWriter(output));
			writer.write(contents.toString());
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public static String readJSONFile(GeneRegistry.Kingdom kingdom, String fileName) {
		String content = "";
		Scanner input = null;
		try {
			input = new Scanner(new File(Loader.instance().getConfigDir()
					+ "/Genomecraft/" + kingdom.name() + "/" + fileName + ".json"));
			content = input.useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			content = null;
		} finally {
			try {
				input.close();
			} catch (Exception e) {
			}
		}
		return content;
	}
}

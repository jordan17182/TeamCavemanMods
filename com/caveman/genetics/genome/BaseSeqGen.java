package com.caveman.genetics.genome;

import java.util.Random;

public class BaseSeqGen {
	private Random baseGenerator = new Random(22);
	//-10 to 10
		public String getNextBase(float dominance) {
			float[] weights = createWeights(dominance);
			String base = "";
			for(int i = 0; i < 6; i++) {
				int basePart = generateBase(weights);
				base += getBaseChar(basePart);
			}
			return base;
		}
		
		private String getBaseChar(int num) {
			String baseChar = "";
			switch(num) {
				case 0: baseChar = "A"; break;
				case 1: baseChar = "T"; break;
				case 2: baseChar = "C"; break;
				default: baseChar = "G"; break;
			}
			
			return baseChar;
		}
		
		private float[] createWeights(float dominance) {
			float[] tempWeights = new float[4];
			float m = dominance * .01f;
			float sum = 0;
			for(int i = 0; i < tempWeights.length; i++) {
				float tempWeight = m*((i+1)-2)+.25f;
				tempWeights[i] = tempWeight;
				sum += tempWeight;
			}
			
			for(int j = 0; j < tempWeights.length; j++) {
				tempWeights[j] = tempWeights[j]/sum;
			}
			
			return tempWeights;
		}
		
		private int generateBase(float[] weights) {
			float sum = 0;
			float num = baseGenerator.nextFloat();
			for(int i = 0; i < weights.length; i++) {
				sum += weights[i];
				if(num <= sum) return i;
			}
			return 0;
		}
		
		public int getBaseValue(String base) {
			int value = 0;
			for(int i = 0; i < base.length(); i++) {
				char subBase = base.charAt(i);
				switch(subBase) {
					case 'A': value += 1; break;
					case 'T': value += 2; break;
					case 'C': value += 3; break;
					default: value += 4; break;
				}
			}
			return value;
		}
}

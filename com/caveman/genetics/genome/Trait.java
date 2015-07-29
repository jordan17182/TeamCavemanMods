package com.caveman.genetics.genome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Trait {
	private String id; //Id of the trait, used only in code
	private String displayName; //Display name of the trait
	private Map<String, String> geneList; //geneID, gene display name
	private Map<String, String> itemsReqGene; //Items with their required gene
	private Map<String, List<String>> possibleBases; //Possible bases for the genes
	private Map<String, String> baseMap; //A map of all base to gene connections
	
	
	public Trait(String id, String displayName) {
		this(id, displayName, new HashMap<String, String>(), new HashMap<String, String>(), new HashMap<String, List<String>>(), new HashMap<String, String>());
	}
	
	public Trait(String id, String displayName, HashMap<String, String> geneList, Map<String, String> itemsReqGene, Map<String, List<String>> possibleBases, Map<String, String> baseMap) {
		this.id = id;
		this.displayName = displayName;
		this.geneList = geneList;
		this.itemsReqGene = itemsReqGene;
		this.possibleBases = possibleBases;
		this.baseMap = baseMap;
	}
	
	/****************
	 * addGene
	 * @param geneID The id of the gene
	 * @param numBases How many bases will be generated for the gene
	 * @param maxDominance
	 * @param minDominance
	 * @param weighting
	 */
	public void addGene(String geneID, float prevalence, float dominance) {
		if(!checkGeneExists(geneID)) {
			geneList.put("",geneID);
			possibleBases.put(geneID, generateBases(geneID, prevalence, dominance));
		} else {
			System.out.println("Genomecraft: Someone tried registering an exsisting gene with the id of: " + geneID + ". It either was registered by"
					+ " something else or was loaded from previous registrations.");
		}
	}
	
	public String getID() {
		return id;
	}
	
	private List<String> generateBases(String geneID, float prevalence, float dominance){
		
		return null;
	}
	
	private boolean checkGeneExists(String geneID) {
		return geneList.containsKey(geneID);
	}
	
	@Override
	public String toString() {
		String contents = "Trait " + displayName + " description:\n"
				+ "    ID: " + id + "\n"
				+ "    Display Name: " + displayName + "\n"
				+ "    Gene List: \n    " + geneList.toString() + "\n"
				+ "    Items Required Genes: \n    " + itemsReqGene.toString() + "\n"
				+ "    Genes Possible Bases: \n    " + possibleBases.toString();
			
		return contents;
	}
}

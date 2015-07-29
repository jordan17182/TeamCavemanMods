package com.caveman.genetics.genome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

class BagOfPrimitives {
	  private ArrayList<String> geneList = new ArrayList<>();
	  private Map<String, List<String>> possibleBases = new HashMap<>();
	  private int value1 = 1;
	  private String value2 = "abc";
	  private transient int value3 = 3;
	  BagOfPrimitives() {
		  geneList.add("Test");
		  ArrayList<String> little = new ArrayList<>();
		  little.add("base01");
		  possibleBases.put("Test", little);
	    // no-args constructor
	  }
	}

	
public class TraitParser {

	
	//JSONParser parser = new JSONParser();
	Gson parser = new Gson();
	private String plantTraitsLocation = "plantTraits";
	private String fungiTraitsLocation = "fungiTraits";
	private String animalTraitsLocation = "animalTraits";
	
	public Trait parseTrait(GeneRegistry.Kingdom kingdom, String id, String dispName) {
		Trait newTrait;
		String jsonTrait = FileLoader.readJSONFile(kingdom, id);
		if(jsonTrait == null) {
			newTrait = new Trait(id, dispName);
			saveTrait(kingdom, newTrait);
		} else {
			newTrait = parser.fromJson(jsonTrait, Trait.class);
		}
		return newTrait;
	}
	
	private void saveTrait(GeneRegistry.Kingdom kingdom, Trait trait) {
		String json = parser.toJson(trait);
		FileLoader.writeJSONFile(kingdom, json, trait.getID());
	}
	/*
	public ArrayList<Trait> loadTraits(String fileName) {
		BagOfPrimitives obj = new BagOfPrimitives();
		Gson gson = new Gson();
		String json = gson.toJson(obj);  
		System.out.println(json);
		
		String input = FileLoader.readJSONFile(fileName);
		//System.out.println(input);
		JSONObject traitFile = parseTraitFile(input);
		
		System.out.println(traitFile);
		ArrayList<Trait> loadedTraits = new ArrayList<>();
		Iterator iter = traitFile.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			loadedTraits.add(decodeTrait(entry));
		}	
		return loadedTraits;
	}
	
	private JSONObject parseTraitFile(String rawJSON) {
		Object jsonObj = JSONValue.parse(rawJSON);
		JSONObject parsedFile = (JSONObject) jsonObj;
		return parsedFile;
	}
	
	private Trait decodeTrait (Map.Entry trait) {
		JSONObject traitObj = (JSONObject) trait.getValue();

		String id = getTraitID(traitObj);
		String displayName = getTraitDisplayName(traitObj);
		ArrayList<String> geneList = getTraitGenes(traitObj);
		Map<String, String> itemsReqGene = getReqGenes(traitObj); 
		Map<String, List<String>> possibleBases = getPossibleBases(traitObj);
		
		Map<String, String> baseMap = new HashMap<>();
		
		return new Trait(id, displayName, geneList, itemsReqGene, possibleBases, baseMap);
	}
	
	private String getTraitID(JSONObject trait) {
		return trait.get("id").toString();
	}
	
	private String getTraitDisplayName(JSONObject trait) {
		return trait.get("displayName").toString();
	}
	
	private ArrayList<String> getTraitGenes(JSONObject trait) {
		JSONObject genes = (JSONObject) trait.get("genes");
		ArrayList<String> geneList = new ArrayList<>();
		Iterator geneIter = genes.entrySet().iterator();
	
		while(geneIter.hasNext()) {
			Map.Entry gene = (Map.Entry)geneIter.next();
			geneList.add(gene.getKey().toString());
		}
		return geneList;
	}
	
	private Map<String, String> getReqGenes(JSONObject trait) {
		Map<String, String> reqGenes = new HashMap<>(); //Create map to put items with their required gene into
		
		JSONObject genes = (JSONObject) trait.get("genes"); //Get map of genes
		
		Iterator geneIter = genes.entrySet().iterator(); //Create iterator for going through genes
	
		while(geneIter.hasNext()) {
			Map.Entry geneEntry = (Map.Entry)geneIter.next();
			JSONObject geneObj = (JSONObject) geneEntry.getValue();
			JSONArray items = (JSONArray) geneObj.get("items");
			Iterator itemIter = items.iterator();
			
			while(itemIter.hasNext()) {
				reqGenes.put(itemIter.next().toString(), geneObj.get("id").toString());
			}
		}
		
		return reqGenes;
	}
	
	private Map<String, List<String>> getPossibleBases(JSONObject trait) {
		Map<String, List<String>> possibleBases = new HashMap<>();
		
		JSONObject genes = (JSONObject) trait.get("genes"); //Get map of genes
		
		Iterator geneIter = genes.entrySet().iterator(); //Create iterator for going through genes
	
		while(geneIter.hasNext()) {
			Map.Entry geneEntry = (Map.Entry)geneIter.next();
			JSONObject geneObj = (JSONObject) geneEntry.getValue();
			JSONArray bases = (JSONArray) geneObj.get("bases");
			Iterator baseIter = bases.iterator();
			
			List<String> baseList = new ArrayList<>();
			
			while(baseIter.hasNext()) {
				baseList.add(baseIter.next().toString());
			}
			possibleBases.put(geneObj.get("id").toString(), baseList);

		}
		
		return possibleBases;
	}
	*/
}

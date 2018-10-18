package com.alef.techtest.oyster.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.alef.techtest.oyster.entity.Itinerary;
import com.alef.techtest.oyster.entity.TripInfo;
import com.alef.techtest.oyster.rules.TripRuleEngine;



public class ControllerUtilities {
	
	private Map<Integer, Itinerary> itineraryMap = getTripItinerary();
	public TripRuleEngine tripRuleEngine = new TripRuleEngine();
	
	public Map<Integer,Itinerary> getTripItinerary() {
		
		Map<Integer, Itinerary> itineraryMap = new LinkedHashMap<Integer,Itinerary>();
		
		itineraryMap.put(1, new Itinerary("Holborn", "1", "IN"));
		itineraryMap.put(2, new Itinerary("Holborn", "1", "OUT"));
		itineraryMap.put(3, new Itinerary("Earl\'s Court", "1,2", "IN"));
		itineraryMap.put(4, new Itinerary("Earl\'s Court", "1,2", "OUT"));
		itineraryMap.put(5, new Itinerary("Wimbledon", "3", "IN"));
		itineraryMap.put(6, new Itinerary("Wimbledon", "3", "OUT"));
		itineraryMap.put(7, new Itinerary("Hammersmith", "2", "IN"));
		itineraryMap.put(8, new Itinerary("Hammersmith", "2", "OUT"));
		
		return itineraryMap;
	}

	public TripInfo getSourceDestinationForTravel(Scanner scanner) {
		int source = 0;
		int destination = 0;
		TripInfo info = new TripInfo();		
		int totalLocationOptions=itineraryMap.size();
		
        
		
		while(true) {
			createSourceDestinationMessage("SOURCE", "");
			
		try{
			source = scanner.nextInt();
			}catch(Exception ex){
				System.out.println("Invalid option. Please choose any from 1-" + totalLocationOptions + "\n");
				scanner.next();
				continue;
			}
			if (tripRuleEngine.isValidSource(source,totalLocationOptions)) {
				break;
			}
		}
		if(source==0){
			info.setSources(new ArrayList<Integer>());
		}else{
			info.setSources(itineraryMap.get(source).getZones());
		}
		
		 System.out.println("You are starting your tube travel from "+itineraryMap.get(source).getName()+"\n");
		
        //Fix the destination
		 while(true) {
			createSourceDestinationMessage("DESTINATION", "[0] EXIT without swiping card.");

			try{
				destination = scanner.nextInt();
				}catch(Exception ex){
					System.out.println("Invalid option. Please choose any from 0-" + totalLocationOptions + "\n");
					scanner.next();
					continue;
				}
			
			if (tripRuleEngine.isValidDestination(destination,totalLocationOptions)) {
				break;
			}
		}
		
		
		
		if(destination!=0) {			
			info.setDestinations(itineraryMap.get(destination).getZones());
			System.out.println("You have finished travel from "+itineraryMap.get(source).getName()+" to "+itineraryMap.get(destination).getName()+" by Tube.\n");
		}
		return info;
	}
	
	private void createSourceDestinationMessage(String direction, String exit) {
		StringBuffer journey = new StringBuffer();
		for (Integer eachKey : itineraryMap.keySet()) {
			Itinerary itinerary = itineraryMap.get(eachKey);
			journey.append("[" + eachKey + "] ").append(itinerary.getName()).append(" ").append(itinerary.getDirecton()).append("\n");
			
		}
		System.out.println("Please enter " + direction + "\n" + journey.toString() + exit);

	}
}

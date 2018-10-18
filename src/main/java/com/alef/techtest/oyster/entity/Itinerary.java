package com.alef.techtest.oyster.entity;

import java.util.ArrayList;
import java.util.List;

public class Itinerary {

	private String name;
	 private List<Integer> zones;
	 private String directon;
	 
	 
	 public Itinerary(String name,String zones,String direction) {
		setName(name);
		setZones(zones);
		setDirecton(direction);
	}
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getZones() {
		return zones;
	}
	public void setZones(String zones) {
		String[] array=zones.split(",");
		this.zones=new ArrayList<Integer>();
		for(String eachZone:array){
			this.zones.add(Integer.parseInt(eachZone));
		}
		
	}

	public String getDirecton() {
		return directon;
	}

	public void setDirecton(String directon) {
		this.directon = directon;
	}

}

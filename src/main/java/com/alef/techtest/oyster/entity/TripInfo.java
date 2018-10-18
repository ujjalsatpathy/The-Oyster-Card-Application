package com.alef.techtest.oyster.entity;

import java.util.List;

public class TripInfo {

	private List<Integer> sourceZones;
	private List<Integer> destinationZones;
	
	public List<Integer> getSources() {
		return sourceZones;
	}
	public void setSources(List<Integer> sources) {
		this.sourceZones = sources;
	}
	public List<Integer> getDestinations() {
		return destinationZones;
	}
	public void setDestinations(List<Integer> destinations) {
		this.destinationZones = destinations;
	}
}

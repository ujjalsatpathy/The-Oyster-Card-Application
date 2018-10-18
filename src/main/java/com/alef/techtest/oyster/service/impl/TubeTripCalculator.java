package com.alef.techtest.oyster.service.impl;

import java.util.List;

import com.alef.techtest.oyster.entity.TripInfo;
import com.alef.techtest.oyster.rules.TripConstants;
import com.alef.techtest.oyster.service.TripCalculatorService;

public class TubeTripCalculator implements TripCalculatorService {

	private TripInfo info;
	
	public void setTravelInfo(TripInfo info) {
		this.info=info;		
		}

	public double calculateTripCost() throws NullPointerException {
		
	try{
		if(info.getSources().isEmpty()){
			System.out.println("You have entered without swiping, hence you are charged maximum fare of "+TripConstants.ANY_THREE_ZONES_OR_MAX_FARE+" pounds");
			return TripConstants.ANY_THREE_ZONES_OR_MAX_FARE;
		}
		
		if(info.getDestinations().isEmpty()){
			System.out.println("You have exited without swiping, hence you are charged maximum fare of "+TripConstants.ANY_THREE_ZONES_OR_MAX_FARE+" pounds");
			return TripConstants.ANY_THREE_ZONES_OR_MAX_FARE;
		}
	} catch(Exception e) {
			return TripConstants.ANY_THREE_ZONES_OR_MAX_FARE;
		}
		
		return fareCalculator(info.getSources(), info.getDestinations());
	}
	
	private double fareCalculator(List<Integer> sourceZones, List<Integer> destinationZones) {
		double minimumFare = Double.MAX_VALUE;
		
		for (Integer sourceZone : sourceZones) {
			
			for (Integer destinationZone : destinationZones) {
				int calculatedZone =  Math.abs(sourceZone - destinationZone) + 1;
				boolean isZoneOneInTrip = (sourceZone == 1 || destinationZone == 1);
				double calculatedFare = getFare(calculatedZone, isZoneOneInTrip);
				minimumFare = Math.min(minimumFare, calculatedFare);
			}
		}
		return minimumFare;
	}
	
	private double getFare(int noOfZones, boolean isZoneOneInTrip) {
		double fare;
		if (noOfZones == 1 && isZoneOneInTrip) {
			fare = TripConstants.ANYWHERE_IN_ZONE_1;
		} else if (noOfZones == 1 && !isZoneOneInTrip) {
			fare = TripConstants.ANY_ONE_ZONE_OUTSIDE_ZONE_1;
		} else if (noOfZones == 2 && isZoneOneInTrip) {
			fare = TripConstants.ANY_TWO_ZONES_INCLUDING_ZONE_1;
		} else if (noOfZones == 2 && !isZoneOneInTrip) {
			fare = TripConstants.ANY_TWO_ZONES_EXCLUDING_ZONE_1;
		} else {
			fare = TripConstants.ANY_THREE_ZONES_OR_MAX_FARE;
		}
		return fare;
	}
}

package com.alef.techtest.oyster.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.alef.techtest.oyster.entity.TripInfo;
import com.alef.techtest.oyster.service.TripCalculatorService;
import com.alef.techtest.oyster.service.impl.TubeTripCalculator;

public class TubeTripCalculatorTest {

	private TripInfo info;
	private TripCalculatorService tripService;
	
	@Before
	public void setup() {
		info=new TripInfo();		
	}
	

	@Test
	public void testCalculateCostWithoutSwappingOut() {
		List<Integer> sources=new ArrayList<Integer>();
		sources.add(1);
		List<Integer> destinations=new ArrayList<Integer>();
		info.setSources(sources);
		info.setDestinations(destinations);
		tripService=new TubeTripCalculator();
		tripService.setTravelInfo(info);
		Assert.assertTrue(tripService.calculateTripCost() == 3.2D);
	}
	
	@Test
	public void testCalculateCostForAnyWhereInZoneOne() {
		List<Integer> sources=new ArrayList<Integer>();
		sources.add(1);
		List<Integer> destinations=new ArrayList<Integer>();
		destinations.add(1);
		info.setSources(sources);
		info.setDestinations(destinations);
		tripService=new TubeTripCalculator();
		tripService.setTravelInfo(info);
		Assert.assertTrue(tripService.calculateTripCost() == 2.50D);
	}
	
	@Test
	public void testCalculateCostForAnyOneZoneOutsideZoneOne() {
		List<Integer> sources=new ArrayList<Integer>();
		sources.add(2);
		List<Integer> destinations=new ArrayList<Integer>();
		destinations.add(2);
		info.setSources(sources);
		info.setDestinations(destinations);
		tripService=new TubeTripCalculator();
		tripService.setTravelInfo(info);
		Assert.assertTrue(tripService.calculateTripCost() == 2.00D);
	}
	
	@Test
	public void testCalculateCostForAnyTwoZonesIncludingZoneOne() {
		List<Integer> sources=new ArrayList<Integer>();
		sources.add(1);
		List<Integer> destinations=new ArrayList<Integer>();
		destinations.add(2);
		info.setSources(sources);
		info.setDestinations(destinations);
		tripService=new TubeTripCalculator();
		tripService.setTravelInfo(info);
		Assert.assertTrue(tripService.calculateTripCost() == 3.00D);
	}
	
	@Test
	public void testCalculateCostForAnyTwoZonesExcludingZoneOne() {
		List<Integer> sources=new ArrayList<Integer>();
		sources.add(3);
		List<Integer> destinations=new ArrayList<Integer>();
		destinations.add(2);
		info.setSources(sources);
		info.setDestinations(destinations);
		tripService=new TubeTripCalculator();
		tripService.setTravelInfo(info);
		Assert.assertTrue(tripService.calculateTripCost() == 2.25D);
	}
	
	
	@Test
	public void testCalculateCostOfAnyThreeZones() {
		List<Integer> sources=new ArrayList<Integer>();
		sources.add(1);
		List<Integer> destinations=new ArrayList<Integer>();
		destinations.add(4);
		info.setSources(sources);
		info.setDestinations(destinations);
		tripService=new TubeTripCalculator();
		tripService.setTravelInfo(info);
		Assert.assertTrue(tripService.calculateTripCost() == 3.2D);
	}
	
	@Test
	public void testCalculateCostZoneOneToZoneThree() {
		List<Integer> sources=new ArrayList<Integer>();
		sources.add(1);
		sources.add(2);
		List<Integer> destinations=new ArrayList<Integer>();
		destinations.add(3);
		info.setSources(sources);
		info.setDestinations(destinations);
		tripService=new TubeTripCalculator();
		tripService.setTravelInfo(info);
		Assert.assertTrue(tripService.calculateTripCost() == 2.25D);
	}	
}

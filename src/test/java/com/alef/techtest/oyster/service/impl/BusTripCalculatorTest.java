package com.alef.techtest.oyster.service.impl;

import org.junit.Assert;
import org.junit.Test;

import com.alef.techtest.oyster.service.TripCalculatorService;
import com.alef.techtest.oyster.service.impl.BusTripCalculator;

public class BusTripCalculatorTest {

	private TripCalculatorService tripService;
	
	@Test
	public void testCalculateCostForAnyBusJourney() {
		tripService=new BusTripCalculator();
		Assert.assertTrue(tripService.calculateTripCost() == 1.80D);
	}
	
}

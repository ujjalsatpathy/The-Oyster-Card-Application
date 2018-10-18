package com.alef.techtest.oyster.service.impl;

import com.alef.techtest.oyster.entity.TripInfo;
import com.alef.techtest.oyster.service.*;

public class BusTripCalculator implements TripCalculatorService {

	public void setTravelInfo(TripInfo info) {		
		//nothing to do
	}

	public double calculateTripCost() {		
		return 1.8D;
	}
 }

package com.alef.techtest.oyster.service;

import com.alef.techtest.oyster.entity.TripInfo;

public interface TripCalculatorService {
	
	  void setTravelInfo(TripInfo info);
	  double calculateTripCost();
}

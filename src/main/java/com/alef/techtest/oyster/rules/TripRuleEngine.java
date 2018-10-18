package com.alef.techtest.oyster.rules;

public class TripRuleEngine {
	
	public boolean isSufficientBalance(Double balance) {
		if (balance < TripConstants.MIN_BALANCE) {
			System.out.println("You dont have sufficient balance to make a trip.\n");
			return false;
		}
		return true;
	}
	
	public boolean isSufficientBalanceForTubeTrip(int tripCategory, Double balance) {
		if (tripCategory == TripConstants.TUBE_TRIP && balance < TripConstants.MAX_BALANCE) {
			System.out.println("You dont have sufficient balance to make a Tube trip.\n");
			return false;
		}
		return true;
	}
	
	public boolean isValidDestination(int destination, int totalSize) {
		if (destination < 0 || destination > totalSize) {
			System.out.println("Invalid option. Please choose any from 0-" + totalSize + "\n");
			return false;
		}

		if (destination % 2 != 0) {
			System.out.println("You are already Inside.Please choose a option with OUT.\n");
			return false;
		}
		    return true;
	}

	public boolean isValidSource(int source, int totalSize) {
		if (source < 1 || source > totalSize) {
			System.out.println("Invalid option. Please choose any from 1-" + totalSize + "\n");
			return false;
		}

		if (source % 2 == 0) {
			System.out.println("You are not Inside any Station, hence cannot go out. Please choose a option with IN.\n");
			return false;
		}
		    return true;
	}
}

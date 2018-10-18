package com.alef.techtest.oyster.api;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.alef.techtest.oyster.entity.TripInfo;
import com.alef.techtest.oyster.rules.TripConstants;
import com.alef.techtest.oyster.rules.TripRuleEngine;
import com.alef.techtest.oyster.service.TripCalculatorService;
import com.alef.techtest.oyster.service.impl.BusTripCalculator;
import com.alef.techtest.oyster.service.impl.TubeTripCalculator;


public class OysterController extends ControllerUtilities {	

	private static OysterController oysterController;
	private TripRuleEngine tripRuleEngine = super.tripRuleEngine;
	TripCalculatorService tripCalculator = null;
	
	public static OysterController getInstance() {
		if (oysterController == null) {
			oysterController = new OysterController();
		}
		return oysterController;
	}
	
	public void execute() {

		Scanner scanner = new Scanner(System.in);
		double balance = 0D;
		DecimalFormat df = new DecimalFormat("0.00");

		System.out.println("Please enter amount for your oyster card:");
		while (true) {

			try {
				balance = scanner.nextDouble();
				if (balance <= 0D) {
					System.out.println("Invalid amount , please insert correct amount:\n");
					continue;
				}
				break;
			} catch (Exception e) {
				scanner.next();
			}
			System.out.println("Invalid amount , please insert correct amount:\n");
		}		
		
		System.out.println("Great!Your initial card balance is " + balance + "\n\n");
		
		
		while (true) {
			System.out.println("Please choose your trip type: 1.BusTrip 2.Tube Trip 3.Exit\n");
			int tripCategory;

			try {
				tripCategory = scanner.nextInt();
			} catch (Exception ex) {
				System.out.println("Wrong selection.Please select a valid one.\n");
				scanner.next();
				continue;
			}
			if (tripCategory < TripConstants.BUS_TRIP || tripCategory > TripConstants.EXIT_TRIP) {
				System.out.println("Invalid option.Please select valid option\n");
				continue;
			}

			if (tripCategory == TripConstants.EXIT_TRIP) {
				break;
			}
			
			if (!tripRuleEngine.isSufficientBalance(balance)){
            	break;
            }
			
			if (tripCategory==TripConstants.BUS_TRIP) {
				System.out.println("£1.80 has been debited from your card for bus trip.");
				tripCalculator = new BusTripCalculator();	    		  
			}
			
			if (!tripRuleEngine.isSufficientBalanceForTubeTrip(tripCategory,balance)) {
            	continue;
            }
             
			if (tripCategory==TripConstants.TUBE_TRIP) {
				TripInfo tripInfo = getSourceDestinationForTravel(scanner);
				tripCalculator = new TubeTripCalculator();
				tripCalculator.setTravelInfo(tripInfo);				
			}
          
			double tripCost = tripCalculator.calculateTripCost(); 		
			
			
			balance=balance-tripCost;    	   
			System.out.println("You are left with £"+df.format(balance)+" after this trip.\n");

		}
		
		System.out.println("Thanks for your Bus/Tube travel. Your card balance is £"+df.format(balance)+".");
		scanner.close();
	}
}

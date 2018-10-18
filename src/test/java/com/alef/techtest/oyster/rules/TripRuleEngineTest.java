package com.alef.techtest.oyster.rules;

import org.junit.Assert;
import org.junit.Test;

public class TripRuleEngineTest {

	TripRuleEngine tripRuleEngine = new TripRuleEngine();
	
	@Test
	public void testIsSufficientBalanceNegative() {
		double balance = 1.5D;
		Assert.assertFalse(tripRuleEngine.isSufficientBalance(balance) == true);
	}
	
	@Test
	public void testIsSufficientBalancePositive() {
		double balance = 1.8D;
		Assert.assertTrue(tripRuleEngine.isSufficientBalance(balance) == true);
	}
	
	@Test
	public void  testIsSufficientBalanceForTubeTrip() {
		int tripCategory = 2;
		double balance = 3.2D;
		Assert.assertTrue(tripRuleEngine.isSufficientBalanceForTubeTrip(tripCategory, balance) == true);
	}
	
	@Test
	public void testIsValidDestination() {
		int dest = 2;
		Assert.assertTrue(tripRuleEngine.isValidDestination(dest, 2) == true);
	}
	
	@Test
	public void testIsValidSource() {
		int src = 3;
		Assert.assertTrue(tripRuleEngine.isValidSource(src, 5) == true);
	}
}

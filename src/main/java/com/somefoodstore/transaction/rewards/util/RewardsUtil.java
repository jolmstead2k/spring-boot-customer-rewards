package com.somefoodstore.transaction.rewards.util;

public class RewardsUtil {
	
	public static Double calculatePoints(Double purchaseAmount) {
 		Double points = 0.0;
		
		if (purchaseAmount <= 50.0)
 			points = 0.0;
 		if (purchaseAmount > 50.0 && purchaseAmount <=100.0)
		    points =  purchaseAmount - 50;
 		if (purchaseAmount > 100.0)
 			points = 50.0 + 2*(purchaseAmount - 100);
 		return points;
 	}

}

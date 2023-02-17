package com.somefoodstore.transaction.rewards.response;

import java.time.LocalDate;

import com.somefoodstore.transaction.rewards.model.Purchase;

import lombok.Data;

@Data
public class AggregateRewards {
	
	private Double aggregatePoints;
	private Double aggregatePointsByMonth1;
	private Double aggregatePointsByMonth2;
	private Double aggregatePointsByMonth3;

}

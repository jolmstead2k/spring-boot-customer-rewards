package com.somefoodstore.transaction.rewards.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;


import lombok.Data;

@Data
@Entity(name = "purchase")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Purchase {
	
	 	@Id
	    @GeneratedValue
	    private Long id;
	 	
	 	private Long customerId;
	 	
	 	private Long transactionId;
	 	
	 	private LocalDate transactionDate;
	 	
	 	private Double purchaseAmount;

	 	private Double rewardPoints;
	 	
	 	

}

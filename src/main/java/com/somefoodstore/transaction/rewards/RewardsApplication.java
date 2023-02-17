package com.somefoodstore.transaction.rewards;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.somefoodstore.transaction.rewards.model.Purchase;
import com.somefoodstore.transaction.rewards.repository.PurchaseRepository;
import com.somefoodstore.transaction.rewards.util.RewardsUtil;

@SpringBootApplication
public class RewardsApplication {
	
	@Autowired
	private PurchaseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	}
	
	@PostConstruct
	public void seedData() {
		
		Purchase purchase = null ;
		
		purchase = new Purchase();
		purchase.setCustomerId(001L);
		purchase.setPurchaseAmount(120.00);
		purchase.setTransactionDate(LocalDate.of(2022, 11, 01));
		purchase.setTransactionId(001L);
		purchase.setRewardPoints(RewardsUtil.calculatePoints(purchase.getPurchaseAmount()));
		
		repository.save(purchase);
		
		purchase = new Purchase();
		purchase.setCustomerId(001L);
		purchase.setPurchaseAmount(200.00);
		purchase.setTransactionDate(LocalDate.of(2022, 11, 15));
		purchase.setTransactionId(002L);
		purchase.setRewardPoints(RewardsUtil.calculatePoints(purchase.getPurchaseAmount()));
		
		repository.save(purchase);
		
		purchase = new Purchase();
		purchase.setCustomerId(001L);
		purchase.setPurchaseAmount(150.00);
		purchase.setTransactionDate(LocalDate.of(2022, 12, 01));
		purchase.setTransactionId(003L);
		purchase.setRewardPoints(RewardsUtil.calculatePoints(purchase.getPurchaseAmount()));
		
		repository.save(purchase);
		
		purchase = new Purchase();
		purchase.setCustomerId(001L);
		purchase.setPurchaseAmount(150.00);
		purchase.setTransactionDate(LocalDate.of(2022, 12, 15));
		purchase.setTransactionId(004L);
		purchase.setRewardPoints(RewardsUtil.calculatePoints(purchase.getPurchaseAmount()));
		
		repository.save(purchase);
		
		purchase = new Purchase();
		purchase.setCustomerId(001L);
		purchase.setPurchaseAmount(75.00);
		purchase.setTransactionDate(LocalDate.of(2023, 01, 01));
		purchase.setTransactionId(005L);
		purchase.setRewardPoints(RewardsUtil.calculatePoints(purchase.getPurchaseAmount()));
		
		repository.save(purchase);
		
		purchase = new Purchase();
		purchase.setCustomerId(001L);
		purchase.setPurchaseAmount(75.00);
		purchase.setTransactionDate(LocalDate.of(2023, 01, 15));
		purchase.setTransactionId(006L);
		purchase.setRewardPoints(RewardsUtil.calculatePoints(purchase.getPurchaseAmount()));
		
		repository.save(purchase);
		

		
		
	}

}

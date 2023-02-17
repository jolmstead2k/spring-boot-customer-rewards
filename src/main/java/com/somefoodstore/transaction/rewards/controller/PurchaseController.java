package com.somefoodstore.transaction.rewards.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.somefoodstore.transaction.rewards.model.Purchase;
import com.somefoodstore.transaction.rewards.response.AggregateRewards;
import com.somefoodstore.transaction.rewards.service.PurchaseService;



@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {
	
	 @Autowired
	    private PurchaseService service;
	
	@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Purchase>> getPurchases() {
        return new ResponseEntity<List<Purchase>>(service.findAllPurchases(), HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/{id}")
    public ResponseEntity<AggregateRewards> getPurchasesByCustomerId(@PathVariable Long id) {
		
		LocalDate now = LocalDate.now();
		
		int month3 = now.minusMonths(1).getMonthValue();
		int month2 = now.minusMonths(2).getMonthValue();
		int month1 = now.minusMonths(3).getMonthValue();
		
		int currentMonth = now.getMonthValue();
		

		
		List<Purchase> purchasesByCustomer = service.findAllByCustomerId(id);
		Double aggregatePoints = 0.0;
		Double aggregatePointsByMonth1 = 0.0;
		Double aggregatePointsByMonth2 = 0.0;
		Double aggregatePointsByMonth3 = 0.0;
		for (Purchase p : purchasesByCustomer) {
			aggregatePoints = aggregatePoints + p.getRewardPoints();
			if (p.getTransactionDate().getMonthValue() == month3) {
				aggregatePointsByMonth3 = aggregatePointsByMonth3 +p.getRewardPoints();
			}
			if (p.getTransactionDate().getMonthValue() == month2) {
				aggregatePointsByMonth2 = aggregatePointsByMonth2 +p.getRewardPoints();
			}
			if (p.getTransactionDate().getMonthValue() == month1) {
				aggregatePointsByMonth1 = aggregatePointsByMonth1 +p.getRewardPoints();
			}
		}
		
		AggregateRewards rewards = new AggregateRewards();
		
		rewards.setAggregatePoints(aggregatePoints);
		rewards.setAggregatePointsByMonth1(aggregatePointsByMonth1);
		rewards.setAggregatePointsByMonth2(aggregatePointsByMonth2);
		rewards.setAggregatePointsByMonth3(aggregatePointsByMonth3);
		
		return new ResponseEntity<AggregateRewards>(rewards, HttpStatus.OK);
    }
	
//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Purchase>> getSinglePurchase(@PathVariable Long id){
//        return new ResponseEntity<Optional<Purchase>>(service.findPurchaseById(id), HttpStatus.OK);
//    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public List<Purchase> addPurchases(
    		@RequestBody List<Purchase> purchases)  throws Exception{
    	List<Purchase> savedPurchases = service.saveAll(purchases);
    	return savedPurchases;
    	
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping Purchase updatePurchase(@RequestBody Purchase Purchase) throws Exception{
    	Purchase modifiedPurchase = service.updatePurchase(Purchase);
    	
    	return Purchase;
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping Purchase deletePurchase(@PathVariable Long id) throws Exception{
    	Optional<Purchase> toBeDeleted = service.findPurchaseById(id);
    	service.deletePurchase(toBeDeleted.get());
    	return toBeDeleted.get();
    }

}

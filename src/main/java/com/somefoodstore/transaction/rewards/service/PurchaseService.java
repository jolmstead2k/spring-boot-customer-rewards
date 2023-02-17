package com.somefoodstore.transaction.rewards.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somefoodstore.transaction.rewards.model.Purchase;
import com.somefoodstore.transaction.rewards.repository.PurchaseRepository;

@Service
public class PurchaseService {
	
	@Autowired
    private PurchaseRepository repository;

    public List<Purchase> findAllPurchases() {
        return repository.findAll();
    }
    public List<Purchase> findAllByCustomerId(Long id) {
        return repository.findAllByCustomerId(id);
    }
    public Optional<Purchase> findPurchaseById(Long id) {
        return repository.findById(id);
    }
    
    public List<Purchase> saveAll(List<Purchase> Purchases) {
    	return repository.saveAll(Purchases);
    }
	public Purchase updatePurchase(Purchase Purchase) {		
		return repository.save(Purchase);
	}
	
	public void deletePurchase(Purchase Purchase) {		
		repository.delete(Purchase);
	}

}

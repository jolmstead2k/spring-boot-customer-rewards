package com.somefoodstore.transaction.rewards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somefoodstore.transaction.rewards.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	public List<Purchase>findAllByCustomerId(Long id);
}

package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

}

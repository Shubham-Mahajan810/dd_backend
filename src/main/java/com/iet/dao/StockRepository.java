package com.iet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iet.pojos.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{

}

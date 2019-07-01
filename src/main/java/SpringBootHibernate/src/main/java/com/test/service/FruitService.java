package com.binbin.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.binbin.bean.Fruit;

public interface FruitService {

	public abstract List<Fruit> getByFruitName(String name);

	public abstract Fruit getByPrice(int price);
	
	public abstract Fruit getByPriceAndName(int price, String name);

	public abstract List<Fruit> getAll();
	
	public abstract Fruit getById(Long id);
	
	public abstract void add(Fruit fruit);
	
	public abstract void update(Fruit fruit);
	
	public abstract void deleteById(Long id);
	
	public abstract Page<Fruit> GetPageRecords(int pageIndex, int pageSize);
	
	public abstract Page<Fruit> getPageRecordsByBuytime(int pageIndex, int pageSize);
	
}
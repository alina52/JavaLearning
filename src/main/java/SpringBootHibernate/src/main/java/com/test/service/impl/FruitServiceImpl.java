package com.binbin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.binbin.bean.Fruit;
import com.binbin.repository.FruitRepository;
import com.binbin.service.FruitService;

@Service
public class FruitServiceImpl implements FruitService {
	
	@Autowired private FruitRepository fruitRepository;

	@Override
	public List<Fruit> getAll() {
		
		return fruitRepository.findAll();
	}

	@Override
	public Fruit getById(Long id) {
		
		Optional<Fruit> fruits = fruitRepository.findById(id);
		if(fruits.isPresent()) {
			return fruits.get();
		}else {
			return null;
		}
	}

	@Override
	public void add(Fruit fruit) {
		
		fruitRepository.save(fruit);
	}

	@Override
	public void update(Fruit fruit) {
		fruitRepository.save(fruit);
	}

	@Override
	public void deleteById(Long id) {
		fruitRepository.deleteById(id);
	}

	@Override
	public Page<Fruit> GetPageRecords(int pageIndex, int pageSize) {
		
		return fruitRepository.findAll(new PageRequest(pageIndex, pageSize));
	}

	@Override
	public Page<Fruit> getPageRecordsByBuytime(int pageIndex, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC, "buyTime");
		return fruitRepository.findAll(new PageRequest(pageIndex, pageSize, sort));
	}


	@Override
	public List<Fruit> getByFruitName(String name) {
		
		List<Fruit> fruitList = fruitRepository.getByfruitName(name);
		return fruitList;
	}
	
	@Override
	public Fruit getByPrice(int price) {
		Fruit fruit = fruitRepository.getByPrice(price);
		return fruit;
	}

	@Override
	public Fruit getByPriceAndName(int price, String name) {
		return fruitRepository.getByPN(price, name);
	}

    

}

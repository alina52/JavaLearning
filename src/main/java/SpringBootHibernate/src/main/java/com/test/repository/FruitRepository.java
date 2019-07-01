package com.binbin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.binbin.bean.Fruit;


public interface FruitRepository extends JpaRepository<Fruit, Long> {//CrudRepository

	@Query("select f from Fruit f where f.fruitName=:name")
	public List<Fruit> getByfruitName(@Param("name") String name);
	
	@Query("select f from Fruit f where f.price=:price")
	public Fruit getByPrice(@Param("price") int price);
	
	@Query("select f from Fruit f where f.price=:price and fruitName=:name")
	public Fruit getByPN(@Param("price") int price, @Param("name") String name);
}

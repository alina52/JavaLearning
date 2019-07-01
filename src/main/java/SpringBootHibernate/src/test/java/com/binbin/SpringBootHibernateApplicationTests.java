package com.binbin;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.binbin.bean.Fruit;
import com.binbin.service.FruitService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHibernateApplicationTests {

	@Autowired private FruitService fruitService;
	
	@Test
	public void getAll() {
		
		List<Fruit> fruitList = fruitService.getAll();
		for(Fruit f : fruitList) {
			System.out.println(f.toString());
		}
	}
	
	@Test
	public void add() {
		
		for(int i=0; i<50; i++) {
			
			Fruit fruit = new Fruit();
			fruit.setBuyTime(new Date(System.currentTimeMillis() + i * 2000));
			fruit.setDescription("描述"+i);
			fruit.setFruitName("名称"+i);
			fruit.setPrice(50+i);
			fruitService.add(fruit);
		}
		
	}

	@Test
	public void getById() {
		Fruit f = fruitService.getById(Long.valueOf(80));
		if(f == null) {
			System.out.println("不存在.....");
		}else {
			System.out.println(f.toString());
		}
	}
	
	@Test
	public void update() {
		Fruit f = fruitService.getById(Long.valueOf(80));
		if(f != null) {
			System.out.println(f.toString());
			f.setFruitName("名字更新了");
			fruitService.update(f);
		}
	}
	
	@Test
	public void deleteById() {
		fruitService.deleteById(Long.valueOf(41));
	}
	
	@Test
	public void getPage() {
		Page<Fruit> fruitList = fruitService.GetPageRecords(0, 6);
		for(Fruit f : fruitList) {
			System.out.println(f.toString());
		}
	}
	
	@Test
	public void getPageByTime() {
		Page<Fruit> fruitList = fruitService.getPageRecordsByBuytime(0, 8);
		for(Fruit f : fruitList) {
			System.out.println(f.toString());
		}
	}
	
	@Test
	public void getByNameList() {
		List<Fruit> fruitList = fruitService.getByFruitName("名称0");
		for(Fruit f : fruitList) {
			System.out.println(f.toString());
		}
	}
	
	@Test
	public void getByPrice() {
		Fruit f = fruitService.getByPrice(66);
		System.out.println(f.toString());
	}
	
    @Test
    public void getByPN() {
    	Fruit f = fruitService.getByPriceAndName(66, "名称1");
    	if(f == null) {
    		System.out.println("数据不存在....");
    	}else {
    		System.out.println(f.toString());
    	}
    }
}

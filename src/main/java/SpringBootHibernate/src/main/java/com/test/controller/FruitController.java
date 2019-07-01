package com.binbin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binbin.bean.Fruit;
import com.binbin.service.FruitService;

@RestController
@RequestMapping("/fruit")
public class FruitController {

	
	@Autowired private FruitService fruitService;
	
	@RequestMapping("/getAll")
	public List<Fruit> getAll(){
		return fruitService.getAll();
	}
	
	@RequestMapping("/getPage")
	public Page<Fruit> getPage(HttpServletRequest request){
		
		try {
			String pageIndex = request.getParameter("pageIndex");
			String pageSize = request.getParameter("pageSize");
			return fruitService.GetPageRecords(Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}

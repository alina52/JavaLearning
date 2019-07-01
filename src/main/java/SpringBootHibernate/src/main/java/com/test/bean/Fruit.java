package com.binbin.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="fruit")
public class Fruit {

    private long id;
    private String fruitName;
    private int price;
    private Date buyTime;
    private String description;
    
	public Fruit() {}

	public Fruit(long id, String fruitName, int price, Date buyTime, String description) {
		this.id = id;
		this.fruitName = fruitName;
		this.price = price;
		this.buyTime = buyTime;
		this.description = description;
	}
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="fruitName", nullable=true)
	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	@Column(length = 2147483647) //LongText最大2147483647字节; MedumnText最大16777215字节;Text是有65535字节限制
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + id + ", fruitName=" + fruitName + ", price=" + price + ", buyTime=" + buyTime
				+ ", description=" + description + "]";
	}
	
}

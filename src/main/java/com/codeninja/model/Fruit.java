package com.codeninja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="fruit")
public class Fruit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer fruitId;
	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String fruitName;
	
	public Integer getFruitId() {
		return fruitId;
	}

	public Fruit(String fruitName) {
		super();
		this.fruitName = fruitName;
	}

	public String getFruitName() {
		return fruitName;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + fruitId + ", name=" + fruitName + "]";
	}

}

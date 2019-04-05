package com.codeninja.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codeninja.model.Fruit;
import com.codeninja.repository.FruitRepository;

@RestController
public class RestProvider {
	
	@Autowired
	private FruitRepository fruitRepository;
	
	@RequestMapping(value="/fruits", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Fruit> getFruits () {
		
		//fruitRepository.save(new Fruit("Apple"));
		List<Fruit> fruits = (List<Fruit>) fruitRepository.findAll();
		return fruits;
		/*
		String returnString = "";
		for (Fruit f: fruits) {
			returnString = returnString + "Fruit # " + fruits.indexOf(f)+1 + ": " + f.toString() + "\n";
		}
		return returnString;
		*/
	}
	
	@RequestMapping(value="/fruits/{name}", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public Fruit createFruit( @PathVariable(value="name") String name) {
		Fruit f = new Fruit(name);
		fruitRepository.save(f);
		return f;
	}
	
	@RequestMapping(value="/fruits/{name}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Fruit deleteFruit( @PathVariable(value="name") String name) {
		Fruit f = fruitRepository.findFirstByFruitName(name);
		fruitRepository.delete(f);
		return f;
	}
	
	@RequestMapping(value="/fruits", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String updateFruit( @RequestBody Fruit f) {
		fruitRepository.save(f);
		return "Success: Fruit with ID: " + f.getFruitId() + " updated.";
	}

}

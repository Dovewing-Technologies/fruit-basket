package com.codeninja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeninja.model.Fruit;

@Repository
public interface FruitRepository extends CrudRepository<Fruit, String> {
  
		public Fruit findFirstByFruitName(String name);
}

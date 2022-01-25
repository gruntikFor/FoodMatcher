package com.gruntik.foodmatcher.repository;

import com.gruntik.foodmatcher.entity.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {
}

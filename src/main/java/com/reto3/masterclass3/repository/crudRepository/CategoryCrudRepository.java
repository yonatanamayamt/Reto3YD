package com.reto3.masterclass3.repository.crudRepository;

import com.reto3.masterclass3.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}

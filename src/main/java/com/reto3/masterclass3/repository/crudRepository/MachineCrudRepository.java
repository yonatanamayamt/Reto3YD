package com.reto3.masterclass3.repository.crudRepository;

import com.reto3.masterclass3.entities.Machine;
import org.springframework.data.repository.CrudRepository;

public interface MachineCrudRepository extends CrudRepository<Machine, Integer> {
}

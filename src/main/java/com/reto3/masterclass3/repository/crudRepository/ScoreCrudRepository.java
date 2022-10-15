package com.reto3.masterclass3.repository.crudRepository;

import com.reto3.masterclass3.entities.Reservation;
import com.reto3.masterclass3.entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
}

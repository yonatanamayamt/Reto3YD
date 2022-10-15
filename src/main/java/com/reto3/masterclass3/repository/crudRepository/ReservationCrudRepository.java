package com.reto3.masterclass3.repository.crudRepository;

import com.reto3.masterclass3.entities.Client;
import com.reto3.masterclass3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}

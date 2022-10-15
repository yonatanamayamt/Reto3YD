package com.reto3.masterclass3.repository.crudRepository;

import com.reto3.masterclass3.entities.Message;
import com.reto3.masterclass3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}

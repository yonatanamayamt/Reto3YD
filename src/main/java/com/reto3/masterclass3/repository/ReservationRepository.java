package com.reto3.masterclass3.repository;

import com.reto3.masterclass3.entities.Reservation;
import com.reto3.masterclass3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository ReservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) ReservationCrudRepository.findAll();
    }
    public Optional<Reservation> getById(int id){
        return ReservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation c){
        return ReservationCrudRepository.save(c);
    }
    public void delete(Reservation c){
        ReservationCrudRepository.delete(c);
    }
}

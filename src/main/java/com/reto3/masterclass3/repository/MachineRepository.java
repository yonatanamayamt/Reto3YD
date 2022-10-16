package com.reto3.masterclass3.repository;

import com.reto3.masterclass3.entities.Machine;
import com.reto3.masterclass3.repository.crudRepository.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MachineRepository {
    @Autowired
    private MachineCrudRepository clientCrudRepository;

    public List<Machine> getAll(){
        return (List<Machine>) clientCrudRepository.findAll();
    }
    public Optional<Machine> getById(int id){
        return clientCrudRepository.findById(id);
    }
    public Machine save(Machine c){
        return clientCrudRepository.save(c);
    }
    public void delete(Machine c){
        clientCrudRepository.delete(c);
    }
}

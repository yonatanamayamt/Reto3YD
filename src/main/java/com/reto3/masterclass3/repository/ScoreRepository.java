package com.reto3.masterclass3.repository;


import com.reto3.masterclass3.entities.Score;
import com.reto3.masterclass3.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository clientCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) clientCrudRepository.findAll();
    }
    public Optional<Score> getById(int id){
        return clientCrudRepository.findById(id);
    }
    public Score save(Score c){
        return clientCrudRepository.save(c);
    }
    public void delete(Score c){
        clientCrudRepository.delete(c);
    }
}

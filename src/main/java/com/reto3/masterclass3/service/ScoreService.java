package com.reto3.masterclass3.service;

import com.reto3.masterclass3.entities.Score;
import com.reto3.masterclass3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score>getById(int id){
        return scoreRepository.getById(id);
    }
    public Score save(Score c){
        if(c.getIdScore()==null){
            return scoreRepository.save(c);
        }
        return c;
    }
    public boolean delete(int id){
        Optional<Score> cOp= scoreRepository.getById(id);
        if(cOp.isPresent()){
            scoreRepository.delete(cOp.get());
            return true;
        }
        return false;
    }
    public Score update(Score c){
        if(c.getIdScore()!=null){
            Optional<Score> old= scoreRepository.getById(c.getIdScore());
            if(old.isPresent()){
                Score k=old.get();
                if(c.getIdScore()!=null){
                    k.setIdScore(c.getIdScore());
                }
                if(c.getScore()!=null){
                    k.setScore(c.getScore());
                }

                return scoreRepository.save(k);
            }
        }
        return c;
    }
}

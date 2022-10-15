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

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score p) {
        if (p.getIdScore() == null) {
            return scoreRepository.save(p);
        } else {
            Optional<Score> e = scoreRepository.getScore(p.getIdScore());
            if(e.isPresent()){
                return p;
            }else{
                return scoreRepository.save(p);
            }
        }

    }
    public Score update(Score p){
        if (p.getIdScore()!=null){
            Optional<Score> e = scoreRepository.getScore(p.getIdScore());
            if(e.isPresent()){
                if (p.getScore()!= null){
                    e.get().setScore(p.getScore());
                }
                scoreRepository.save(e.get());
                return e.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }


    public boolean delete(int id){
        boolean flag=false;
        Optional<Score>p= scoreRepository.getScore(id);
        if(p.isPresent()){
            scoreRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}

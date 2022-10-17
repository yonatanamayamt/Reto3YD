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
    public Optional<Score> getScore (int id) {
        return scoreRepository.getScore(id);
    }

    public Score save (Score score){
        if (score.getIdScore()==null){
            return scoreRepository.save(score);
        } else {
            Optional<Score> e = scoreRepository.getScore(score.getIdScore());
            if (!e.isPresent()){
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update (Score score){
        if (score.getIdScore() != null){
            Optional<Score> e = scoreRepository.getScore(score.getIdScore());
            if (!e.isPresent()){
                if (score.getMessageText() != null){
                    e.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null){
                    e.get().setStars(score.getStars());
                }
                scoreRepository.save(e.get());
                return e.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public boolean delete (int id){
        Boolean r = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return r;
    }
}

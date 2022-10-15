package com.reto3.masterclass3.controller;

import com.reto3.masterclass3.entities.Category;
import com.reto3.masterclass3.entities.Score;
import com.reto3.masterclass3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Score> getById(@PathVariable("id") int id) {
        return scoreService.getScore(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score p){
        return scoreService.save(p);
}
}

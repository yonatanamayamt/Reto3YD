package com.reto3.masterclass3.controller;

import com.reto3.masterclass3.entities.Score;
import com.reto3.masterclass3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }
@PostMapping("/save")
    public Score save(@RequestBody Score p){
        return scoreService.save(p);
}
}

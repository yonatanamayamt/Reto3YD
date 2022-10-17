package com.reto3.masterclass3.controller;

import com.reto3.masterclass3.entities.Category;
import com.reto3.masterclass3.entities.Machine;
import com.reto3.masterclass3.entities.Score;
import com.reto3.masterclass3.service.MachineService;
import com.reto3.masterclass3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @GetMapping("/all")
    public List<Score> getAll(){ return scoreService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Score> getScore (@PathVariable("id") int id){ return scoreService.getScore(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save (@RequestBody Score score){ return scoreService.save(score); }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Score update (@RequestBody Score score){ return scoreService.update(score); }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id") int carId){ return scoreService.delete(carId); }
}

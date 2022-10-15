package com.reto3.masterclass3.controller;

import com.reto3.masterclass3.entities.Category;
import com.reto3.masterclass3.entities.Machine;
import com.reto3.masterclass3.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Machine")
public class MachineController {
    @Autowired
    private MachineService machineService;
    @GetMapping("/all")
    public List<Machine> getAll(){
        return machineService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Machine> getById(@PathVariable("id") int id) {
        return machineService.getMachine(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine p){
        return machineService.save(p);
}
}

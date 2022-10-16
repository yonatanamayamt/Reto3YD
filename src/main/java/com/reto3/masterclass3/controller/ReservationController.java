package com.reto3.masterclass3.controller;


import com.reto3.masterclass3.entities.Reservation;
import com.reto3.masterclass3.entities.dto.StatusAccount;
import com.reto3.masterclass3.entities.dto.TopClients;
import com.reto3.masterclass3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService resevationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return resevationService.getAll();
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation c){
        return resevationService.save(c);
    }

    @GetMapping("/report-dates/{dateA}/{dateB}")
    public List<Reservation> getByDates(@PathVariable("dateA")String da, @PathVariable("dateB")String db ){
        return resevationService.getReservationsByPeriod(da,db);
    }
    @GetMapping("/report-status")
    public StatusAccount getByStatus(){
        return resevationService.getReportByStatus();
    }
    @GetMapping("/report-clients")
    public List<TopClients> getTopClients(){
        return resevationService.getTopclients();
    }





}

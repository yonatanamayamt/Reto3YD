package com.reto3.masterclass3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdScore;
    private Integer score;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;


    public Integer getIdScore() {
        return IdScore;
    }

    public void setIdScore(Integer idScore) {
        IdScore = idScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

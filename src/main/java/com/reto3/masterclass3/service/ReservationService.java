package com.reto3.masterclass3.service;
import com.reto3.masterclass3.entities.Client;
import com.reto3.masterclass3.entities.Reservation;
import com.reto3.masterclass3.entities.dto.StatusAccount;
import com.reto3.masterclass3.entities.dto.TopClients;
import com.reto3.masterclass3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Reservation save(Reservation r){
        return reservationRepository.save(r);
    }

    public List<Reservation> getReservationsByPeriod(String dateA,String dateB){

        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a=parser.parse(dateA);
            b=parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();;
        }
        if(a.before(b)){
            return reservationRepository.getDatesReport(a,b);
        }else{
            return new ArrayList<Reservation>();
        }
    }
    public StatusAccount getReportByStatus(){
        List<Reservation> completes=reservationRepository.getStatusReport("completed");
        List<Reservation> cancelled=reservationRepository.getStatusReport("cancelled");

        StatusAccount resultado=new StatusAccount(completes.size(),cancelled.size());
        return resultado;

    }
    public List<TopClients> getTopclients(){
        List<TopClients> tc=new ArrayList<>();
        List<Object[]> result= reservationRepository.getTopClients();

        for(int i=0;i<result.size();i++){
            int total=Integer.parseInt(result.get(i)[1].toString());
            Client client= (Client) result.get(i)[0];
            TopClients topClient=new TopClients(total,client);
            tc.add(topClient);
        }
        return tc;
    }

}

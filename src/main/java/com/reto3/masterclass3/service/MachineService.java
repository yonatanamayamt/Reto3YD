package com.reto3.masterclass3.service;

import com.reto3.masterclass3.entities.Category;
import com.reto3.masterclass3.entities.Machine;
import com.reto3.masterclass3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id) {
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine p) {
        if (p.getId() == null) {
            return machineRepository.save(p);
        } else {
            Optional<Machine> e = machineRepository.getMachine(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return machineRepository.save(p);
            }
        }

    }
    public Machine update(Machine p) {
        if (p.getId()!=null){
            Optional<Machine> q= machineRepository.getMachine(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getBrand()!=null){
                    q.get().setBrand(p.getBrand());
                }
                if(p.getYear()!=null){
                    q.get().setYear(p.getYear());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }

                machineRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Machine>p= machineRepository.getMachine(id);
        if(p.isPresent()){
            machineRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}

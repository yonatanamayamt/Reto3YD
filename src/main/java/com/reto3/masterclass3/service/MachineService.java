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

    public Optional<Machine>getById(int id){
        return machineRepository.getById(id);
    }

    public Machine save(Machine c){
        if(c.getId()==null){
            return machineRepository.save(c);
        }
        return c;
    }
    public boolean delete(int id){
        Optional<Machine> cOp= machineRepository.getById(id);
        if(cOp.isPresent()){
            machineRepository.delete(cOp.get());
            return true;
        }
        return false;
    }
    public Machine update(Machine c){
        if(c.getId()!=null){
            Optional<Machine> old= machineRepository.getById(c.getId());
            if(old.isPresent()){
                Machine k=old.get();
                if(c.getName()!=null){
                    k.setName(c.getName());
                }
                if(c.getId()!=null){
                    k.setId(c.getId());
                }
                if(c.getName()!=null){
                    k.setName(c.getName());
                }
                if(c.getBrand()!=null){
                    k.setBrand(c.getBrand());
                }
                if(c.getYear()!=null){
                    k.setYear(c.getYear());
                }
                if(c.getDescription()!=null){
                    k.setDescription(c.getDescription());
                }


                return machineRepository.save(k);
            }
        }
        return c;
    }

}

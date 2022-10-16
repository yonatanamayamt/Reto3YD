package com.reto3.masterclass3.repository;

import com.reto3.masterclass3.entities.Message;
import com.reto3.masterclass3.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository clientCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) clientCrudRepository.findAll();
    }
    public Optional<Message> getById(int id){
        return clientCrudRepository.findById(id);
    }
    public Message save(Message c){
        return clientCrudRepository.save(c);
    }
    public void delete(Message c){
        clientCrudRepository.delete(c);
    }
}

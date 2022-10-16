package com.reto3.masterclass3.service;

import com.reto3.masterclass3.entities.Message;
import com.reto3.masterclass3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message>getById(int id){
        return messageRepository.getById(id);
    }

    public Message save(Message c){
        if(c.getIdMessage()==null){
            return messageRepository.save(c);
        }
        return c;
    }
    public boolean delete(int id){
        Optional<Message> cOp= messageRepository.getById(id);
        if(cOp.isPresent()){
            messageRepository.delete(cOp.get());
            return true;
        }
        return false;
    }
    public Message update(Message c){
        if(c.getIdMessage()!=null){
            Optional<Message> old= messageRepository.getById(c.getIdMessage());
            if(old.isPresent()){
                Message k=old.get();
                if(c.getIdMessage()!=null){
                    k.setIdMessage(c.getIdMessage());
                }
                if(c.getMessageText()!=null){
                    k.setMessageText(c.getMessageText());
                }

                return messageRepository.save(k);
            }
        }
        return c;
    }
}

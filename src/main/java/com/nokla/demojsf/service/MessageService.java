package com.nokla.demojsf.service;

import com.nokla.demojsf.entity.Message;
import com.nokla.demojsf.repository.MessageRepository;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;


import java.util.List;
//import java.util.logging.Logger;

@Stateful
public class MessageService {
//    protected Logger logger = Logger.getLogger(MessageService.class.getName());

    @Inject
    MessageRepository repository;


    public void create(Message message){
        repository.create(message);
    }

    public List<Message> getMessages(){
        return repository.getAll();
    }

    public void delete(Message message){
        repository.delete(message);
    }


}



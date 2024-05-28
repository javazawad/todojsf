package com.nokla.demojsf.service;

import com.nokla.demojsf.entity.Message;
import com.nokla.demojsf.repository.MessageRepository;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
//import java.util.logging.Logger;

@Stateful
public class MessageService {
    protected Logger logger = Logger.getLogger(MessageService.class.getName());

    @Inject
    MessageRepository messageRepository;


    public void create(Message message){
        messageRepository.create(message);
    }

    public List<Message> getMessages(){
        List<Message> messages = messageRepository.getAll();
//        messages.forEach(m -> logger.warning(m.getText()));
        return messages;
    }

    public Optional<Message> getMessage(Long id){
        return messageRepository.get(id);
    }

    public void delete(Message message){
        messageRepository.delete(message);
    }

    public void delete(Long id){
        messageRepository.delete(id);
    }

    public void updateMessage(Message message){
        logger.warning("updateing message. id:" + message.getId() + " text: " + message.getText());
        messageRepository.update(message);
    }


}



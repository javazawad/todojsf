package com.nokla.demojsf.service;

import com.nokla.demojsf.entity.Message;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateful
public class MessageService {
    @PersistenceContext(name = "testdb")
    private EntityManager entitymanager;

    public void create(Message message){
        entitymanager.persist(message);
    }

    public List<Message> getMessages(){
        return entitymanager
                .createQuery("SELECT m FROM Message m", Message.class)
                .getResultList();
    }


}

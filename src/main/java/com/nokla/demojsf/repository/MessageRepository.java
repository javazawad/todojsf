package com.nokla.demojsf.repository;

import com.nokla.demojsf.entity.Message;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class MessageRepository {
    @PersistenceContext(unitName = "todoDB")
    private EntityManager entitymanager;

    public List<Message> getAll(){
        return entitymanager
                .createQuery("SELECT m FROM Message m", Message.class)
                .getResultList();
    }
    public void create(Message message){
        entitymanager.persist(message);
    }

    public void delete(Message message){
        Message msg = entitymanager.find(Message.class, message.getId());
        entitymanager.remove(msg);
    }

}

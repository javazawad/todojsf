package com.nokla.demojsf.repository;

import com.nokla.demojsf.entity.Message;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;


@Stateless
public class MessageRepository {
    @PersistenceContext(unitName = "todoDB")
    private EntityManager entitymanager;

    public List<Message> getAll(){
        return entitymanager
                .createQuery("SELECT m FROM Message m", Message.class)
                .getResultList();
    }

    public Optional<Message> get(Long id){
        return Optional.ofNullable(entitymanager.find(Message.class, id));
    }
    public void create(Message message){
        entitymanager.persist(message);
    }

    public void delete(Message message){
        Message msg = entitymanager.find(Message.class, message.getId());
        entitymanager.remove(msg);
    }

    public void delete(Long id){
        Message msg = entitymanager.find(Message.class, id);
        entitymanager.remove(msg);
    }

    public void update(Message message){
        entitymanager.merge(message);
    }

}

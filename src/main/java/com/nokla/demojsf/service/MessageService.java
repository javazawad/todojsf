package com.nokla.demojsf.service;

import com.nokla.demojsf.entity.Message;
import com.nokla.demojsf.view.HelloWorld;
import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.logging.Logger;

@Stateful
public class MessageService {
    protected Logger logger = Logger.getLogger(MessageService.class.getName());

    @PersistenceContext(unitName = "todoDB")
    private EntityManager entitymanager;

    public void create(Message message){
        entitymanager.persist(message);
    }

    public List<Message> getMessages(){
        return entitymanager
                .createQuery("SELECT m FROM Message m", Message.class)
                .getResultList();
    }

    public void delete(Message message){
        try{

            Message msg = entitymanager.find(Message.class, message.getId());
            entitymanager.remove(msg);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            logger.warning(e.getMessage());
        }
    }


}

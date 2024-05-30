package com.nokla.demojsf.service;

import com.nokla.demojsf.entity.user.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserService {
    @PersistenceContext
    EntityManager em;

    public void createUser(User user){
        try {
            em.persist(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("UserService.createUser");
            System.out.println("user = " + user);
        }
    }

    public Optional<User> getUserByUsername(String username){
        try {
            return Optional.ofNullable( em.createQuery("select u from User u where u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<User> getUserById(Long id){
        return Optional.ofNullable(em.find(User.class, id));
    }

    public List<User> getAllUsers(){
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}

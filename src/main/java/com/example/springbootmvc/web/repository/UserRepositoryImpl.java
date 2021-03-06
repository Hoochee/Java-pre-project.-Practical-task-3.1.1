package com.example.springbootmvc.web.repository;

import com.example.springbootmvc.web.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
    }

    @Override
    public List<User> listUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
        em.createQuery("delete from User u where u.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}

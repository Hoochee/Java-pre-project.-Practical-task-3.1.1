package com.example.springbootmvc.web.services;

import com.example.springbootmvc.web.model.User;
import com.example.springbootmvc.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return repository.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(Long id) {
        return repository.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(id);

    }
}

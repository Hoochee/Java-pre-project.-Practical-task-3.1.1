package com.example.springbootmvc.web.repository;

import com.example.springbootmvc.web.model.User;


import java.util.List;

public interface UserRepository {

    void save(User user);

    List<User> listUsers();

    User getById(Long id);

    void delete(Long id);
}

package com.example.ecommerce.service;

import com.example.ecommerce.model.User;

import java.util.List;

public interface UsersService {
    public List<User> getList();

    public Boolean saveUser(User user);

    public Boolean updateUser(User user);

    public User getItem(long id);

    public Boolean deleteItem(long id);

    public User findUserByLogin(String login);
}
package com.example.PP_3_2_1_SB.service;


import com.example.PP_3_2_1_SB.model.User;


import java.util.List;

public interface UserService {

    void create(User user);

    List<User> getAllUsers();

    void deleteUser(int id);

    void updateUser(User user);

    User getUserById(int id);
}

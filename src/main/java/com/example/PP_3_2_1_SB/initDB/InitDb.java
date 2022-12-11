package com.example.PP_3_2_1_SB.initDB;

import com.example.PP_3_2_1_SB.model.User;
import com.example.PP_3_2_1_SB.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class InitDb {
    private final UserService userService;

    @Autowired
    public InitDb(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void postConstruct() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            userService.create(new User("test", "test", 23));
            userService.create(new User("тест", "тест", 32));
            userService.create(new User("Иван", "Ivanov", 45));
        }
    }
}

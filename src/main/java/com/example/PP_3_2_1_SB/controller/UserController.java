package com.example.PP_3_2_1_SB.controller;

import com.example.PP_3_2_1_SB.model.User;
import com.example.PP_3_2_1_SB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String MainPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }


    @RequestMapping ("/new")
    public String addUser (Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "new";
    }

    @RequestMapping(value = "/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.create(user);
        return "redirect:/";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("updateUser", userService.getUserById(id));
        return "edit";
    }

    @RequestMapping("/{id}/update")
    public String updateUser(@ModelAttribute("updateUser") User editUser) {
        userService.updateUser(editUser);
        return "redirect:/";
    }


}

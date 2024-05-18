package com.nabilla.myasset.controller;

import com.nabilla.myasset.model.User;
import com.nabilla.myasset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/myasset")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/user/form")
    public String showUserFormPage() {
        return "user-form";
    }

    @PostMapping("/user/save")
    public String saveUser(
            @ModelAttribute User user,
            Model model
    ) {
        userService.saveUser(user);
        Long id = userService.saveUser(user).getId();
        String message = "Record with id : '"+id+"' is saved successfully !";
        model.addAttribute("message", message);
        return "user-form";
    }

    @GetMapping("/user/getAllUsers")
    public String getAllUsers(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<User> users= userService.getAllUsers();
        model.addAttribute("list", users);
        model.addAttribute("message", message);
        return "index";
    }
}

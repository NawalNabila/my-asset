package com.nabilla.myasset.controller;

import com.nabilla.myasset.model.User;
import com.nabilla.myasset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHomepage(
            Model model
    ) {
        List<User> users= userService.getList();
        model.addAttribute("list", users);

        return "index";
    }

    @GetMapping("/create")
    public String viewCreateFormPage() {
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(
            @ModelAttribute User user,
            Model model
    ) {
        String password = "1234dummy";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);

        userService.save(user);

        return "redirect:/users/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView viewEditFormPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("user-edit-form");

        User user = userService.getById(id);
        mav.addObject("user", user);

        return mav;
    }
}

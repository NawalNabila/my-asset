package com.nabilla.myasset.controller;

import com.nabilla.myasset.model.Role;
import com.nabilla.myasset.model.User;
import com.nabilla.myasset.service.RoleService;
import com.nabilla.myasset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String viewHomepage(
            Model model
    ) {
        List<User> users= userService.getList();
        model.addAttribute("list", users);

        return "index";
    }

    @GetMapping("/users/create")
    public String viewCreateFormPage(Model model) {
        List<Role> roles = roleService.getList();
        model.addAttribute("roles", roles);

        return "user-form";
    }

    @PostMapping("/users/save")
    public String saveUser(
            @ModelAttribute User user
    ) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode("1234dummy"));

        userService.save(user);

        return "redirect:/";
    }

    @GetMapping("/users/edit/{id}")
    public ModelAndView viewEditFormPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("user-edit-form");
        List<Role> roles = roleService.getList();
        User user = userService.getById(id);
        mav.addObject("user", user);
        mav.addObject("roles", roles);

        return mav;
    }

    @PostMapping("/users/update")
    public String updateUser(
            @ModelAttribute User user
    ) {
        User oldUser = userService.getById(user.getId());
        user.setPassword(oldUser.getPassword());
        userService.save(user);

        return "redirect:/";
    }
}

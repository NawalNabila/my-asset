package com.nabilla.myasset.controller;

import com.nabilla.myasset.model.Role;
import com.nabilla.myasset.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String viewRolePage(
            Model model
    ) {
        List<Role> roles= roleService.getList();
        model.addAttribute("list", roles);

        return "role";
    }

    @GetMapping("/create")
    public String viewCreateFormPage() {
        return "role-form";
    }

    @PostMapping("/save")
    public String saveRole(
            @ModelAttribute Role role
    ) {
        roleService.save(role);

        return "redirect:/roles/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView viewEditFormPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("role-edit-form");

        Role role = roleService.getById(id);
        mav.addObject("role", role);

        return mav;
    }
}

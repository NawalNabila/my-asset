package com.nabilla.myasset.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myasset/role")
public class RoleController {

    @GetMapping("/")
    public String showRolePage() {
        return "role";
    }

    @GetMapping("/form")
    public String showRoleFormPage() {
        return "role-form";
    }
}

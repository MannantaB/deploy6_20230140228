package com.example.pertemuan6.controller;

import com.example.pertemuan6.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> listUser = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if (username.equals("admin") && password.equals("20210140019")) {
            return "redirect:/home";
        }

        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("list", listUser);
        return "home";
    }

    @GetMapping("/form")
    public String formPage() {
        return "form";
    }

    @PostMapping("/save")
    public String save(@RequestParam String nama,
                       @RequestParam String nim,
                       @RequestParam String jenisKelamin) {

        listUser.add(new User(nama, nim, jenisKelamin));

        return "redirect:/home";
    }
}

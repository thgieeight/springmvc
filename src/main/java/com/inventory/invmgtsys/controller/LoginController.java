package com.inventory.invmgtsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String openLoginPage(){
        return "login";
    }

    @GetMapping("/index")
    public String try2() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        if (session != null) {
            session.invalidate();
        }
        return "/login";
    }
}


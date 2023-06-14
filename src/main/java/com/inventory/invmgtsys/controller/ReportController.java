package com.inventory.invmgtsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {
    @GetMapping("/report")
    public String getTest(){
        return "report";
    }
}

package com.inventory.invmgtsys.controller;

import com.inventory.invmgtsys.dto.EmailDto;
import com.inventory.invmgtsys.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class EmailController {
//
//    @Autowired
//    EmailDto emailDto;
//
//
//    private final EmailUtils emailUtils;
//
//    public EmailController(EmailUtils emailUtils) {
//        this.emailUtils = emailUtils;
//    }


    @GetMapping("/send-email")
    public String sendEmail(){
//        String message = emailUtils.sendSimpleEmail(emailDto);
        return "send-email";
    }

}
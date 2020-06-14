package com.example.mailsender.controller;

import com.example.mailsender.model.MyEmail;
import com.example.mailsender.service.EmailSenderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class EmailSenderRestController {

    private EmailSenderService emailSenderService;

    public EmailSenderRestController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send")
    public MyEmail sendMail(@RequestBody MyEmail myEmail) {
        return emailSenderService.sendEmail(myEmail);
    }
}

package com.example.mailsender.service;

import com.example.mailsender.model.MyEmail;

public interface EmailSender {

    MyEmail sendEmail(MyEmail myEmail);
}

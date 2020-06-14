package com.example.mailsender.service;

import com.example.mailsender.model.MyEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService implements EmailSender{
    public static final Logger logger = LoggerFactory.getLogger(EmailSenderService.class);

    private JavaMailSender javaMailSender;

//    @Autowired
    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public MyEmail sendEmail(MyEmail myEmail) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {
            helper = new MimeMessageHelper(mail, true);
            helper.setTo(myEmail.getAddress());
            helper.setReplyTo("lukasz.birski@gmail.com");
            helper.setFrom("lukasz.birski@gmail.com");
            helper.setSubject(myEmail.getSubject());
            helper.setText(myEmail.getBody(), true);

        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("Error while sending email: {}", e.getMessage());
            return null;
        }
        javaMailSender.send(mail);
        return myEmail;
    }
}

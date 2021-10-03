package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService{

    @Autowired
    private JavaMailSender mailSender;
    
    public void sendEmail(Usuario usuario){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(usuario.getMail());
        mailMessage.setSubject("Bienvenido");
        mailMessage.setText("Su cuenta ha sido creada con exito");
        mailSender.send(mailMessage);
    }
}

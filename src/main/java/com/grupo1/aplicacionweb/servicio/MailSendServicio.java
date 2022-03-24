package com.grupo1.aplicacionweb.servicio;


import com.grupo1.aplicacionweb.interfaz.IMailsend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailSendServicio implements IMailsend{
    @Autowired
    private JavaMailSender javamailSender;

@Override
@Async
    public void enviar (String email, String cuerpo){

        SimpleMailMessage mensaje = new SimpleMailMessage();
String titulo = "Registro de Receta";
mensaje.setFrom("recetapp.egg@gmail.com");
mensaje.setTo(email);
mensaje.setSubject(titulo);
mensaje.setText(cuerpo);

javamailSender.send(mensaje);



    }

    

   


    
}

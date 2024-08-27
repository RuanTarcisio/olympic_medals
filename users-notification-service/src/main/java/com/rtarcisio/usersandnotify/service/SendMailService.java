package com.rtarcisio.usersandnotify.service;

import com.rtarcisio.usersandnotify.dtos.UsuarioDto;
import com.rtarcisio.usersandnotify.rabbit.events.MedalCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SendMailService {

    private  final UsuarioService usuarioService;

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    @RabbitListener(queues = "olympic.medals-created")
    public void onMedalCreated(MedalCreatedEvent event){

        List<UsuarioDto> users = usuarioService.queSeguemPais(event.getCountryCode());
        List<String> listEmails = new ArrayList<>();
        String mensagem = event.getCountryName() + " acabou de ganhar uma medalha de "
                +event.getTypeMedal() + " no sport " + event.getSportName();
        String assunto = event.getCountryName() + " acabou de ganhar uma medalha de " + event.getTypeMedal();

        for(UsuarioDto usuarioDto : users){
            listEmails.add(usuarioDto.email());
        }
        sendEmail(listEmails,assunto, mensagem);
    }

    public String sendEmail(List<String> destinatarios, String assunto, String mensagem) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(destinatarios.toArray(new String[0]));
            message.setFrom(remetente);
            message.setSubject(assunto);
            message.setText(mensagem);
            mailSender.send(message);
            System.out.println("DEU CERTO!!!");
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar email.");
        }
    }

}
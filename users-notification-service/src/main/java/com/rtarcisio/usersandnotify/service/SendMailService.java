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
            // Converte a ArrayList de destinatários para um array
            message.setTo(destinatarios.toArray(new String[0]));
            message.setFrom(remetente);
            message.setSubject(assunto);
            message.setText(mensagem);
            mailSender.send(message);
            System.out.println("DEU CERTO!!!");
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            return "Erro ao tentar enviar email: " + e.getLocalizedMessage();
        }
    }

//    public void sendEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        message.setFrom("ruantarciisio@gmail.com");
//
//        mailSender.send(message);
//    }
//
//    public void sendEmail(String to, String subject, String text) {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setFrom("your-email@gmail.com");
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(text, true); // Set to true to enable HTML content
//            javaMailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void sendBulkEmail(String subject, String text, List<String> toAddresses) {
//        for (String toAddress : toAddresses) {
//            sendEmail(toAddress, subject, text);
//        }
//    }
}
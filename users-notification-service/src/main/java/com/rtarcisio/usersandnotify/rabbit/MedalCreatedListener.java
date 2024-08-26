package com.rtarcisio.usersandnotify.rabbit;

import com.rtarcisio.usersandnotify.rabbit.events.MedalCreatedEvent;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MedalCreatedListener {

    @RabbitListener(queues = "olympic.medals-created")
    public void onMedalCreated(MedalCreatedEvent event){
        System.out.println("Tipo de medalha: " + event.getTypeMedal());
        System.out.println("Pais: " + event.getCountryName());
        System.out.println("Esporte: " + event.getSportName());
    }
}

package com.projectform.ms.volunteers.producers;


import com.projectform.ms.volunteers.dto.EmailDto;
import com.projectform.ms.volunteers.models.VolunteerModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VolunteerProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMenssageEmail(VolunteerModel volunteerModel) {
        var emailDto = new EmailDto();
        emailDto.setUserId(volunteerModel.getUserId());
        emailDto.setEmailTo(volunteerModel.getEmail());
        emailDto.setSubject("Bem vindo ao projeto");
        emailDto.setText("Caro " + volunteerModel.getName() + ", você foi cadastrado com sucesso no projeto!");


        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
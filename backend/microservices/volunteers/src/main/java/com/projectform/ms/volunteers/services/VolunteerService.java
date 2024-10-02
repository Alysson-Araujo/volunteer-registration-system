package com.projectform.ms.volunteers.services;


import com.projectform.ms.volunteers.models.VolunteerModel;
import com.projectform.ms.volunteers.producers.VolunteerProducer;
import com.projectform.ms.volunteers.repositories.VolunteersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService {

    @Autowired
    private VolunteersRepository volunteersRepository;

    @Autowired
    private VolunteerProducer volunteerProducer;

    @Transactional
    public VolunteerModel save(VolunteerModel volunteerModel) {
        volunteerModel = volunteersRepository.save(volunteerModel);
        volunteerProducer.publishMenssageEmail(volunteerModel);
        return volunteerModel;
    }
}

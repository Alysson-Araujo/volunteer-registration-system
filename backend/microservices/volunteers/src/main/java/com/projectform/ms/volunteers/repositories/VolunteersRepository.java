package com.projectform.ms.volunteers.repositories;


import com.projectform.ms.volunteers.models.VolunteerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VolunteersRepository extends JpaRepository<VolunteerModel, UUID> {
}

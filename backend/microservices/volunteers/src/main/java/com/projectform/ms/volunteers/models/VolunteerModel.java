package com.projectform.ms.volunteers.models;


import com.projectform.ms.volunteers.enums.FunctionVolunteersEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_VOLUNTEERS")
@Getter
@Setter
public class VolunteerModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String name;
    private String email;
    private String phone;
    private FunctionVolunteersEnum function;
    private String pollingStation;


}

package com.projectform.ms.volunteers.dto;

import com.projectform.ms.volunteers.enums.FunctionVolunteersEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record VolunteeRecordDto(@NotBlank String name, @NotBlank @Email String email, @NotBlank String phone,
                                @NotBlank String function, @NotBlank String pollingStation) {
}
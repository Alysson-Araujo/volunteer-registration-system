package com.projectform.ms.volunteers.controllers;


import com.projectform.ms.volunteers.dto.VolunteeRecordDto;
import com.projectform.ms.volunteers.enums.FunctionVolunteersEnum;
import com.projectform.ms.volunteers.exceptions.*;
import com.projectform.ms.volunteers.exceptions.IllegalArgumentException;
import com.projectform.ms.volunteers.exceptions.NullPointerException;
import com.projectform.ms.volunteers.models.VolunteerModel;
import com.projectform.ms.volunteers.services.VolunteerService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VolunteersController {

    @Autowired
    private VolunteerService volunteerService;

    @PostMapping("/volunteers")
    public ResponseEntity<VolunteerModel> saveVolunteer(@RequestBody @Valid VolunteeRecordDto volunteeRecordDto) {

        try {
            var volunteerModel = new VolunteerModel();
            BeanUtils.copyProperties(volunteeRecordDto, volunteerModel);


            if (volunteeRecordDto.function() != null) {
                try {
                    switch (volunteeRecordDto.function()) {
                        case "ATENDIMENTO":
                            volunteerModel.setFunction(FunctionVolunteersEnum.ATENDIMENTO);
                            break;
                        case "LIMPEZA":
                            volunteerModel.setFunction(FunctionVolunteersEnum.LIMPEZA);
                            break;
                        case "ORGANIZACAO":
                            volunteerModel.setFunction(FunctionVolunteersEnum.ORGANIZACAO);
                            break;
                        case "OUTROS":
                            volunteerModel.setFunction(FunctionVolunteersEnum.OUTROS);
                            break;
                        default:
                            throw new java.lang.IllegalArgumentException("Invalid data");
                    }
                    FunctionVolunteersEnum functionEnum = FunctionVolunteersEnum.valueOf(volunteeRecordDto.function());
                    volunteerModel.setFunction(functionEnum);
                } catch (IllegalArgumentException e) {
                    // Caso a string não corresponda a nenhum valor do enum
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                }
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(volunteerService.save(volunteerModel));

        } catch (DataIntegrityViolationException exception){
            throw new DataIntegrityViolationException("Volunteer already registered", exception);
        }
        catch (HttpMessageNotReadableException exception){
            throw new HttpMessageNotReadableException("Invalid data", exception);
        }
        catch (IllegalArgumentException exception){
            throw new IllegalArgumentException("Invalid data", exception);
        }
        catch (MethodArgumentNotValidException exception){
            throw new MethodArgumentNotValidException("Invalid data", exception);
        }
        catch (NoSuchElementException exception){
            throw new NoSuchElementException("Volunteer not found", exception);
        }
        catch (NullPointerException exception){
            throw new NullPointerException("Invalid data", exception);
        }
    }
}

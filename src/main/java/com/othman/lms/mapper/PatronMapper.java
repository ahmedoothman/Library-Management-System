package com.othman.lms.mapper;
import com.othman.lms.entity.Patron;

import org.springframework.stereotype.Component;

import com.othman.lms.dto.PatronDTO;

@Component
public class PatronMapper {
    public PatronDTO toDto(Patron patron) {
        PatronDTO patronDTO = new PatronDTO();
        patronDTO.setId(patron.getId());
        patronDTO.setName(patron.getName());
        patronDTO.setEmail(patron.getEmail());
        patronDTO.setPhone(patron.getPhone());
        return patronDTO;
    }

    public Patron toEntity(PatronDTO patronDTO) {
        Patron patron = new Patron();
        patron.setId(patronDTO.getId());
        patron.setName(patronDTO.getName());
        patron.setEmail(patronDTO.getEmail());
        patron.setPhone(patronDTO.getPhone());
        return patron;
    }
}

package com.othman.lms.service;

import com.othman.lms.dto.PatronDTO;
import com.othman.lms.entity.Patron;
import com.othman.lms.exception.ResourceNotFoundException;
import com.othman.lms.mapper.PatronMapper;
import com.othman.lms.repository.PatronRepository;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PatronService {

    private final PatronRepository patronRepository;
    private final PatronMapper patronMapper;

    @Transactional(readOnly = true)
    public List<PatronDTO> findAll() {
        return patronRepository.findAll().stream().map(patronMapper::toDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PatronDTO findById(Long id) {
        return patronRepository.findById(id).map(patronMapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Patron not found with ID: " + id));
    }


    public PatronDTO save(PatronDTO patronDTO) {
        Patron patron = patronMapper.toEntity(patronDTO);
        Patron savedPatron = patronRepository.save(patron);
        return patronMapper.toDto(savedPatron);
    }
    public PatronDTO update(Long id, PatronDTO patronDTO) {
        Optional<Patron> existingPatron = patronRepository.findById(id);
        if (existingPatron.isPresent()) {
            Patron updatedPatron = patronMapper.toEntity(patronDTO);
            updatedPatron.setId(id);
            Patron savedPatron = patronRepository.save(updatedPatron);
            return patronMapper.toDto(savedPatron);
        } else {
            throw new ResourceNotFoundException("Patron not found with ID: " + id);
        }
    }
    public void deleteById(Long id) {
        if (!patronRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patron not found with ID: " + id);
        }
        patronRepository.deleteById(id);
    }
}

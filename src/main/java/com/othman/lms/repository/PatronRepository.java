package com.othman.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.othman.lms.entity.Patron;
public interface PatronRepository extends JpaRepository<Patron, Long> {
    
}

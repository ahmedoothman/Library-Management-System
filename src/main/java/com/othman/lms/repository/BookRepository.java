package com.othman.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.othman.lms.entity.Book;
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
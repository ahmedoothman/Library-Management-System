package com.othman.lms.service;

import com.othman.lms.dto.BookDTO;
import com.othman.lms.entity.Book;
import com.othman.lms.exception.ResourceNotFoundException;
import com.othman.lms.mapper.BookMapper;
import com.othman.lms.repository.BookRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    
   
    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    
    public BookDTO findById(Long id) {
        return bookRepository.findById(id).map(bookMapper::toDto).orElseThrow(()-> new ResourceNotFoundException("Book not found with ID: " + id));
    }

    
    public BookDTO save(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    
    public BookDTO update(Long id, BookDTO bookDTO) {
        if(!bookRepository.existsById(id)){
            throw new ResourceNotFoundException("Book not found with ID: " + id);
        }
        bookDTO.setId(id);
        Book book = bookMapper.toEntity(bookDTO);
        Book updatedBook = bookRepository.save(book);
        return bookMapper.toDto(updatedBook);
    }

    
    public void deleteById(Long id) {
        if(!bookRepository.existsById(id)){
            throw new ResourceNotFoundException("Book not found with ID: " + id);
        }
        bookRepository.deleteById(id);
    }
}

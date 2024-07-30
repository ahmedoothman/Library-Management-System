package com.othman.lms.service;

import com.othman.lms.dto.BorrowingRecordDTO;
import com.othman.lms.entity.Book;
import com.othman.lms.entity.BorrowingRecord;
import com.othman.lms.entity.Patron;
import com.othman.lms.mapper.BorrowingRecordMapper;
import com.othman.lms.repository.BookRepository;
import com.othman.lms.repository.BorrowingRecordRepository;
import com.othman.lms.repository.PatronRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@Transactional
@RequiredArgsConstructor
public class BorrowingRecordService {

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;
    private final BorrowingRecordMapper borrowingRecordMapper;

    
    public BorrowingRecordDTO borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId)
                                  .orElseThrow(() -> new RuntimeException("Book not found"));
        Patron patron = patronRepository.findById(patronId)
                                        .orElseThrow(() -> new RuntimeException("Patron not found"));

 
        BorrowingRecord record = new BorrowingRecord();
        record.setBook(book);
        record.setPatron(patron);
        record.setBorrowingDate(LocalDate.now());

        BorrowingRecord savedRecord = borrowingRecordRepository.save(record);

        return borrowingRecordMapper.toDto(savedRecord);
    }

    public BorrowingRecordDTO returnBook(Long bookId, Long patronId) {

        BorrowingRecord record = borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId)
                                                          .orElseThrow(() -> new RuntimeException("Borrowing record not found or book already returned"));

        record.setReturnDate(LocalDate.now());
        BorrowingRecord updatedRecord = borrowingRecordRepository.save(record);
        return borrowingRecordMapper.toDto(updatedRecord);
    }
}

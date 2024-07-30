package com.othman.lms.controller;

import com.othman.lms.dto.BorrowingRecordDTO;
import com.othman.lms.service.BorrowingRecordService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BorrowingRecordController {

    private final BorrowingRecordService borrowingRecordService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecordDTO> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecordDTO dto = borrowingRecordService.borrowBook(bookId, patronId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecordDTO> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecordDTO dto = borrowingRecordService.returnBook(bookId, patronId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

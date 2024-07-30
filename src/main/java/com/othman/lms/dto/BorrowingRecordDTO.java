package com.othman.lms.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowingRecordDTO {
    private Long id;

    @NotNull(message = "Book ID is required")
    private Long bookId;

    @NotNull(message = "Patron ID is required")
    private Long patronId;

    @NotNull(message = "Borrowing date is required")
    private LocalDate borrowingDate;

    private LocalDate returnDate;
}

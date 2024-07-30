package com.othman.lms.mapper;

import com.othman.lms.dto.BorrowingRecordDTO;
import com.othman.lms.entity.BorrowingRecord;
import org.springframework.stereotype.Component;

@Component
public class BorrowingRecordMapper {
    public BorrowingRecordDTO toDto(BorrowingRecord record) {
        BorrowingRecordDTO dto = new BorrowingRecordDTO();
        dto.setId(record.getId());
        dto.setBookId(record.getBook().getId());
        dto.setPatronId(record.getPatron().getId());
        dto.setBorrowingDate(record.getBorrowingDate());
        dto.setReturnDate(record.getReturnDate());
        return dto;
    }

    public BorrowingRecord toEntity(BorrowingRecordDTO dto) {
        BorrowingRecord record = new BorrowingRecord();
        record.setId(dto.getId());
        record.setBorrowingDate(dto.getBorrowingDate());
        record.setReturnDate(dto.getReturnDate());
        return record;
    }
}

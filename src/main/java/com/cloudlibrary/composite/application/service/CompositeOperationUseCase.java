package com.cloudlibrary.composite.application.service;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public interface CompositeOperationUseCase {

    CompositeReadUseCase createBook(BookCreatedCommand command);
    CompositeReadUseCase.FindLendingResult createLending(LendingCreatedCommand command);


    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BookCreatedCommand{
        private final Long bookId;
        private final String rid;
        private final Long libraryId;
        private final String isbn;
        private final String title;
        private final String coverImage;
        private final String contents;
        private final String publisher;
        private final String type;
        private final int genre;
        private final String barcode;
        private final String bookStatus;
        private final LocalDate publishDate;
        private final LocalDateTime lendingAvailableDateTime;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;
        private final String rfid;
        private final String category;
    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class LendingCreatedCommand{
        // Lending Info
        private final Long bookId;
        private final Long libraryId;
        private final Long uid;
        private final String lendingStatus;
        private final LocalDateTime lendingDateTime;
        private final LocalDateTime reservationDateTime;
    }
}

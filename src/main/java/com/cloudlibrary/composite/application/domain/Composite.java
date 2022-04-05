package com.cloudlibrary.composite.application.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@ToString
@Builder
public class Composite {
    // Book Info
    private final long bookId;
    private final String rid;
    private final long libraryId;
    private final String libraryName;
    private final String isbn;
    private final String title;
    private final String coverImage;
    private final String author;
    private final String translator;
    private final String contents;
    private final String publisher;
    private final String type;
    private final String genre;
    private final String barcode;
    private final String bookStatus;
    private final LocalDate publishDate;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final String rfid;
    private final String category;


    // Lending Info
    private final long uid;
    private final String lendingStatus;
    private final LocalDateTime lendingDateTime;
    private final LocalDateTime reservationDateTime;

}

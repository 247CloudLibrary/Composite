package com.cloudlibrary.composite.application.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;


@Getter
@ToString
@Builder
public class Composite {
    // Book Info
    private final long bookId;
    private final String rid;
    private final long libraryId;
    private final String isbn;
    private final String title;
    private final String thumnailimage;
    private final String coverimage;
    private final String contents;
    private final String publisher;
    private final String type;
    private final int genre;
    private final String barcode;
    private final String bookStatus;
    private final Timestamp publishdatetime;
    private final Timestamp lendingAvailableDateTime;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;
    private final String rfid;
    private final String category;


    // Lending Info
    private final long uid;
    private final String lendingStatus;
    private final Timestamp lendingDateTime;
    private final Timestamp reservationDateTime;

}

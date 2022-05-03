package com.cloudlibrary.composite.ui.requestbody;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class CompositeCreateRequest {
    // Book Info
    private Long id;
    private String rid;
    private Long libraryId;
    private String libraryName;
    private String isbn;
    private String title;
    private String thumbNailImage;
    private String coverImage;
    private String author;
    private String translator;
    private String contents;
    private String publisher;
    private String bookType;
    private String genre;
    private String barcode;
    private String bookStatus;
    private LocalDate publishDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String rfid;
    private String category;


    // Lending Info
    private Long lendingId;
    private Long uid;
    private String lendingStatus;
    private LocalDate lendingDateTime;
    private LocalDate returnDateTime;
    private LocalDateTime reservationDateTime;

    // reservation Info
    private Long orderNum;
    private LocalDateTime cancelDateTime;
}

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
    private Long bookId;
    private String rid;
    private Long libraryId;
    private String libraryName;
    private String isbn;
    private String title;
    private String thumbnailImage;
    private String coverImage;
    private String author;
    private String translator;
    private String contents;
    private String publisher;
    private String type;
    private String genre;
    private String barcode;
    private String bookStatus;
    private LocalDate publishDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String rfid;
    private Long category;


    // 이 아래 얘들은 따로 입력 안되는데 없애도 될까?
    // Lending Info
    private Long lendingId;
    private Long uid;
    private String lendingStatus;
    private LocalDateTime lendingDateTime;
    private LocalDateTime returnDateTime;
    private LocalDateTime reservationDateTime;

    // reservation Info
    private Long orderNum;
    private LocalDateTime cancelDateTime;
}

package com.cloudlibrary.composite.infrastructure.mysql.entity;


import com.cloudlibrary.composite.application.domain.Composite;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "composite")
public class CompositeEntity implements Serializable {

    @Id @GeneratedValue
    private Long compositeId;
    @Column(nullable = false, unique = true)
    private Long bookId;
    @Column(unique = true)
    private Long libraryId;

    private String rid;
    @Column(nullable = false)
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
    @Column(unique = true)
    private Long lendingId;
    @Column(unique = true)
    private Long uid;
    private String lendingStatus;
    private LocalDateTime lendingDateTime;
    private LocalDateTime returnDateTime;
    private LocalDateTime reservationDateTime;

    // reservation Info
    @Column(unique = true)
    private Long orderNum;
    private LocalDateTime cancelDateTime;

    public Composite toComposite(){
        return Composite.builder()
                .bookId(this.bookId)
                .libraryId(this.libraryId)
                .rid(this.rid)
                .libraryName(this.libraryName)
                .isbn(this.isbn)
                .title(this.title)
                .thumbNailImage(this.thumbNailImage)
                .coverImage(this.coverImage)
                .author(this.author)
                .translator(this.translator)
                .contents(this.contents)
                .publisher(this.publisher)
                .bookType(this.bookType)
                .genre(this.genre)
                .barcode(this.barcode)
                .bookStatus(this.bookStatus)
                .publishDate(this.publishDate)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .rfid(this.rfid)
                .category(this.category)
                .lendingId(this.lendingId)
                .uid(this.uid)
                .lendingStatus(this.lendingStatus)
                .lendingDateTime(this.lendingDateTime)
                .returnDateTime(this.returnDateTime)
                .reservationDateTime(this.reservationDateTime)
                .orderNum(this.orderNum)
                .cancelDateTime(this.cancelDateTime)
                .build();
    }

    public CompositeEntity(Composite composite){
        this.bookId = composite.getBookId();
        this.libraryId = composite.getLibraryId();
        this.rid = composite.getRid();
        this.libraryName = composite.getLibraryName();
        this.isbn = composite.getIsbn();
        this.title = composite.getTitle();
        this.thumbNailImage = composite.getThumbNailImage();
        this.coverImage = composite.getCoverImage();
        this.author = composite.getAuthor();
        this.translator = composite.getTranslator();
        this.contents = composite.getContents();
        this.publisher = composite.getPublisher();
        this.bookType = composite.getBookType();
        this.genre = composite.getGenre();
        this.barcode = composite.getBarcode();
        this.bookStatus = composite.getBookStatus();
        this.publishDate = composite.getPublishDate();
        this.createdAt = composite.getCreatedAt();
        this.updatedAt = composite.getUpdatedAt();
        this.rfid = composite.getRfid();
        this.category = composite.getCategory();

        this.lendingId = composite.getLendingId();
        this.uid = composite.getUid();
        this.lendingStatus = composite.getLendingStatus();
        this.lendingDateTime = composite.getLendingDateTime();
        this.returnDateTime = composite.getReturnDateTime();
        this.reservationDateTime = composite.getReservationDateTime();

        this.orderNum = composite.getOrderNum();
        this.cancelDateTime = composite.getCancelDateTime();

    }

}

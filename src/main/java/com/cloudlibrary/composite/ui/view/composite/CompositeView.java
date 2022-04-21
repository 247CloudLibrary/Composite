package com.cloudlibrary.composite.ui.view.composite;


import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.application.service.CompositeReadUseCase;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompositeView {
    @ApiModelProperty(value = "도서 아이디")
    private final Long bookId;
    @ApiModelProperty(value = "도서 rid")
    private final String rid;
    @ApiModelProperty(value = "도서 isbn")
    private final String isbn;
    @ApiModelProperty(value = "도서 제")
    private final String title;
    @ApiModelProperty(value = "도서 썸네일 이미지")
    private final String thumbNailImage;
    @ApiModelProperty(value = "도서 커버 이미지")
    private final String coverImage;
    @ApiModelProperty(value = "작가")
    private final String author;
    @ApiModelProperty(value = "역자")
    private final String translator;
    @ApiModelProperty(value = "도서 내용")
    private final String contents;
    @ApiModelProperty(value = "출판사")
    private final String publisher;
    @ApiModelProperty(value = "출판일")
    private final LocalDate publishDate;
    @ApiModelProperty(value = "도서 종류")
    private final String bookType;
    @ApiModelProperty(value = "도서 장르")
    private final String genre;
    @ApiModelProperty(value = "바코드")
    private final String barcode;
    @ApiModelProperty(value = "도서 rfid")
    private final String rfid;
    @ApiModelProperty(value = "도서 상태")
    private final String bookStatus;
    @ApiModelProperty(value = "도서관 이름")
    private final String libraryName;
    @ApiModelProperty(value = "카테고리")
    private final String category;
    @ApiModelProperty(value = "등록일")
    private final LocalDateTime createdAt;
    @ApiModelProperty(value = "갱신일")
    private final LocalDateTime updatedAt;


    // Lending Info
    @ApiModelProperty(value = "도서관 아이디")
    private final Long libraryId;
    @ApiModelProperty(value = "대여 아이디")
    private final Long lendingId;
    @ApiModelProperty(value = "유저 아이디")
    private final Long uid;
    @ApiModelProperty(value = "대출 상태")
    private final String lendingStatus;
    @ApiModelProperty(value = "대출 일자")
    private final LocalDateTime lendingDateTime;
    @ApiModelProperty(value = "반납 일자")
    private final LocalDateTime returnDateTime;
    @ApiModelProperty(value = "예약 일자")
    private final LocalDateTime reservationDateTime;

    // reservation Info
    @ApiModelProperty(value = "예약 번호")
    private final Long orderNum;
    @ApiModelProperty(value = "취소 일자")
    private final LocalDateTime cancelDateTime;

    public CompositeView(CompositeReadUseCase.FindCompositeResult result){
        this.bookId = result.getBookId();
        this.rid = result.getRid();
        this.isbn = result.getIsbn();
        this.title = result.getTitle();
        this.thumbNailImage = result.getThumbNailImage();
        this.coverImage = result.getCoverImage();
        this.author = result.getAuthor();
        this.translator = result.getTranslator();
        this.contents = result.getContents();
        this.publisher = result.getPublisher();
        this.publishDate = result.getPublishDate();
        this.bookType = result.getBookType();
        this.genre = result.getGenre();
        this.barcode = result.getBarcode();
        this.rfid = result.getRfid();
        this.bookStatus = result.getBookStatus();
        this.libraryName = result.getLibraryName();
        this.category = result.getCategory();
        this.createdAt = result.getCreatedAt();
        this.updatedAt = result.getUpdatedAt();
        this.libraryId = result.getLibraryId();
        this.lendingId = result.getLendingId();
        this.uid = result.getUid();
        this.lendingStatus = result.getLendingStatus();
        this.lendingDateTime = result.getLendingDateTime();
        this.returnDateTime = result.getReturnDateTime();
        this.reservationDateTime = result.getReservationDateTime();
        this.orderNum = result.getOrderNum();
        this.cancelDateTime = result.getCancelDateTime();

    }
}

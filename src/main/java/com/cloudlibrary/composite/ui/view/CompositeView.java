package com.cloudlibrary.composite.ui.view;


import com.cloudlibrary.composite.application.service.CompositeReadUseCase;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompositeView {

    @ApiModelProperty(value = "도서 아이디")
    private final long bookId;
    @ApiModelProperty(value = "도서관 아이디")
    private final long libraryId;
    @ApiModelProperty(value = "도서관 이름")
    private final String libraryName;
    @ApiModelProperty(value = "도서 제목")
    private final String title;
    @ApiModelProperty(value = "도서 바코드")
    private final String barcode;
    @ApiModelProperty(value = "도서 내용")
    private final String contents;
    @ApiModelProperty(value = "도서 장르")
    private final String genre;
    @ApiModelProperty(value = "책 표지")
    private final String coverImage;
    @ApiModelProperty(value = "저자")
    private final String author;
    @ApiModelProperty(value = "번역가")
    private final String translator;
    @ApiModelProperty(value = "출판사")
    private final String publisher;
    @ApiModelProperty(value = "출판일")
    private final LocalDate publishDate;
    @ApiModelProperty(value = "도서 대출 상태")
    private final String lendingStatus;
    @ApiModelProperty(value = "도서 아이디")
    private final LocalDateTime lendingDateTime;

    public CompositeView(CompositeReadUseCase.FindBookAndLendingResult result){
        this.bookId = result.getBookId();
        this.libraryId = result.getLibraryId();
        this.libraryName = result.getLibraryName();
        this.title = result.getTitle();
        this.barcode = result.getBarcode();
        this.author = result.getAuthor();
        this.contents = result.getContents();
        this.genre = result.getGenre();
        this.coverImage = result.getCoverImage();
        this.translator = result.getTranslator();
        this.publisher = result.getPublisher();
        this.publishDate = result.getPublishDate();
        this.lendingStatus = result.getLendingStatus();
        this.lendingDateTime = result.getLendingDateTime();
    }

}

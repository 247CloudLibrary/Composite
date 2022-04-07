package com.cloudlibrary.composite.ui.view.composite;


import com.cloudlibrary.composite.application.domain.Composite;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompositeCompactView {
    @ApiModelProperty(value = "도서 아이디")
    private final Long bookId;
    @ApiModelProperty(value = "도서관 아이디")
    private final Long libraryId;
    @ApiModelProperty(value = "도서관 이름")
    private final String libraryName;
    @ApiModelProperty(value = "도서 바코드")
    private final String barcode;
    @ApiModelProperty(value = "도서 제목")
    private final String title;
    @ApiModelProperty(value = "도서 썸네일 이미지")
    private final String thumbnailImage;
    @ApiModelProperty(value = "도서 표지 이미지")
    private final String coverImage;
    @ApiModelProperty(value = "작가")
    private final String author;
    @ApiModelProperty(value = "번역가")
    private final String translator;
    @ApiModelProperty(value = "도서 내용")
    private final String contents;
    @ApiModelProperty(value = "출판사")
    private final String publisher;
    @ApiModelProperty(value = "출판일")
    private final LocalDate publishDate;
    @ApiModelProperty(value = "장르")
    private final String genre;
    @ApiModelProperty(value = "대출 상태")
    private final String lendingStatus;
    @ApiModelProperty(value = "대출 일")
    private final LocalDateTime lendingDateTime;
    @ApiModelProperty(value = "도서 카테고리")
    private final String category;
    @ApiModelProperty(value = "도서 타입")
    private final String type;

    public CompositeCompactView(Composite result){
        // TODO : Composite result 이후에 CompositeFindResult로 변경

        this.bookId = result.getBookId();
        this.libraryId = result.getLibraryId();
        this.libraryName = result.getLibraryName();
        this.barcode = result.getBarcode();
        this.title = result.getTitle();
        this.thumbnailImage = result.getThumbnailImage();
        this.coverImage = result.getCoverImage();
        this.author = result.getAuthor();
        this.translator = result.getTranslator();
        this.contents = result.getContents();
        this.publisher = result.getPublisher();
        this.publishDate = result.getPublishDate();
        this.genre = result.getGenre();
        this.lendingStatus = result.getLendingStatus();
        this.lendingDateTime = result.getLendingDateTime();
        this.category = result.getCategory();
        this.type = result.getType();
    }

}

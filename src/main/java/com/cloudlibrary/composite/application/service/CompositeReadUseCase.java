package com.cloudlibrary.composite.application.service;

import com.cloudlibrary.composite.application.domain.Composite;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CompositeReadUseCase {

    List<FindCompositeResult> getCompositeListAll();
    FindCompositeResult getCompositeByBookId(BookFindQuery query);

    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Getter
    @ToString
    class BookFindQuery{
        private long bookId;

        public BookFindQuery(long bookId) {
            this.bookId = bookId;
        }
    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class FindCompositeResult{
        // Book Info
        private final Long bookId;
        private final String rid;
        private final Long libraryId;
        private final String libraryName;
        private final String isbn;
        private final String title;
        private final String thumbnailImage;
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
        private final Long category;

        // Lending Info
        private final Long lendingId;
        private final Long uid;
        private final String lendingStatus;
        private final LocalDateTime lendingDateTime;
        private final LocalDateTime returnDateTime;
        private final LocalDateTime reservationDateTime;

        // reservation Info
        private final Long orderNum;
        private final LocalDateTime cancelDateTime;

        public static FindCompositeResult findByComposite(Composite composite){

            return FindCompositeResult.builder()
                    .bookId(composite.getBookId())
                    .rid(composite.getRid())
                    .libraryId(composite.getLibraryId())
                    .libraryName(composite.getLibraryName())
                    .isbn(composite.getIsbn())
                    .title(composite.getTitle())
                    .thumbnailImage(composite.getThumbnailImage())
                    .coverImage(composite.getCoverImage())
                    .author(composite.getAuthor())
                    .translator(composite.getTranslator())
                    .contents(composite.getContents())
                    .publisher(composite.getPublisher())
                    .type(composite.getType())
                    .genre(composite.getGenre())
                    .barcode(composite.getBarcode())
                    .bookStatus(composite.getBookStatus())
                    .publishDate(composite.getPublishDate())
                    .createdAt(composite.getCreatedAt())
                    .updatedAt(composite.getUpdatedAt())
                    .lendingId(composite.getLendingId())
                    .uid(composite.getUid())
                    .lendingStatus(composite.getLendingStatus())
                    .lendingDateTime(composite.getLendingDateTime())
                    .returnDateTime(composite.getReturnDateTime())
                    .reservationDateTime(composite.getReservationDateTime())
                    .orderNum(composite.getOrderNum())
                    .cancelDateTime(composite.getCancelDateTime())
                    .build();

        }

    }




}

package com.cloudlibrary.composite.application.service;

import com.cloudlibrary.composite.application.domain.Composite;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CompositeReadUseCase {

    List<FindCompositeResult> getCompositeListAll();
    FindCompositeResult getCompositeByBookId(BookFindQuery query);
    List<FindCompositeResult> getCompositeByBookTitle(String title, List<Long> libraryId);
    List<FindCompositeResult> getCompositeBypublisher(String publisher, List<Long> libraryId);
    List<FindCompositeResult> getCompositeByAuthor(String author, List<Long> libraryId);
    List<FindCompositeResult> getCompositeByCategory(String category, List<Long> libraryId);

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
        private final String isbn;
        private final String title;
        private final String thumbNailImage;
        private final String coverImage;
        private final String author;
        private final String translator;
        private final String contents;
        private final String publisher;
        private final LocalDate publishDate;
        private final String bookType;
        private final String genre;
        private final String barcode;
        private final String rfid;
        private final String bookStatus;
        private final String libraryName;
        private final String category;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;


        // Lending Info
        private final Long libraryId;
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
                    .isbn(composite.getIsbn())
                    .title(composite.getTitle())
                    .thumbNailImage(composite.getThumbNailImage())
                    .coverImage(composite.getCoverImage())
                    .author(composite.getAuthor())
                    .translator(composite.getTranslator())
                    .contents(composite.getContents())
                    .publisher(composite.getPublisher())
                    .publishDate(composite.getPublishDate())
                    .bookType(composite.getBookType())
                    .genre(composite.getGenre())
                    .barcode(composite.getBarcode())
                    .rfid(composite.getRfid())
                    .bookStatus(composite.getBookStatus())
                    .libraryName(composite.getLibraryName())
                    .category(composite.getCategory())
                    .updatedAt(composite.getUpdatedAt())
                    .createdAt(composite.getCreatedAt())

                    .libraryId(composite.getLibraryId())
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

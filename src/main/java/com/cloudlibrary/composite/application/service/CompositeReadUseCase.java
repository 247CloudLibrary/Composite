package com.cloudlibrary.composite.application.service;

import com.cloudlibrary.composite.application.domain.Composite;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Component
public interface CompositeReadUseCase {

    List<FindBookResult> getBookListAll();
    FindBookResult getBook(BookFindQuery query);
    FindLendingResult getLending(LendingFindQuery query);

    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Getter
    @ToString
    class BookFindQuery {
        private Long bookId;

        public BookFindQuery(Long bookId) {
            this.bookId = bookId;
        }
    }

    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Getter
    @ToString
    class LendingFindQuery {
        private Long uid;
        private Long bookId;
        private Long libraryId;

        public LendingFindQuery(Long uid, Long bookId, Long libraryId) {
            this.uid = uid;
            this.bookId = bookId;
            this.libraryId = libraryId;
        }
    }


    @Getter
    @ToString
    @Builder
    class FindBookResult {
        private final Long bookId;
        private final String rid;
        private final Long libraryId;
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

        public static FindBookResult findByBook(Composite book) {
            return FindBookResult.builder()
                    .bookId(book.getBookId())
                    .rid(book.getRid())
                    .libraryId(book.getLibraryId())
                    .isbn(book.getIsbn())
                    .title(book.getTitle())
                    .coverImage(book.getCoverImage())
                    .author(book.getAuthor())
                    .translator(book.getTranslator())
                    .contents(book.getContents())
                    .publisher(book.getPublisher())
                    .type(book.getType())
                    .genre(book.getGenre())
                    .barcode(book.getBarcode())
                    .bookStatus(book.getBookStatus())
                    .publishDate(book.getPublishDate())
                    .createdAt(book.getCreatedAt())
                    .updatedAt(book.getUpdatedAt())
                    .rfid(book.getRfid())
                    .category(book.getCategory())
                    .build();
        }
    }

    @Getter
    @ToString
    @Builder
    class FindLendingResult{
        private final long bookId;
        private final long libraryId;
        private final long uid;
        private final String lendingStatus;
        private final LocalDateTime lendingDateTime;
        private final LocalDateTime reservationDateTime;

        public static FindLendingResult findByLending(Composite lending){
            return FindLendingResult.builder()
                    .bookId(lending.getBookId())
                    .libraryId(lending.getLibraryId())
                    .uid(lending.getUid())
                    .lendingStatus(lending.getLendingStatus())
                    .lendingDateTime(lending.getLendingDateTime())
                    .reservationDateTime(lending.getReservationDateTime())
                    .build();
        }
    }

    @Getter
    @ToString
    @Builder
    class FindBookAndLendingResult{
        private final long bookId;
        private final long libraryId;
        private final String libraryName;
        private final String title;
        private final String contents;
        private final String coverImage;
        private final String genre;
        private final String barcode;
        private final String author;
        private final String translator;
        private final String publisher;
        private final LocalDate publishDate;
        private final String lendingStatus;
        private final LocalDateTime lendingDateTime;

        public static FindBookAndLendingResult findByBookAndLending(Composite bookAndLending){
            return FindBookAndLendingResult.builder()
                    .bookId(bookAndLending.getBookId())
                    .libraryId(bookAndLending.getLibraryId())
                    .libraryName(bookAndLending.getLibraryName())
                    .title(bookAndLending.getTitle())
                    .barcode(bookAndLending.getBarcode())
                    .author(bookAndLending.getAuthor())
                    .contents(bookAndLending.getContents())
                    .genre(bookAndLending.getGenre())
                    .coverImage(bookAndLending.getCoverImage())
                    .translator(bookAndLending.getTranslator())
                    .publisher(bookAndLending.getPublisher())
                    .publishDate(bookAndLending.getPublishDate())
                    .lendingStatus(bookAndLending.getLendingStatus())
                    .lendingDateTime(bookAndLending.getLendingDateTime())
                    .build();
        }

    }


}

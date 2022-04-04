package com.cloudlibrary.composite.application.service;

import com.cloudlibrary.composite.application.domain.Composite;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;


@Component
public interface CompositeOperationUseCase {

    List<FindBookResult> getBookListAll();
    FindBookResult getBook(BookFindQuery query);
    FindLendingResult getLending(LendingFindQuery query);

    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Getter
    @ToString
    class BookFindQuery {
        private long bookId;

        public BookFindQuery(long bookId) {
            this.bookId = bookId;
        }
    }

    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Getter
    @ToString
    class LendingFindQuery {
        private long uid;
        private long bookId;
        private long libraryId;

        public LendingFindQuery(long uid, long bookId, long libraryId) {
            this.uid = uid;
            this.bookId = bookId;
            this.libraryId = libraryId;
        }
    }

    @Getter
    @ToString
    @Builder
    class FindBookResult {
        private final long bookId;
        private final String rid;
        private final long libraryId;
        private final String isbn;
        private final String title;
        private final String thumnailImage;
        private final String coverImage;
        private final String author;
        private final String translator;
        private final String contents;
        private final String publisher;
        private final String type;
        private final String genre;
        private final String barcode;
        private final String bookStatus;
        private final Timestamp publishdatetime;
        private final Timestamp lendingAvailableDateTime;
        private final Timestamp createdAt;
        private final Timestamp updatedAt;
        private final String rfid;
        private final String category;

        public static FindBookResult findByBook(Composite book) {
            return FindBookResult.builder()
                    .bookId(book.getBookId())
                    .rid(book.getRid())
                    .libraryId(book.getLibraryId())
                    .isbn(book.getIsbn())
                    .title(book.getTitle())
                    .thumnailImage(book.getThumnailImage())
                    .coverImage(book.getCoverImage())
                    .author(book.getAuthor())
                    .translator(book.getTranslator())
                    .contents(book.getContents())
                    .publisher(book.getPublisher())
                    .type(book.getType())
                    .genre(book.getGenre())
                    .barcode(book.getBarcode())
                    .bookStatus(book.getBookStatus())
                    .publishdatetime(book.getPublishdatetime())
                    .lendingAvailableDateTime(book.getLendingAvailableDateTime())
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
        private final Timestamp lendingDateTime;
        private final Timestamp reservationDateTime;

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

    }


}

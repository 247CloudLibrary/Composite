package com.cloudlibrary.composite.application.service;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CompositeOperationUseCase {

    CompositeReadUseCase.FindCompositeResult createComposite(CompositeCreateCommand command);
    CompositeReadUseCase.FindCompositeResult updateBookStatus(BookStatusUpdateCommand command, Long bookId);
    CompositeReadUseCase.FindCompositeResult updateLendingStatus(LendingStatusUpdateCommand command, Long bookId);
    CompositeReadUseCase.FindCompositeResult updateReservationInfo(ReservationInfoUpdateCommand command, Long bookId);

    CompositeReadUseCase.FindCompositeResult deleteComposite(Long libraryId);

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class CompositeCreateCommand{
        // Book Info
        private final Long bookId;
        private final String rid;
        private final Long libraryId;
        private final String libraryName;
        private final String isbn;
        private final String title;
        private final String thumbNailImage;
        private final String coverImage;
        private final String author;
        private final String translator;
        private final String contents;
        private final String publisher;
        private final String bookType;
        private final String genre;
        private final String barcode;
        private final String bookStatus;
        private final LocalDate publishDate;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;
        private final String rfid;
        private final String category;


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
    }


    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class CompositeUpdateCommand{
        // Book Info
        private final Long bookId;
        private final String rid;
        private final Long libraryId;
        private final String libraryName;
        private final String isbn;
        private final String title;
        private final String thumbNailImage;
        private final String coverImage;
        private final String author;
        private final String translator;
        private final String contents;
        private final String publisher;
        private final String bookType;
        private final String genre;
        private final String barcode;
        private final String bookStatus;
        private final LocalDate publishDate;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;
        private final String rfid;
        private final String category;


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
    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class BookStatusUpdateCommand{
        private final String bookStatus;
    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class LendingStatusUpdateCommand{
        private final String lendingStatus;
    }

    @EqualsAndHashCode(callSuper = false)
    @Builder
    @Getter
    @ToString
    class ReservationInfoUpdateCommand{
        private final Long orderNum;

        private final Long lendingId;
        private final Long uid;
        private final Long bookId;
        private final Long libraryId;
        private final String libraryName;
        private final LocalDateTime reservationDateTime;
        private final LocalDateTime cancelDateTime;
    }

}

package com.cloudlibrary.composite.application.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class CompositeServiceTest {

    @Autowired
    CompositeService compositeService;


    @Test
    @Order(1)
    @DisplayName("컴포짓 생성 테스트")
    public void createCompositeTest() throws Exception
    {
        //given
        var composite1 = CompositeOperationUseCase.CompositeCreateCommand.builder()
                .bookId(1L)
                .libraryName("command.getLibraryName")
                .rid("command.getRid()")
                .libraryName("command.getLibraryName()")
                .isbn("command.getIsbn()")
                .title("command.getTitle()")
                .thumbNailImage("command.getThumbnailImage()")
                .coverImage("command.getCoverImage()")
                .author("command.getAuthor()")
                .translator("command.getTranslator()")
                .contents("command.getContents()")
                .publisher("command.getPublisher()")
                .bookType("command.getBookType()")
                .genre("command.getGenre()")
                .barcode("command.getBarcode()")
                .bookStatus("command.getBookStatus()")
                .publishDate(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .rfid("command.getRfid()")
                .category("command.getCategory()")
                .build();

        var composite2 = CompositeOperationUseCase.CompositeCreateCommand.builder()
                .bookId(2L)
                .libraryName("getLibraryName")
                .rid("getRid()")
                .libraryName("getLibraryName()")
                .isbn("getIsbn()")
                .title("getTitle()")
                .thumbNailImage("getThumbnailImage()")
                .coverImage("getCoverImage()")
                .author("getAuthor()")
                .translator("getTranslator()")
                .contents("getContents()")
                .publisher("getPublisher()")
                .bookType("getBookType()")
                .genre("getGenre()")
                .barcode("getBarcode()")
                .bookStatus("getBookStatus()")
                .publishDate(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .rfid("getRfid()")
                .category("getCategory()")
                .build();
        //when
        var compositeResult1 = compositeService.createComposite(composite1);
        var compositeResult2 = compositeService.createComposite(composite2);
        //then
    }

    @Test
    @Order(2)
    @DisplayName("컴포짓 조회")
    public void getCompositeByBookIdTest() throws Exception
    {
        //given

        //when
        var composite = compositeService.getCompositeByBookId(new CompositeReadUseCase.BookFindQuery(1L));
        //then
        assertThat(composite.getBookId()).isEqualTo(1L);
        System.out.println("composite = " + composite);

    }

    @Test
    @Order(3)
    @DisplayName("컴포짓 리스트 조회 테스트")
    public void getCompositeListAllTest() throws Exception
    {
        //given

        //when
        var compositeListAll = compositeService.getCompositeListAll();
        //then
        for (CompositeReadUseCase.FindCompositeResult findCompositeResult : compositeListAll) {
            System.out.println("findCompositeResult = " + findCompositeResult);
        }
    }

    @Test
    @Order(4)
    @DisplayName("BookStatus 업데이트 테스트")
    public void updateBookStatusTest() throws Exception
    {
        //given
        var command = CompositeOperationUseCase.BookStatusUpdateCommand.builder()
                .bookStatus("불가")
                .build();
        //when
        var reuslt = compositeService.updateBookStatus(command, 1L);
        //then
        assertThat(compositeService.getCompositeByBookId(new CompositeReadUseCase.BookFindQuery(1L)).getBookStatus()).isEqualTo("불가");
    }

    @Test
    @Order(5)
    @DisplayName("LendingStatus 업데이트 테스트")
    public void updateLendingStatusTest() throws Exception
    {
        //given
        var command = CompositeOperationUseCase.LendingStatusUpdateCommand.builder()
                .lendingStatus("대출 중")
                .build();

        //when
        var result = compositeService.updateLendingStatus(command, 1L);
        //then
        assertThat(compositeService.getCompositeByBookId(new CompositeReadUseCase.BookFindQuery(1L)).getLendingStatus()).isEqualTo("대출 중");
    }

    @Test
    @Order(6)
    @DisplayName("예약 등록 테스트")
    public void updateReservationInfoTest() throws Exception
    {
        //given
        var command = CompositeOperationUseCase.ReservationInfoUpdateCommand.builder()
                .orderNum(1L)
                .lendingId(1L)
                .uid(2L)
                .bookId(2L)
                .libraryId(1L)
                .libraryName("테스트")
                .reservationDateTime(LocalDateTime.now())
                .cancelDateTime(LocalDateTime.now())
                .build();
        //when
        var result = compositeService.updateReservationInfo(command, 1L);
        //then
        System.out.println(compositeService.getCompositeByBookId(new CompositeReadUseCase.BookFindQuery(1L)));
    }


    @Test
    @Order(7)
    @DisplayName("책 이름으로 조회 테스트")
    public void getCompositeByBookTitleTest() throws Exception
    {
        //given
        List<Long> libraryId = new ArrayList();
        libraryId.add(1L);
        //when
        var result = compositeService.getCompositeByBookTitle("테스트 책 도서", libraryId);
        //then
        for (CompositeReadUseCase.FindCompositeResult findCompositeResult : result) {
            System.out.println("findCompositeResult = " + findCompositeResult);
        }
    }
}
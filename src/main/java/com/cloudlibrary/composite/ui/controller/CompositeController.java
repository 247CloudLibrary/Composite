package com.cloudlibrary.composite.ui.controller;

import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.application.service.CompositeOperationUseCase;
import com.cloudlibrary.composite.application.service.CompositeReadUseCase;
import com.cloudlibrary.composite.application.service.CompositeService;
import com.cloudlibrary.composite.ui.requestbody.BookStatusUpdateRequest;
import com.cloudlibrary.composite.ui.requestbody.CompositeCreateRequest;
import com.cloudlibrary.composite.ui.requestbody.LendingStatusUpdateRequest;
import com.cloudlibrary.composite.ui.requestbody.ReservationUpdateRequest;
import com.cloudlibrary.composite.ui.view.ApiResponseView;
import com.cloudlibrary.composite.ui.view.composite.CompositeCompactView;
import com.cloudlibrary.composite.ui.view.composite.CompositeView;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@Api("컴포짓 API")
@RequestMapping("/v1/composite")
public class CompositeController {

    private CompositeService compositeService;

    @Autowired
    public CompositeController(CompositeService compositeService) {
        this.compositeService = compositeService;
    }


    @GetMapping("/health-check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("health-check");
    }



    // TODO : POST 책 등록
    @PostMapping("")
    public ResponseEntity<ApiResponseView<CompositeView>> createComposite(@RequestBody CompositeCreateRequest request){

        var command = CompositeOperationUseCase.CompositeCreateCommand.builder()
                .bookId(request.getBookId())
                .rid(request.getRid())
                .libraryId(request.getLibraryId())
                .libraryName(request.getLibraryName())
                .isbn(request.getIsbn())
                .title(request.getTitle())
                .thumbNailImage(request.getThumbNailImage())
                .coverImage(request.getCoverImage())
                .author(request.getAuthor())
                .translator(request.getTranslator())
                .contents(request.getContents())
                .publisher(request.getPublisher())
                .bookType(request.getBookType())
                .genre(request.getGenre())
                .barcode(request.getBarcode())
                .bookStatus(request.getBookStatus())
                .publishDate(request.getPublishDate())
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdatedAt())
                .rfid(request.getRfid())
                .category(request.getCategory())
                .lendingId(request.getLendingId())
                .uid(request.getUid())
                .lendingStatus(request.getLendingStatus())
                .lendingDateTime(request.getLendingDateTime())
                .returnDateTime(request.getReturnDateTime())
                .reservationDateTime(request.getReservationDateTime())
                .build();

        var reuslt = compositeService.createComposite(command);


        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(reuslt)));
    }

    // TODO : PATCH 분실 등록
    @PatchMapping("/bookstatus/{bookId}")
    public ResponseEntity<ApiResponseView<CompositeView>> updateBookStatus(@RequestBody BookStatusUpdateRequest request, @PathVariable("bookId") Long bookId){

        var command = CompositeOperationUseCase.BookStatusUpdateCommand.builder()
                .bookStatus(request.getBookStatus())
                .build();

        var result = compositeService.updateBookStatus(command, bookId);

        // TODO: 2022/04/21 예외처리


        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(result)));
    }

    // TODO : PATCH 대출/반납/연체 lendingStatus 변경
    @PatchMapping("/lending/{bookId}")
    public ResponseEntity<ApiResponseView<CompositeView>> updateLendingStatus(@RequestBody LendingStatusUpdateRequest request, @PathVariable("bookId") Long bookId){

        var command = CompositeOperationUseCase.LendingStatusUpdateCommand.builder()
                .lendingStatus(request.getLendingStatus())
                .build();

        var result = compositeService.updateLendingStatus(command, bookId);
        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(result)));
    }

    // TODO : PATCH 예약
    @PatchMapping("/reservation")
    public ResponseEntity<ApiResponseView<CompositeView>> updateReservationInfo(@RequestBody ReservationUpdateRequest request, Long bookId){

        var command = CompositeOperationUseCase.ReservationInfoUpdateCommand.builder()
                .orderNum(request.getOrderNum())
                .lendingId(request.getLendingId())
                .uid(request.getUid())
                .bookId(request.getBookId())
                .libraryId(request.getLibraryId())
                .libraryName(request.getLibraryName())
                .reservationDateTime(request.getReservationDateTime())
                .cancelDateTime(request.getCancelDateTime())
                .build();

        var result = compositeService.updateReservationInfo(command, bookId);

        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(result)));
    }

    // TODO : 도서 리스트 조회
    @GetMapping("/search")
    public ResponseEntity<ApiResponseView<List<CompositeCompactView>>> getComposite(@RequestParam("keyword") String keyword, @RequestParam("libraryArr") List<Long> libraryId,
                                                       @RequestParam ("publisher") String publisher, @RequestParam("author") String author,
                                                       @RequestParam ("category") String category){
        List<Composite> compositeList = new ArrayList<>();




        // 임시 composite 정보 도서관 5개 각각 10개 생성 총 50개
        for (long i=1L; i<=5; ++i){
            for(long j=1L; j<=10; ++j){
                Composite build =Composite.builder()
                        .bookId(j)
                        .libraryId(i)
                        .libraryName("도서관 " + i)
                        .title("테스트 도서 " + j)
                        .barcode("임시 바코드 " + i + 10)
                        .author("작가 " + j + 10)
                        .translator("번역가 " + j + 10)
                        .contents("이 책은 테스트용 입니다. query parameter를 통해 전달 받은 책 id 는 " + i + 10 + "입니다.")
                        .genre("테스트 장르 " + j + 10)
                        .thumbNailImage("썸네일 이미지 임시 경로 " + j + 10)
                        .coverImage("커버 이미지 임시 경로 " + j + 10)
                        .publisher("출판사 " + j + 10)
                        .publishDate(LocalDate.now())
                        .lendingStatus("대출 가능 " + j + 10)
                        .category("800")
                        .bookType("테스트 도서 타입" + j + 10)
                        .lendingDateTime(LocalDateTime.now())
                        .build();
                compositeList.add(build);
            }

        }

        // bookId 기준으로 정렬 해서 List<FindBookAndLendingResult> 만들기
        List<CompositeCompactView> compositeCompactViews = new ArrayList<>();
        for (Composite composite : compositeList) {
            compositeCompactViews.add(new CompositeCompactView(composite));
        }
        return ResponseEntity.ok(new ApiResponseView<>(compositeCompactViews));

    }


    // TODO : 단일 도서 조회
    @GetMapping("/{bookId}")
    public ResponseEntity<ApiResponseView<CompositeCompactView>> getComposite(@PathVariable("bookId") Long bookId){

        var query = new CompositeReadUseCase.BookFindQuery(bookId);

        var compositeByBookId = compositeService.getCompositeByBookId(query);

        var composite = Composite.builder()
                    .bookId(compositeByBookId.getBookId())
                    .libraryId(compositeByBookId.getLibraryId())
                    .libraryName(compositeByBookId.getLibraryName())
                    .barcode(compositeByBookId.getBarcode())
                    .title(compositeByBookId.getTitle())
                    .thumbNailImage(compositeByBookId.getThumbNailImage())
                    .coverImage(compositeByBookId.getCoverImage())
                    .author(compositeByBookId.getAuthor())
                    .translator(compositeByBookId.getTranslator())
                    .contents(compositeByBookId.getContents())
                    .publisher(compositeByBookId.getPublisher())
                    .publishDate(compositeByBookId.getPublishDate())
                    .genre(compositeByBookId.getGenre())
                    .lendingStatus(compositeByBookId.getLendingStatus())
                    .lendingDateTime(compositeByBookId.getLendingDateTime())
                    .category(compositeByBookId.getCategory())
                    .bookType(compositeByBookId.getBookType())
                    .build();

        // TODO: 2022/04/21 예외처리

        return ResponseEntity.ok(new ApiResponseView<>(new CompositeCompactView(composite)));
    }

}

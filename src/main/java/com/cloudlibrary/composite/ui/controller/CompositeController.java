package com.cloudlibrary.composite.ui.controller;

import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.ui.view.ApiResponseView;
import com.cloudlibrary.composite.ui.view.composite.CompositeCompactView;
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



    // TODO : POST 책 등록

    // TODO : PATCH 분실 등록

    // TODO : PATCH 대출/반납/연체 lendingStatus 변경

    // TODO : PATCH 예약

    // TODO : 도서 리스트 조회
    @GetMapping("/search")
    public ResponseEntity<ApiResponseView<List<CompositeCompactView>>> getComposite(@RequestParam("keyword") String keyword, @RequestParam("libraryArr") List<Long> libraryId,
                                                       @RequestParam ("publisher") String publisher, @RequestParam("author") String author,
                                                       @RequestParam ("category") String category){
        List<Composite> compositeList = new ArrayList<>();

        // 임시 composite 정보 도서관 5개 각각 10개 생성 총 50개
        for (int i=1; i<=5; ++i){
            for(int j=1; j<=10; ++j){
                Composite build =Composite.builder()
                        .bookId(j + 10L)
                        .libraryId(i + 1000L)
                        .libraryName("도서관 " + i)
                        .title("테스트 도서 " + j)
                        .barcode("임시 바코드 " + i + 10)
                        .author("작가 " + j + 10)
                        .translator("번역가 " + j + 10)
                        .contents("이 책은 테스트용 입니다. query parameter를 통해 전달 받은 책 id 는 " + i + 10 + "입니다.")
                        .genre("테스트 장르 " + j + 10)
                        .thumbnailImage("썸네일 이미지 임시 경로 " + j + 10)
                        .coverImage("커버 이미지 임시 경로 " + j + 10)
                        .publisher("출판사 " + j + 10)
                        .publishDate(LocalDate.now())
                        .lendingStatus("대출 가능 " + j + 10)
                        .category("테스트 카테고리" + j + 10)
                        .type("테스트 도서 타입" + j + 10)
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
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseView<CompositeCompactView>> getComposite(@PathVariable("id") Long id){

        // 임시 생성
        Composite comp = Composite.builder()
                .bookId(id)
                .libraryId(id + 1000L)
                .libraryName("test " + id)
                .title("임시 데이터 bookId = " + id)
                .barcode("임시 바코드 " + id)
                .author("작가 " + id)
                .translator("번역가 " + id)
                .contents("이 책은 테스트용 입니다. query parameter를 통해 전달 받은 책 id 는 " + id + "입니다.")
                .genre("테스트 장르 " + id)
                .thumbnailImage("썸네일 이미지 임시 경로 " + id)
                .coverImage("커버 이미지 임시 경로 " + id)
                .publisher("출판사 " + id)
                .publishDate(LocalDate.now())
                .lendingStatus("대출 가능 " + id)
                .category("테스트 카테고리" + id)
                .type("테스트 도서 타입" + id)
                .lendingDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(new ApiResponseView<>(new CompositeCompactView(comp)));
    }

}

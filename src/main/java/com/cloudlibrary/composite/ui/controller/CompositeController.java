package com.cloudlibrary.composite.ui.controller;

import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.application.service.CompositeOperationUseCase;
import com.cloudlibrary.composite.application.service.CompositeReadUseCase;
import com.cloudlibrary.composite.ui.view.CompositeView;
import io.swagger.annotations.Api;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@RestController
@Api("컴포짓 API")
@RequestMapping("/composite")
public class CompositeController {
    private final CompositeReadUseCase compositeReadUseCase;
    private final CompositeOperationUseCase compositeOperationUseCase;

    @Autowired
    public CompositeController(CompositeReadUseCase compositeReadUseCase, CompositeOperationUseCase compositeOperationUseCase) {
        this.compositeReadUseCase = compositeReadUseCase;
        this.compositeOperationUseCase = compositeOperationUseCase;
    }


    // TODO : POST 책 등록

    // TODO : PATCH 분실 등록

    // TODO : PATCH 대출/반납/연체 lendingStatus 변경

    // TODO : PATCH 예약

    // TODO : 단일 도서 조회
    @GetMapping("/lending/{id}")
    public ResponseEntity<CompositeView> getComposite(@PathVariable("id") long id){

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
                .coverImage("커버 이미지 임시 경로 " + id)
                .publisher("출판사 " + id)
                .publishDate(LocalDate.now())
                .lendingStatus("대출 가능 " + id)
                .lendingDateTime(LocalDateTime.now())
                .build();



        return ResponseEntity.ok(new CompositeView(CompositeReadUseCase.FindBookAndLendingResult.findByBookAndLending(comp)));
    }

}

package com.cloudlibrary.composite.ui.controller;

import com.cloudlibrary.composite.application.service.CompositeOperationReadCase;
import com.cloudlibrary.composite.application.service.CompositeOperationUseCase;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api("컴포짓 API")
@RequestMapping("/composite")
public class CompositeController {
    private final CompositeOperationUseCase compositeOperationUseCase;
    private final CompositeOperationReadCase compositeOperationReadCase;

    @Autowired
    public CompositeController(CompositeOperationUseCase compositeOperationUseCase,
                               CompositeOperationReadCase compositeOperationReadCase) {
        this.compositeOperationUseCase = compositeOperationUseCase;
        this.compositeOperationReadCase = compositeOperationReadCase;
    }

    // TODO : POST 책 등록

    // TODO : PATCH 분실 등록

    // TODO : PATCH 대출/반납/연체 lendingstatus 변경

    // TODO : PATCH 예약
}

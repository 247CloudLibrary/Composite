package com.cloudlibrary.composite.ui.controller;

import com.amazonaws.util.StringUtils;
import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.application.service.CompositeOperationUseCase;
import com.cloudlibrary.composite.application.service.CompositeReadUseCase;
import com.cloudlibrary.composite.application.service.CompositeService;
import com.cloudlibrary.composite.exception.CloudLibraryException;
import com.cloudlibrary.composite.exception.MessageType;
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
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Api("컴포짓 API")
@CrossOrigin(origins = "*")
@RequestMapping("/v1/composite")
public class CompositeController {

    private final CompositeService compositeService;

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
                .bookId(request.getId())
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

        var result = compositeService.createComposite(command);

        if(result.getBookId() == -1L){
            throw new CloudLibraryException(MessageType.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(result)));
    }


    @PutMapping("/bookstatus/{bookId}")
    public ResponseEntity<ApiResponseView<CompositeView>> updateBookStatus(@RequestBody BookStatusUpdateRequest request, @PathVariable("bookId") Long bookId){

        var command = CompositeOperationUseCase.BookStatusUpdateCommand.builder()
                .bookStatus(request.getBookStatus())
                .build();

        var result = compositeService.updateBookStatus(command, bookId);


        if(result.getBookId() == -1L){
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(result)));
    }


    @PutMapping("/lending/{bookId}")
    public ResponseEntity<ApiResponseView<CompositeView>> updateLendingStatus(@RequestBody LendingStatusUpdateRequest request, @PathVariable("bookId") Long bookId){

        var command = CompositeOperationUseCase.LendingStatusUpdateCommand.builder()
                .lendingStatus(request.getLendingStatus())
                .build();

        var result = compositeService.updateLendingStatus(command, bookId);

        if(result.getBookId() == -1L){
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(result)));
    }


    @PutMapping("/reservation")
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

        if(result.getBookId() == -1L){
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(result)));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponseView<List<CompositeView>>> getComposite(@RequestParam(value = "bookTitle", required = false) String bookTitle, @RequestParam(value = "libraryArr", required = false) List<Long> libraryId,
                                                       @RequestParam (value = "publisher", required = false) String publisher, @RequestParam(value = "author", required = false) String author,
                                                       @RequestParam (value = "category", required = false) String category){

        List<CompositeReadUseCase.FindCompositeResult> results = null;

        if(bookTitle != null && (!bookTitle.isEmpty())){
            results = compositeService.getCompositeByBookTitle(bookTitle, libraryId);
        }

        if(publisher != null && (!publisher.isEmpty())){
            results = compositeService.getCompositeBypublisher(publisher, libraryId);
        }

        if(author != null && !(author.isEmpty())){
            results = compositeService.getCompositeByAuthor(author, libraryId);
        }

        if(category != null && !(category.isEmpty())){
            results = compositeService.getCompositeByCategory(category, libraryId);
        }

        if(results == null){
            results = compositeService.getCompositeListAll();
        }

        if(results.isEmpty()){
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        var views = results.stream().map(CompositeView::new).collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponseView<>(views));

    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ApiResponseView<CompositeView>> getComposite(@PathVariable("bookId") Long bookId){

        var query = new CompositeReadUseCase.BookFindQuery(bookId);

        var result = compositeService.getCompositeByBookId(query);

        if(result.getBookId() == -1L){
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(result)));
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<ApiResponseView<CompositeView>> deleteComposite(@PathVariable("libraryId") Long libraryId){


        var result = compositeService.deleteComposite(libraryId);

        if(result.getBookId() == -1L){
            throw new CloudLibraryException(MessageType.BAD_REQUEST);
        }

        return ResponseEntity.ok(new ApiResponseView<>(new CompositeView(result)));
    }
}

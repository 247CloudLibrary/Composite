package com.cloudlibrary.composite.infrastructure.mysql.repository;

import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
class CompositeEntityRepositoryImplTest {

    @Autowired
    CompositeEntityRepository compositeEntityRepository;

    @Test
    public void findCompositeByBookId(){
        //given
        Composite newComposite = Composite.builder()
                .bookId(1L)
                .libraryId(1L)
                .rid("this.rid")
                .libraryName("this.libraryName")
                .isbn("this.isbn")
                .title("this.title")
                .thumbnailImage("this.thumbnailImage")
                .coverImage("this.coverImage")
                .author("this.author")
                .translator("this.translator")
                .contents("this.contents")
                .publisher("this.publisher")
                .type("this.type")
                .genre("this.genre")
                .barcode("this.barcode")
                .bookStatus("this.bookStatus")
                .publishDate(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .rfid("this.rfid")
                .category(802L)
                .lendingId(1L)
                .uid(1L)
                .lendingStatus("this.lendingStatus")
                .lendingDateTime(LocalDateTime.now())
                .returnDateTime(LocalDateTime.now())
                .reservationDateTime(LocalDateTime.now())
                .orderNum(1L)
                .cancelDateTime(LocalDateTime.now())
                .build();

        //when
        Optional<CompositeEntity> compositeEntity = compositeEntityRepository.saveComposite(new CompositeEntity(newComposite));

        //then
        assertThat(compositeEntityRepository.findCompositeByBookId(1L).get().toComposite().toString())
                .isEqualTo(newComposite.toString());

    }

    @Test
    public void findCompositeAll(){
        Composite newComposite1 = Composite.builder()
                .bookId(1L)
                .libraryId(1L)
                .rid("this.rid")
                .libraryName("this.libraryName")
                .isbn("this.isbn")
                .title("this.title")
                .thumbnailImage("this.thumbnailImage")
                .coverImage("this.coverImage")
                .author("this.author")
                .translator("this.translator")
                .contents("this.contents")
                .publisher("this.publisher")
                .type("this.type")
                .genre("this.genre")
                .barcode("this.barcode")
                .bookStatus("this.bookStatus")
                .publishDate(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .rfid("this.rfid")
                .category(802L)
                .lendingId(1L)
                .uid(1L)
                .lendingStatus("this.lendingStatus")
                .lendingDateTime(LocalDateTime.now())
                .returnDateTime(LocalDateTime.now())
                .reservationDateTime(LocalDateTime.now())
                .orderNum(1L)
                .cancelDateTime(LocalDateTime.now())
                .build();

        var newComposite2 = Composite.builder()
                .bookId(2L)
                .libraryId(2L)
                .rid("this.rid")
                .libraryName("this.libraryName")
                .isbn("this.isbn")
                .title("this.title")
                .thumbnailImage("this.thumbnailImage")
                .coverImage("this.coverImage")
                .author("this.author")
                .translator("this.translator")
                .contents("this.contents")
                .publisher("this.publisher")
                .type("this.type")
                .genre("this.genre")
                .barcode("this.barcode")
                .bookStatus("this.bookStatus")
                .publishDate(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .rfid("this.rfid")
                .category(802L)
                .lendingId(1L)
                .uid(1L)
                .lendingStatus("this.lendingStatus")
                .lendingDateTime(LocalDateTime.now())
                .returnDateTime(LocalDateTime.now())
                .reservationDateTime(LocalDateTime.now())
                .orderNum(1L)
                .cancelDateTime(LocalDateTime.now())
                .build();


        Optional<CompositeEntity> compositeEntity1 = compositeEntityRepository.saveComposite(new CompositeEntity(newComposite1));
        Optional<CompositeEntity> compositeEntity2 = compositeEntityRepository.saveComposite(new CompositeEntity(newComposite2));

        List<CompositeEntity> compositeAll = compositeEntityRepository.findCompositeAll();
        for (CompositeEntity compositeEntity : compositeAll) {
            System.out.println("compositeEntity = " + compositeEntity);
        }
    }








}
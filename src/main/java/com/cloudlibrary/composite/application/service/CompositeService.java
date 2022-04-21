package com.cloudlibrary.composite.application.service;

import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.application.mapper.MapperForPatch;
import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import com.cloudlibrary.composite.infrastructure.mysql.repository.CompositeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class CompositeService implements CompositeReadUseCase, CompositeOperationUseCase{

    private CompositeEntityRepository compositeEntityRepository;
    private MapperForPatch mapperForPatch;

    @Autowired
    public CompositeService(CompositeEntityRepository compositeEntityRepository, MapperForPatch mapperForPatch) {
        this.compositeEntityRepository = compositeEntityRepository;
        this.mapperForPatch = mapperForPatch;
    }

    @Override
    public FindCompositeResult createComposite(CompositeCreateCommand command) {

        var composite = Composite.builder()
                .bookId(command.getBookId())
                .rid(command.getRid())
                .libraryId(command.getLibraryId())
                .libraryName(command.getLibraryName())
                .isbn(command.getIsbn())
                .title(command.getTitle())
                .thumbNailImage(command.getThumbNailImage())
                .coverImage(command.getCoverImage())
                .author(command.getAuthor())
                .translator(command.getTranslator())
                .contents(command.getContents())
                .publisher(command.getPublisher())
                .bookType(command.getBookType())
                .genre(command.getGenre())
                .barcode(command.getBarcode())
                .bookStatus(command.getBookStatus())
                .publishDate(command.getPublishDate())
                .createdAt(command.getCreatedAt())
                .updatedAt(command.getUpdatedAt())
                .rfid(command.getRfid())
                .category(command.getCategory())
                .lendingId(command.getLendingId())
                .uid(command.getUid())
                .lendingStatus(command.getLendingStatus())
                .lendingDateTime(command.getLendingDateTime())
                .returnDateTime(command.getReturnDateTime())
                .reservationDateTime(command.getReservationDateTime())
                .build();

        var compositeEntity = new CompositeEntity(composite);
        var result = compositeEntityRepository.save(compositeEntity);

        return FindCompositeResult.findByComposite(result.toComposite());

    }

    @Override
    public FindCompositeResult getCompositeByBookId(BookFindQuery query) {

        var compositeEntity = compositeEntityRepository.findById(query.getBookId());

        if(compositeEntity.isPresent()){
            return FindCompositeResult.findByComposite(compositeEntity.get().toComposite());
        }


        // TODO: 2022/04/21 예외처리
        return null;
    }

    @Override
    public List<FindCompositeResult> getCompositeListAll() {

        var compositeEntities = compositeEntityRepository.findAll();

        var composites = StreamSupport.stream(compositeEntities.spliterator(), false)
                .map(CompositeEntity::toComposite)
                .collect(Collectors.toList());

        if(composites.isEmpty()){
            return null;
        }

        return composites.stream().map(FindCompositeResult::findByComposite).collect(Collectors.toList());
    }

    @Override
    public FindCompositeResult updateBookStatus(BookStatusUpdateCommand command, Long bookId) {


        var compositeEntity = compositeEntityRepository.findById(bookId);
        if(compositeEntity.isPresent()){
            compositeEntity.get().setBookStatus(command.getBookStatus());
            compositeEntityRepository.save(compositeEntity.get());
        }

        // TODO: 2022/04/21 예외처리
        return null;
    }

    @Override
    public FindCompositeResult updateLendingStatus(LendingStatusUpdateCommand command, Long bookId) {

        var compositeEntity = compositeEntityRepository.findById(bookId);
        if(compositeEntity.isPresent()){
            compositeEntity.get().setLendingStatus(command.getLendingStatus());
            compositeEntityRepository.save(compositeEntity.get());
        }

        // TODO: 2022/04/21 예외처리
        return null;
    }

    @Override
    public FindCompositeResult updateReservationInfo(ReservationInfoUpdateCommand command, Long bookId) {

        var compositeEntity = compositeEntityRepository.findById(bookId);
        if(compositeEntity.isPresent()){

            compositeEntity.get().setOrderNum(command.getOrderNum());
            compositeEntity.get().setLendingId(command.getLendingId());
            compositeEntity.get().setUid(command.getUid());
            compositeEntity.get().setBookId(command.getBookId());
            compositeEntity.get().setLibraryId(command.getLibraryId());
            compositeEntity.get().setLibraryName(command.getLibraryName());
            compositeEntity.get().setReservationDateTime(command.getReservationDateTime());
            compositeEntity.get().setCancelDateTime(command.getCancelDateTime());

            compositeEntityRepository.save(compositeEntity.get());
        }

        // TODO: 2022/04/21 예외처리
        return null;

    }

}

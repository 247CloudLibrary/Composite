package com.cloudlibrary.composite.application.service;

import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.application.mapper.MapperForService;
import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import com.cloudlibrary.composite.infrastructure.mysql.repository.CompositeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class CompositeService implements CompositeReadUseCase, CompositeOperationUseCase{

    private CompositeEntityRepository compositeEntityRepository;
    private MapperForService mapperForService;

    @Autowired
    public CompositeService(CompositeEntityRepository compositeEntityRepository, MapperForService mapperForService) {
        this.compositeEntityRepository = compositeEntityRepository;
        this.mapperForService = mapperForService;
    }

    @Override
    public FindCompositeResult createComposite(CompositeCreateCommand command) {

        var query = new BookFindQuery(command.getBookId());

        var findCompositeEntity = compositeEntityRepository.findById(query.getBookId());


        // update
        if(findCompositeEntity.isPresent()){
            mapperForService.updateBookFromCompositeEntity(command, findCompositeEntity.get());
            compositeEntityRepository.save(findCompositeEntity.get());

            return FindCompositeResult.findByComposite(findCompositeEntity.get().toComposite());
        }
        else{
            // create
            var newCompositeEntity = new CompositeEntity();

            mapperForService.createBookToCompositeEntity(command, newCompositeEntity);
            var result = compositeEntityRepository.save(newCompositeEntity);

            return FindCompositeResult.findByComposite(result.toComposite());
        }




    }

    @Override
    public FindCompositeResult getCompositeByBookId(BookFindQuery query) {

        var compositeEntity = compositeEntityRepository.findById(query.getBookId());

        if(compositeEntity.isPresent()){
            return FindCompositeResult.findByComposite(compositeEntity.get().toComposite());
        }

        return notFoundComposite();
    }

    @Override
    public List<FindCompositeResult> getCompositeListAll() {

        var compositeEntities = compositeEntityRepository.findAll();

        var composites = StreamSupport.stream(compositeEntities.spliterator(), false)
                .map(CompositeEntity::toComposite)
                .collect(Collectors.toList());


        return composites.stream().map(FindCompositeResult::findByComposite).collect(Collectors.toList());
    }


    @Override
    public List<FindCompositeResult> getCompositeByBookTitle(String title, List<Long> libraryId) {

        List<CompositeEntity> result;

        if(libraryId.isEmpty()){
            result = compositeEntityRepository.findAllByTitle(title);
        }
        else{
            result = compositeEntityRepository.findAllByTitleAndLibraryIdIn(title, libraryId);
        }

        List<Composite> compositeList = result.stream().map(CompositeEntity::toComposite).collect(Collectors.toList());

        return compositeList.stream().map(FindCompositeResult::findByComposite).collect(Collectors.toList());
    }

    @Override
    public List<FindCompositeResult> getCompositeBypublisher(String publisher, List<Long> libraryId) {

        List<CompositeEntity> result;

        if(libraryId.isEmpty()){
            result = compositeEntityRepository.findAllByPublisher(publisher);
        }
        else{
            result = compositeEntityRepository.findAllByPublisherAndLibraryIdIn(publisher, libraryId);
        }

        List<Composite> compositeList = result.stream().map(CompositeEntity::toComposite).collect(Collectors.toList());

        return compositeList.stream().map(FindCompositeResult::findByComposite).collect(Collectors.toList());
    }

    @Override
    public List<FindCompositeResult> getCompositeByAuthor(String author, List<Long> libraryId) {
        List<CompositeEntity> result;

        if(libraryId.isEmpty()){
            result = compositeEntityRepository.findAllByAuthor(author);
        }
        else{
            result = compositeEntityRepository.findAllByAuthorAndLibraryIdIn(author, libraryId);
        }

        List<Composite> compositeList = result.stream().map(CompositeEntity::toComposite).collect(Collectors.toList());

        return compositeList.stream().map(FindCompositeResult::findByComposite).collect(Collectors.toList());
    }

    @Override
    public List<FindCompositeResult> getCompositeByCategory(String category, List<Long> libraryId) {

        List<CompositeEntity> result;

        if(libraryId.isEmpty()){
            result = compositeEntityRepository.findAllByCategory(category);
        }
        else{
            result = compositeEntityRepository.findAllByCategoryAndLibraryIdIn(category, libraryId);
        }

        List<Composite> compositeList = result.stream().map(CompositeEntity::toComposite).collect(Collectors.toList());

        return compositeList.stream().map(FindCompositeResult::findByComposite).collect(Collectors.toList());

    }




    @Override
    public FindCompositeResult updateBookStatus(BookStatusUpdateCommand command, Long bookId) {


        var compositeEntity = compositeEntityRepository.findById(bookId);
        if(compositeEntity.isPresent()){
            mapperForService.updateBookStatusFromCompositeEntity(command, compositeEntity.get());
            compositeEntityRepository.save(compositeEntity.get());
            return FindCompositeResult.findByComposite(compositeEntity.get().toComposite());
        }


        return notFoundComposite();
    }

    @Override
    public FindCompositeResult updateLendingStatus(LendingStatusUpdateCommand command, Long bookId) {

        var compositeEntity = compositeEntityRepository.findById(bookId);
        if(compositeEntity.isPresent()){
            mapperForService.updateLendingStatusFromCompoisteEntity(command, compositeEntity.get());
            compositeEntityRepository.save(compositeEntity.get());
            return FindCompositeResult.findByComposite(compositeEntity.get().toComposite());
        }


        return notFoundComposite();
    }

    @Override
    public FindCompositeResult updateReservationInfo(ReservationInfoUpdateCommand command, Long bookId) {

        var compositeEntity = compositeEntityRepository.findById(bookId);
        if(compositeEntity.isPresent()){

            mapperForService.updateReservationInfoFromCompositeEntity(command, compositeEntity.get());
            compositeEntityRepository.save(compositeEntity.get());
            return FindCompositeResult.findByComposite(compositeEntity.get().toComposite());
        }


        return notFoundComposite();

    }


    private FindCompositeResult notFoundComposite() {
        return FindCompositeResult.findByComposite(Composite.builder()
                .bookId(-1L)
                .build());
    }

}

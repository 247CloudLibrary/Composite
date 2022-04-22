package com.cloudlibrary.composite.infrastructure.mysql.repository;

import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CompositeEntityRepository extends JpaRepository<CompositeEntity, Long> {


    Optional<CompositeEntity> findByBookId(Long BookId);

    List<CompositeEntity> findAllByTitle(String title);
    List<CompositeEntity> findAllByTitleAndLibraryIdIn(String title, List<Long> libraryId);

    List<CompositeEntity> findAllByPublisherAndLibraryIdIn(String publisher, List<Long> libraryId);
    List<CompositeEntity> findAllByPublisher(String publisher);

    List<CompositeEntity> findAllByCategoryAndLibraryIdIn(String category, List<Long> libraryId);
    List<CompositeEntity> findAllByCategory(String category);

    List<CompositeEntity> findAllByAuthorAndLibraryIdIn(String author, List<Long> libraryId);
    List<CompositeEntity> findAllByAuthor(String author);
}

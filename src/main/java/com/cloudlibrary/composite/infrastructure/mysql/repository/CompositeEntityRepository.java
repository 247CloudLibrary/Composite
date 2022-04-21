package com.cloudlibrary.composite.infrastructure.mysql.repository;

import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompositeEntityRepository extends JpaRepository<CompositeEntity, Long> {


    List<CompositeEntity> findAllByPublisher(String publisher);
    List<CompositeEntity> findAllByCategory(String category);
    List<CompositeEntity> findAllByAuthor(String author);
}

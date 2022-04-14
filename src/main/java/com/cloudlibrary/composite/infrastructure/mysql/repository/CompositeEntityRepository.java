package com.cloudlibrary.composite.infrastructure.mysql.repository;

import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;

import java.util.List;
import java.util.Optional;

public interface CompositeEntityRepository {

    Optional<CompositeEntity> findCompositeByBookId(Long bookId);
    List<CompositeEntity> findCompositeAll();
    Optional<CompositeEntity> saveComposite(CompositeEntity compositeEntity);
    Optional<CompositeEntity> updateComposite(CompositeEntity compositeEntity);
//    delete 아직

}

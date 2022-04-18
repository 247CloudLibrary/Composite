package com.cloudlibrary.composite.infrastructure.mysql.repository;

import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Repository
public class CompositeEntityRepositoryImpl implements CompositeEntityRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<CompositeEntity> findCompositeByBookId(Long bookId) {

        CompositeEntity compositeEntity = entityManager.find(CompositeEntity.class, bookId);

        // 못 찾은 경우 compositeEntity에는 null이 들어감
        return Optional.ofNullable(compositeEntity);
    }

    @Override
    public List<CompositeEntity> findCompositeAll() {

        return entityManager
                .createQuery("select composites from CompositeEntity composites", CompositeEntity.class).getResultList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<CompositeEntity> saveComposite(CompositeEntity compositeEntity) {

        entityManager.persist(compositeEntity);
        return Optional.of(compositeEntity);
    }



}

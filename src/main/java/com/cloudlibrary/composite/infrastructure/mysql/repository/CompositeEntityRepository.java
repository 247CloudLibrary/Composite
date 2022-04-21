package com.cloudlibrary.composite.infrastructure.mysql.repository;

import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompositeEntityRepository extends CrudRepository<CompositeEntity, Long> {


}

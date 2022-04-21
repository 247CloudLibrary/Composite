package com.cloudlibrary.composite.application.mapper;

import com.cloudlibrary.composite.application.domain.Composite;
import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface MapperForPatch {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookStatusFromCompositeEntity(Composite dto, @MappingTarget CompositeEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLendingStatusFromCompoisteEntity(Composite dto,@MappingTarget CompositeEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReservationInfoFromCompositeEntity(Composite dto, @MappingTarget CompositeEntity entity);
}

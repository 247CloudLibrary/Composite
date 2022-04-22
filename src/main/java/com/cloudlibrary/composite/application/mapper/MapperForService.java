package com.cloudlibrary.composite.application.mapper;

import com.cloudlibrary.composite.application.service.CompositeOperationUseCase;
import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring")
public interface MapperForService {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void createBookToCompositeEntity(CompositeOperationUseCase.CompositeCreateCommand dto, @MappingTarget CompositeEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromCompositeEntity(CompositeOperationUseCase.CompositeCreateCommand dto, @MappingTarget CompositeEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookStatusFromCompositeEntity(CompositeOperationUseCase.BookStatusUpdateCommand dto, @MappingTarget CompositeEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLendingStatusFromCompoisteEntity(CompositeOperationUseCase.LendingStatusUpdateCommand dto, @MappingTarget CompositeEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReservationInfoFromCompositeEntity(CompositeOperationUseCase.ReservationInfoUpdateCommand dto, @MappingTarget CompositeEntity entity);
}

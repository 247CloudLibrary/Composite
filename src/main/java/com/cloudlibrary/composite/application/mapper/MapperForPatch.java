package com.cloudlibrary.composite.application.mapper;

import com.cloudlibrary.composite.application.service.CompositeOperationUseCase;
import com.cloudlibrary.composite.infrastructure.mysql.entity.CompositeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface MapperForPatch {
    void updateBookStatusFromCompositeEntity(CompositeOperationUseCase.BookStatusUpdateCommand dto, @MappingTarget CompositeEntity entity);
    void updateLendingStatusFromCompoisteEntity(CompositeOperationUseCase.LendingStatusUpdateCommand dto,@MappingTarget CompositeEntity entity);
    void updateReservationInfoFromCompositeEntity(CompositeOperationUseCase.ReservationInfoUpdateCommand dto, @MappingTarget CompositeEntity entity);
}

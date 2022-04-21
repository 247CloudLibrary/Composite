package com.cloudlibrary.composite.application.service;

import com.cloudlibrary.composite.infrastructure.mysql.repository.CompositeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompositeService implements CompositeReadUseCase, CompositeOperationUseCase{

    private CompositeEntityRepository compositeEntityRepository;

    @Autowired
    public CompositeService(CompositeEntityRepository compositeEntityRepository) {
        this.compositeEntityRepository = compositeEntityRepository;
    }

    @Override
    public FindCompositeResult createComposite(CompositeCreateCommand command) {
        return null;
    }

    @Override
    public FindCompositeResult getCompositeByBookId(BookFindQuery query) {
        return null;
    }

    @Override
    public List<FindCompositeResult> getCompositeListAll() {
        return null;
    }

    @Override
    public FindCompositeResult updateBookStatus(CompositeUpdateCommand command) {
        return null;
    }

    @Override
    public FindCompositeResult updateLendingStatus(CompositeUpdateCommand command) {
        return null;
    }

    @Override
    public FindCompositeResult updateReservationInfo(CompositeUpdateCommand command) {
        return null;
    }

}

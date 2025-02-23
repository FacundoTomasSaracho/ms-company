package com.facundosaracho.mscompany.business.service.impl;

import com.facundosaracho.mscompany.business.service.TransactionService;
import com.facundosaracho.mscompany.exception.BusinessException;
import com.facundosaracho.mscompany.exception.ExceptionCode;
import com.facundosaracho.mscompany.proxy.transaction.TransactionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionClient transactionClient;

    @Override
    public List<Long> getLastCompaniesThatMadeTransactions(LocalDateTime filterDate) {
        List<Long> companiesIds = transactionClient.getLastCompaniesThatMadeTransactions(filterDate);
        if (companiesIds.isEmpty()) throw new BusinessException(ExceptionCode.NO_COMPANIES_WERE_FOUND);
        return companiesIds;
    }
}

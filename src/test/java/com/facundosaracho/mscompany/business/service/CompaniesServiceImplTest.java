package com.facundosaracho.mscompany.business.service;


import com.facundosaracho.mscompany.business.service.impl.CompaniesServiceImpl;
import com.facundosaracho.mscompany.exception.BusinessException;
import com.facundosaracho.mscompany.exception.ExceptionCode;
import com.facundosaracho.mscompany.persistence.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
class CompaniesServiceImplTest {

    @InjectMocks
    private CompaniesServiceImpl companiesServiceImpl;

    @Mock
    CompanyRepository companyRepository;

    @Mock
    TransactionService transactionService;


    @Test
    void success_getLastTransactions() {

        List<Long> companiesIds = List.of(1L, 2L, 3L, 4L, 5L);

        when(transactionService.getLastCompaniesThatMadeTransactions(any(LocalDateTime.class))).thenReturn(companiesIds);

        List<Long> companiesIdsResponse = companiesServiceImpl.getLastTransactions(any(LocalDateTime.class));

        assertNotNull(companiesIdsResponse);

    }

    @Test
    void noTransactionsWereFound_getLastTransactions() {

        when(transactionService.getLastCompaniesThatMadeTransactions(any(LocalDateTime.class))).thenThrow(new BusinessException(ExceptionCode.NO_COMPANIES_WERE_FOUND));

        BusinessException businessException = assertThrows(BusinessException.class, () ->
        companiesServiceImpl.getLastTransactions(any(LocalDateTime.class)));

        assertEquals(ExceptionCode.NO_COMPANIES_WERE_FOUND.getMessage(), businessException.getMessage());

    }

}

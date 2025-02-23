package com.facundosaracho.mscompany.business.service.impl;

import com.facundosaracho.mscompany.business.model.Company;
import com.facundosaracho.mscompany.business.service.CompaniesService;
import com.facundosaracho.mscompany.business.service.TransactionService;
import com.facundosaracho.mscompany.persistence.repository.CompanyRepository;
import com.facundosaracho.mscompany.presentation.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompaniesServiceImpl implements CompaniesService {

    private final CompanyRepository companyRepository;
    private final TransactionService transactionService;

    @Override
    public Company register(Company company) {

        return CompanyMapper.INSTANCE.toModel(companyRepository.save(CompanyMapper.INSTANCE.toEntity(company)));
    }

    @Override
    public List<Long> getLastTransactions(LocalDateTime filterDate) {
        return transactionService.getLastCompaniesThatMadeTransactions(validateFilterDate(filterDate));
    }

    @Override
    public List<Company> lastRegisteredCompanies(LocalDateTime filterDate) {
        return companyRepository.findByRegisteredAtGreaterThanEqual(validateFilterDate(filterDate))
                .stream()
                .map(CompanyMapper.INSTANCE::toModel).toList();
    }

    private LocalDateTime validateFilterDate(LocalDateTime filterDate) {
        if (Objects.isNull(filterDate)) {
            filterDate = LocalDateTime.now()
                    .withDayOfMonth(1)
                    .withHour(0)
                    .withMinute(0)
                    .withSecond(0)
                    .withNano(0);
        }
        return filterDate;
    }
}

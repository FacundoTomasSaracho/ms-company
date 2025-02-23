package com.facundosaracho.mscompany.business.service;

import com.facundosaracho.mscompany.business.model.Company;

import java.time.LocalDateTime;
import java.util.List;

public interface CompaniesService {

    Company register(Company company);

    List<Long> getLastTransactions(LocalDateTime filterDate);

    List<Company> lastRegisteredCompanies(LocalDateTime filterDate);
}

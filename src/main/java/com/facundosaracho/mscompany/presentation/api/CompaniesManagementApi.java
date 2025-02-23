package com.facundosaracho.mscompany.presentation.api;

import com.facundosaracho.mscompany.presentation.dto.CompanyDto;
import com.facundosaracho.mscompany.presentation.dto.RegisterCompanyRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

public interface CompaniesManagementApi {
    @PostMapping("register")
    ResponseEntity<RegisterCompanyRequestDto> registerCompany(RegisterCompanyRequestDto companyDto);

    @GetMapping("last-transactions")
    ResponseEntity<List<Long>> getLastTransactions(LocalDateTime filterDate);

    @GetMapping("last-registrations")
    ResponseEntity<List<CompanyDto>> lastRegisteredCompanies(LocalDateTime filteredDate);
}

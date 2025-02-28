package com.facundosaracho.mscompany.presentation.controller;

import com.facundosaracho.mscompany.business.service.CompaniesService;
import com.facundosaracho.mscompany.presentation.api.CompaniesManagementApi;
import com.facundosaracho.mscompany.presentation.dto.CompanyDto;
import com.facundosaracho.mscompany.presentation.dto.RegisterCompanyRequestDto;
import com.facundosaracho.mscompany.presentation.mapper.CompanyMapper;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class CompaniesManagementController implements CompaniesManagementApi {

    private final CompaniesService companiesService;

    @Override
    @PostMapping("register")
    public ResponseEntity<RegisterCompanyRequestDto> registerCompany(@Valid @RequestBody RegisterCompanyRequestDto companyDto) {
        log.info("Starting to register company: {} - cuit: {}", companyDto.legalName(), companyDto.cuit());
        RegisterCompanyRequestDto response = CompanyMapper.INSTANCE.toDto(companiesService.register(CompanyMapper.INSTANCE.toModel(companyDto)));
        log.info("Successfully registration for company {}, cuit: {}", response.legalName(), response.cuit());
        return new ResponseEntity<>(companyDto, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("last-transactions")
    public ResponseEntity<List<Long>> getLastTransactions(@RequestParam(value = "filter_date", required = false) LocalDateTime filterDate) {
        log.info("<<<<< Started to get last companies that made transactions in the last month. >>>>>>");
        List<Long> response = companiesService.getLastTransactions(filterDate)
                .stream().toList();
        log.info("<<<<< Companies that made transactions in last mound were found successfully. End of request. >>>>>>");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @GetMapping("lasts-registrations")
    public ResponseEntity<List<CompanyDto>> lastRegisteredCompanies(@RequestParam(value = "filter_date", required = false) LocalDateTime filterDate) {
        log.info("<<<< Start getting last registered companies >>>>");
        List<CompanyDto> response = companiesService.lastRegisteredCompanies(filterDate)
                .stream()
                .map(CompanyMapper.INSTANCE::companyDtoToCompany)
                .toList();
        log.info("<<< End of method | companies filtered successfully >>>>");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

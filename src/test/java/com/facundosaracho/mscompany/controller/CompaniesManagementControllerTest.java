package com.facundosaracho.mscompany.controller;

import com.facundosaracho.mscompany.business.model.Company;
import com.facundosaracho.mscompany.business.service.CompaniesService;
import com.facundosaracho.mscompany.presentation.controller.CompaniesManagementController;
import com.facundosaracho.mscompany.presentation.dto.RegisterCompanyRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompaniesManagementControllerTest {


    @InjectMocks
    private CompaniesManagementController controller;

    @Mock
    private CompaniesService companiesService;


    @Test
    void registercompany_success() {

        Company genericCompany = createCompany();

        when(companiesService.register(any(Company.class))).thenReturn(genericCompany);
        ResponseEntity<RegisterCompanyRequestDto> entity = controller.registerCompany(createCompanyDto());
        assertNotNull(entity);
        assertEquals("Facundo Company", entity.getBody().legalName());
        assertEquals(HttpStatus.CREATED, entity.getStatusCode());

    }


    private RegisterCompanyRequestDto createCompanyDto() {
        return new RegisterCompanyRequestDto("123123213213213", "Facundo Company");
    }

    private Company createCompany() {
        Company company = new Company();
        company.setCuit("123123213213213");
        company.setLegalName("Facundo Company");
        return company;
    }

}

package com.facundosaracho.mscompany.presentation.api;

import com.facundosaracho.mscompany.presentation.dto.CompanyDto;
import com.facundosaracho.mscompany.presentation.dto.RegisterCompanyRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import retrofit2.SkipCallbackExecutor;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Companies")
public interface CompaniesManagementApi {

    @Operation(
            operationId = "registerNewCompany",
            summary = "Este endpoint sirve para poder registrar una nueva compañia.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED")})
    @PostMapping("register")
    ResponseEntity<RegisterCompanyRequestDto> registerCompany(RegisterCompanyRequestDto companyDto);

    @Operation(
            operationId = "getLastTransaction",
            summary = "Esta operación permite obtener un listado de IDS de las empresas que hicieron transacciones " +
                    "filtrando por una fecha en concreto. " +
                    "Si no se especifica, toma el último mes."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    @Schema(implementation = LocalDateTime.class)
    @GetMapping("last-transactions")
    ResponseEntity<List<Long>> getLastTransactions(LocalDateTime filterDate);

    @Operation(
            operationId = "getLasRegistrations",
            summary = "Este endpoint sirve para obtener las empresas que se registraron filtrando " +
                    "por una fecha en concreto. Si no se envía un valor de filtro, se toma el último mes."
    )
    @ApiResponses(value = {@ApiResponse (responseCode = "200", description = "OK")})
    @Schema(implementation = CompanyDto.class)
    @GetMapping("lasts-registrations")
    ResponseEntity<List<CompanyDto>> lastRegisteredCompanies(LocalDateTime filteredDate);
}

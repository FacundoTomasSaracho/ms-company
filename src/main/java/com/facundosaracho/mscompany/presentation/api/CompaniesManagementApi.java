package com.facundosaracho.mscompany.presentation.api;

import com.facundosaracho.mscompany.presentation.dto.CompanyDto;
import com.facundosaracho.mscompany.presentation.dto.RegisterCompanyRequestDto;
import com.facundosaracho.mscompany.presentation.exception.ErrorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Companies", description = "Companies - B2B")
public interface CompaniesManagementApi {

    @Operation(
            operationId = "registerNewCompany",
            summary = "Este endpoint sirve para poder registrar una nueva compañia.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "CREATED",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            type = "RegisterCompanyRequestDto",
                                            implementation = RegisterCompanyRequestDto.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "INTERNAL_SERVER_ERROR",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            type = "ErrorDto",
                                            implementation = ErrorDto.class
                                    )
                            )
                    )
            })
    @PostMapping("register")
    ResponseEntity<RegisterCompanyRequestDto> registerCompany(RegisterCompanyRequestDto companyDto);

    @Operation(
            operationId = "getLastTransaction",
            summary = "Esta operación permite obtener un listado de IDS de las empresas que hicieron transacciones " +
                    "filtrando por una fecha en concreto. " +
                    "Si no se especifica, toma el último mes.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Long.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "INTERNAL_SERVER_ERROR",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    @GetMapping("lasts-transactions")
    ResponseEntity<List<Long>> getLastTransactions(LocalDateTime filterDate);

    @Operation(
            operationId = "getLasRegistrations",
            summary = "Este endpoint sirve para obtener las empresas que se registraron filtrando " +
                    "por una fecha en concreto. Si no se envía un valor de filtro, se toma el último mes.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CompanyDto.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "INTERNAL_SERVER_ERROR",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            type = "ErrorDto",
                                            implementation = ErrorDto.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("lasts-registrations")
    ResponseEntity<List<CompanyDto>> lastRegisteredCompanies(LocalDateTime filteredDate);
}

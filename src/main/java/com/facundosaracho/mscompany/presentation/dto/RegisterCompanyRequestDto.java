package com.facundosaracho.mscompany.presentation.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record RegisterCompanyRequestDto(
        @NotBlank @Pattern(regexp = "\\d{50}", message = "El CUIT debe tener 50 dígitos") String cuit,
        @NotBlank String legalName) {
}

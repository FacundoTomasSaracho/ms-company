package com.facundosaracho.mscompany.presentation.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record RegisterCompanyRequestDto(
        @NotBlank @Pattern(regexp = "\\d{50}", message = "El CUIT debe tener 50 dígitos")
        @Schema(example = "47376399092366785740845729993909666594036951095379",
                description = "CUIT que identifica a una compañia") String cuit,
        @NotBlank @Schema(example = "Burger King", description = "Nombre legal de la empresa.") String legalName) {
}

package com.facundosaracho.mscompany.presentation.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CompanyDto(@Schema(example = "4336") Long id,
                         @Schema(example = "Volkswagen", description = "Nombre legal de la compañia") String legalName,
                         @Schema(example = "47376399092366785740845729993909666594036951095379") String cuit,
                         LocalDateTime registeredAt) {
}

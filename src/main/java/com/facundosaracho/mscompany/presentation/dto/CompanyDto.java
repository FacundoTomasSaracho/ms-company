package com.facundosaracho.mscompany.presentation.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CompanyDto(Long id, String legalName, String cuit,
                         LocalDateTime registeredAt) {
}

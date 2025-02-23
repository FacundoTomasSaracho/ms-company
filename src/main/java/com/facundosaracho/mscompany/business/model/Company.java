package com.facundosaracho.mscompany.business.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Company {

    private Long id;
    private String cuit;
    private String legalName;
    private LocalDateTime registeredAt;
}

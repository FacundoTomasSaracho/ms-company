package com.facundosaracho.mscompany.persistence.entities;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cuit", length = 50, nullable = false, unique = true)
    @Comment("Código identificador de la empresa")
    private String cuit;

    @Column(name = "legal_name", length = 50, nullable = false)
    @Comment("Razón social de la empresa")
    private String legalName;

    @Column(name = "registered_at", nullable = false, updatable = false )
    @Comment("Fecha de registro de la empresa.")
    private LocalDateTime registeredAt;

    @PrePersist
    private void prePersist(){
        registeredAt = LocalDateTime.now();
    }
}

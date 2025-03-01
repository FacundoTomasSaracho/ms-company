package com.facundosaracho.mscompany.presentation.mapper;

import com.facundosaracho.mscompany.business.model.Company;
import com.facundosaracho.mscompany.persistence.entities.CompanyEntity;
import com.facundosaracho.mscompany.presentation.dto.CompanyDto;
import com.facundosaracho.mscompany.presentation.dto.RegisterCompanyRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company toModel(RegisterCompanyRequestDto customerDto);

    RegisterCompanyRequestDto toDto(Company company);

    CompanyDto companyDtoToCompany(Company company);

    CompanyEntity toEntity(Company company);

    Company toModel(CompanyEntity companyEntity);

}

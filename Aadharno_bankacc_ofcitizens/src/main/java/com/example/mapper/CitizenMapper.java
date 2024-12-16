package com.example.mapper;

import com.example.dto.CitizenDto;
import com.example.entity.Citizen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CitizenMapper {
    CitizenMapper INSTANCE= Mappers.getMapper(CitizenMapper.class);
    CitizenDto citizenToCitizenDto(Citizen citizen);

    @Mapping(target = "panno",ignore = true)
    @Mapping(target = "bankAccount",ignore = true)
    CitizenDto citizenWithAadharAndName(Citizen citizen);

    @Mapping(target = "aadharno",ignore = true)
    @Mapping(target = "bankAccount",ignore = true)
    CitizenDto citizenWithPanAndName(Citizen citizen);

}

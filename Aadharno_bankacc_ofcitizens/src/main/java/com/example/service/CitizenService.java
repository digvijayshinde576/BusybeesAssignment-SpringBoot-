package com.example.service;

import com.example.dto.CitizenDto;
import com.example.entity.Citizen;

public interface CitizenService {

    Citizen addCitizen(Citizen citizen);
    CitizenDto findCitizenByAadharId(Long aadharId);
    CitizenDto findCitizenByPanId(Long panid);

    boolean updateCitizenByAadharId(Long aadharId,String name);
}

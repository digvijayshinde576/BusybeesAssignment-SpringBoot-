package com.example.service;

import com.example.dto.CitizenDto;
import com.example.entity.Citizen;
import com.example.mapper.CitizenMapper;
import com.example.repository.CitizenRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private CitizenRepo citizenRepo;

    @Override
    public Citizen addCitizen(Citizen citizen) {
        return citizenRepo.save(citizen);
    }

    @Override
    public CitizenDto findCitizenByAadharId(Long aadharId) {
       Citizen citizen=citizenRepo.findById(aadharId).orElseThrow(()->new RuntimeException("Citizen Not Found..."));
       CitizenDto citizenDto=CitizenMapper.INSTANCE.citizenWithPanAndName(citizen);
        return citizenDto;
    }

    @Override
    public CitizenDto findCitizenByPanId(Long panid) {
       Citizen citizen = citizenRepo.findByPanno(panid).orElseThrow(()->new RuntimeException("Citizen Not found...."));
        CitizenDto citizenDto= CitizenMapper.INSTANCE.citizenWithAadharAndName(citizen);
        return citizenDto;
    }

    @Override
    public boolean updateCitizenByAadharId(Long aadharId,String name) {
        Optional<Citizen> citizen = citizenRepo.findById(aadharId);
        if(citizen.isPresent()){
            Citizen newCitizen=citizen.get();
            citizenRepo.save(newCitizen);
            return true;
        }

        return false;
    }


}

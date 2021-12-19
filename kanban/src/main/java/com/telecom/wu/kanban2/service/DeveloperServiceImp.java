package com.telecom.wu.kanban2.service;

import com.telecom.wu.kanban2.dao.DeveloperRepository;
import com.telecom.wu.kanban2.domain.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImp implements DeveloperService{

    @Autowired
    private DeveloperRepository developerRepository;


    @Override
    public List<Developer> findAllDevelopers() {
        return this.developerRepository.findAll();
    }

//    @Override
//    public Developer findDeveloper(Long id) {
//        return this.developerRepository.getById(id);
//    }
}

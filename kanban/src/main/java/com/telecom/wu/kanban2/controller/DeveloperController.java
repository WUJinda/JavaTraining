package com.telecom.wu.kanban2.controller;

import com.telecom.wu.kanban2.domain.Developer;
import com.telecom.wu.kanban2.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // @RestController is roughly equivalent to (@Controller + @ResponseBody)
// which has the role of @Control components, and control the display of the body part on the web side.
@CrossOrigin(origins = "*", allowedHeaders = "*") // As the name implies, the annotation enables Cross-Origin Resource Sharing (CORS) on the server.
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping("/developers")
    List<Developer> findAllDevelopers() {
        return this.developerService.findAllDevelopers();
    }

//    @GetMapping("/developers/{id}")
//    Developer findDeveloper(Long id){
//        return  this.developerService.findDeveloper(id);
//    }
}

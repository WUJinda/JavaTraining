package com.example.kanban;

import com.example.kanban.domain.Developer;
import com.example.kanban.service.DeveloperService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
public class DeveloperTest {

    @Autowired
    private DeveloperService developerService;

    @Test
    public void testFindAllDevelopers() {

        Collection<Developer> developers = this.developerService.findAllDevelopers();

        Assert.assertEquals(1, developers.size());
    }
}

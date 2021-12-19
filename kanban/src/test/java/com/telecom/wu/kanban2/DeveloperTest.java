package com.telecom.wu.kanban2;


import com.telecom.wu.kanban2.domain.Developer;
import com.telecom.wu.kanban2.service.DeveloperService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@SpringBootTest // This annotation is used to load complete application context for end to end integration testing
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
public class DeveloperTest {

    @Autowired
    private DeveloperService developerService;

    @Test
    public void testFindAllDevelopers() {

        Collection<Developer> developers = this.developerService.findAllDevelopers();

        Assert.assertEquals(1, developers.size());
    }
}

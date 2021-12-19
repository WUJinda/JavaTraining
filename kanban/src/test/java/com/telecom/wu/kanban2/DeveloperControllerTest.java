package com.telecom.wu.kanban2;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //is used to provide a bridge between Spring Boot test features and JUnit.
// Whenever we are using any Spring Boot testing features in our JUnit tests, this annotation will be required.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc//to load the full application configuration and use MockMVC,
// @SpringBootTest combined with @AutoConfigureMockMvc rather than this annotation is  considered.
@ActiveProfiles(profiles = "test")
public class DeveloperControllerTest extends ControllerTest {

    @Test
    public void testGetTasks() throws Exception {

        mvc.perform(get("/developers")
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstname", is("dev1")))
                .andExpect(jsonPath("$[0].lastname", is("dev1")))
                .andExpect(jsonPath("$[0].password", is("dev1")))
                .andExpect(jsonPath("$[0].email", is("dev1@dev.dev")))
        ;
    }
}
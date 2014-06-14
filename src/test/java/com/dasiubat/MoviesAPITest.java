package com.dasiubat;

import com.dasiubat.config.DBConfigurationTest;
import com.dasiubat.config.MvcConfiguration;
import com.dasiubat.controller.GreetingController;
import com.dasiubat.domain.Person;
import com.dasiubat.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Adam on 2014-06-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfiguration.class, DBConfigurationTest.class})
public class MoviesAPITest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void testData() {
        Person person = new Person();
        person.setName("adam");
        person.setSurname("bat");

        personRepository.save(person);

        personRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void testTest() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void
    greeting_resource_returns_an_id_and_expected_greeting_in_body() {
        given()
                .standaloneSetup(new GreetingController())
                .param("name", "Johan").
        when().
                get("/greeting").
        then().
                statusCode(200).
                body("id", equalTo(1)).
                body("content", equalTo("Hello, Johan!"));
    }
}

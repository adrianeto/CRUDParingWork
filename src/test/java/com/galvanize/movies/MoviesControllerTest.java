package com.galvanize.movies;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MoviesController.class)
public class MoviesControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testMovies() throws Exception{
        RequestBuilder request = get("/movies/movie");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Title", is("The Godfather")))
                .andExpect(jsonPath("$.Gross", is(134.97)));


    }
}
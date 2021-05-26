package com.galvanize.movies;
import com.jayway.jsonpath.PathNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MoviesController.class)
public class MoviesControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    void testMovies() throws Exception{
        RequestBuilder request = get("/movies/movie");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Title", is("The Godfather")))
                .andExpect(jsonPath("$.Gross", is(134.97)));
    }
    @Test
    void testMoviesNoAttributeException() throws Exception{
        RequestBuilder request = get("/movies/movie");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                //.andExpect( assertThrows( PathNotFoundException.class, () -> {
                .andExpect(
                        jsonPath("$.Credits[0].Person.FirstName").doesNotHaveJsonPath() );
    }
  @Test
    public void testRawBody() throws Exception {
        String json = getJSON("C:\\Users\\913170\\IdeaProjects\\Movies\\src\\main\\resources\\movies.json");

        MockHttpServletRequestBuilder request = post("/movies/gross/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("191"));
    }

    private String getJSON(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
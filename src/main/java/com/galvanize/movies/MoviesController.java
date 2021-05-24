package com.galvanize.movies;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @GetMapping("/movie")
    public Root buildOutputMovie(){
        Root root = new Root();
        root.title = "The Godfather";
        root.minutes= 175;
        root.genre = "Crime, Drama";
        root.rating = 9.2;
        root.metascore = 100;
        root.description = "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.";
        root.votes = 1561591;
        root.gross = 134.97;
        root.year = "1972";

        Person myperson = new Person();
        myperson.firstName = "Francis Ford";
        myperson.lastName = "Copolla";
        myperson.role = "Director";

        Person myperson2 = new Person();
        myperson2.firstName = "Marlon";
        myperson2.lastName = "Brando";
        myperson2.role = "Star";

        Person myperson3 = new Person();
        myperson3.firstName = "Al";
        myperson3.lastName = "Pacino";
        myperson3.role = "Star";

        Person myperson4 = new Person();
        myperson4.firstName = "James";
        myperson4.lastName = "Caan";
        myperson4.role = "Star";

        Person myperson5 = new Person();
        myperson5.firstName = "Diane";
        myperson5.lastName = "Keaton";
        myperson5.role = "Star";


        Credit credit1 = new Credit();
        credit1.person = myperson;

        Credit credit2 = new Credit();
        credit2.person = myperson2;

        Credit credit3 = new Credit();
        credit3.person = myperson3;

        Credit credit4 = new Credit();
        credit4.person = myperson4;

        Credit credit5 = new Credit();
        credit5.person = myperson5;
        root.credits = Arrays.asList(credit1,credit2,credit3, credit4, credit5);

        return root;

    }

    public static class Person{
        @JsonProperty("Role")
        public String role;
        @JsonProperty("FirstName")
        public String firstName;
        @JsonProperty("LastName")
        public String lastName;
    }

    public static class Credit{
        @JsonProperty("Person")
        public Person person;
    }

    public static class Root{
        @JsonProperty("Title")
        public String title;
        @JsonProperty("Minutes")
        public int minutes;
        @JsonProperty("Genre")
        public String genre;
        @JsonProperty("Rating")
        public double rating;
        @JsonProperty("Metascore")
        public int metascore;
        @JsonProperty("Description")
        public String description;
        @JsonProperty("Votes")
        public int votes;
        @JsonProperty("Gross")
        public double gross;
        @JsonProperty("Year")
        public String year;
        @JsonProperty("Credits")
        public List<Credit> credits;
    }

}

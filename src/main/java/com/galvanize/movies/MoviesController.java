package com.galvanize.movies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.web.bind.annotation.*;

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
        root.genre = null;
        root.rating = 9.2;
        root.metascore = 100;
        root.description = "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.";
        root.votes = 1561591;
        root.gross = 134.97;
        root.year = "1972";

        Person myperson = new Person();
        myperson.firstName =null;
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

    @PostMapping("/gross/total")
    public int getJSONData(@RequestBody ArrayList<Root> roots) {
        int gross=0;
        for (Root item: roots)
         {
             gross+= item.gross;
        }
        return gross;
    }

    @JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Person{

        public String role;

        public String firstName;

        public String lastName;
    }

    @JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Credit{

        public Person person;
    }

    @JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Root{

        public String title;

        public int minutes;

        public String genre;

        public double rating;


        public String description;

        public int votes;


        public double gross;

        public String year;

        public List<Credit> credits;

        public int metascore;
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public int getMetascore() {
            return metascore;
        }

        public void setMetascore(int metascore) {
            this.metascore = metascore;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getVotes() {
            return votes;
        }

        public void setVotes(int votes) {
            this.votes = votes;
        }

        public double getGross() {
            return gross;
        }

        public void setGross(double gross) {
            this.gross = gross;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public List<Credit> getCredits() {
            return credits;
        }

        public void setCredits(List<Credit> credits) {
            this.credits = credits;
        }


    }

}

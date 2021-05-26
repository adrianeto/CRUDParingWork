package com.galvanize.movies;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MoviesDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Person{

        public String role;

        @JsonProperty("FirstName")
        public String firstName;

        @JsonProperty("LastName")
        public String lastName;
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Credit{

        public MoviesDTO.Person person;
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Root{

        public String title;

        public int minutes;

        public String genre;

        public double rating;


        public String description;

        public int votes;


        public double gross;

        @JsonProperty("Year")
        public String year;

        @JsonProperty("Credits")
        public List<MoviesDTO.Credit> credits;

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

        public List<MoviesDTO.Credit> getCredits() {
            return credits;
        }

        public void setCredits(List<MoviesDTO.Credit> credits) {
            this.credits = credits;
        }


    }
}

package com.example.model;

public class Movie {

    private final String title;
    private final String director;

    public Movie(final String title, final String director) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Movie(title='" + title + "', director='" + director + "')";
    }
}

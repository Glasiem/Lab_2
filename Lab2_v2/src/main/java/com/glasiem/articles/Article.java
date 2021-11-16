package com.glasiem.articles;

public class Article {
    private String title;
    private String annotation;
    private String author;
    private String location;
    private String review;

    public Article(String title, String annotation, String author, String location, String review) {
        this.title = title;
        this.annotation = annotation;
        this.author = author;
        this.location = location;
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public String getAnnotation() {
        return annotation;
    }

    public String getAuthor() {
        return author;
    }

    public String getLocation() {
        return location;
    }

    public String getReview() {
        return review;
    }
}

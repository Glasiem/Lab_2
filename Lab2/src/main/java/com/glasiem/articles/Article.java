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

    public Article(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

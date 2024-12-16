package com.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
  //  Author : name, age, gender, rating, List<Book>

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorName;
    private int age;
    private String gender;
    private double rating;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Book> bookList;

    public Author() {
    }

    public Author(Long id, String authorName, int age, String gender, double rating, List<Book> bookList) {
        this.id = id;
        this.authorName = authorName;
        this.age = age;
        this.gender = gender;
        this.rating = rating;
        this.bookList = bookList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String   toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", rating=" + rating +
                ", bookList=" + bookList +
                '}';
    }
}

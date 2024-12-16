package com.example.entity;

import jakarta.persistence.*;

@Entity
public class Book {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author_name;
    private int pages;

    @ManyToOne
    @JoinColumn(name = "authorId")
    Author author;

    public Book() {
    }

    public Book(Long id, String name, String author_name, int pages, Author author) {
        this.id = id;
        this.name = name;
        this.author_name = author_name;
        this.pages = pages;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author_name='" + author_name + '\'' +
                ", pages=" + pages +
                ", author=" + author +
                '}';
    }
}

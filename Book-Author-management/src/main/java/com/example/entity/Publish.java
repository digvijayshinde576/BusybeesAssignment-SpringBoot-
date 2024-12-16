package com.example.entity;

import jakarta.persistence.*;

@Entity
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @ManyToOne
    @JoinColumn(name = "bookId")
    Book book;
    @ManyToOne
    @JoinColumn(name = "authorId")
    Author author;

    private int publishYear;

    public Publish() {
    }

    public Publish(Long id, Book book, Author author, int publishYear) {
        this.id = id;
        this.book = book;
        this.author = author;
        this.publishYear = publishYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Publish{" +
                "id=" + id +
                ", book=" + book +
                ", author=" + author +
                ", publishYear=" + publishYear +
                '}';
    }
}

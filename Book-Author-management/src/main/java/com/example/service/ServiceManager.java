package com.example.service;

import com.example.entity.Author;
import com.example.entity.Book;

public interface ServiceManager {
    Book addBook(Book book);
    Author addAuthor(Author author);
   Long noOfBookPublishedByAuthorInYear(Long authorId,int year);

}

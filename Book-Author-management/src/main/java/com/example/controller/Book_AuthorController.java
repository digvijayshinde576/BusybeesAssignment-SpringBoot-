package com.example.controller;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.service.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookManagement")
//@RequiredArgsConstructor
public class Book_AuthorController {

    @Autowired
    private ServiceManager serviceManager;

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(serviceManager.addBook(book),HttpStatus.CREATED);
    }

   @PostMapping("/addAuthor")
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(serviceManager.addAuthor(author),HttpStatus.CREATED);
    }

    @GetMapping("/count")
    public ResponseEntity<?> noOfBookPublishedByAuthorInYear(@RequestParam Long authorId,@RequestParam int year) {
        return  new ResponseEntity<>(serviceManager.noOfBookPublishedByAuthorInYear(authorId,year),HttpStatus.FOUND);
    }
}

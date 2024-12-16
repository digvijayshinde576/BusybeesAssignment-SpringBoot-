package com.example.service;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.repository.AuthorRepo;
import com.example.repository.BookRepo;
import com.example.repository.PublishRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ServiceManagerImpl implements ServiceManager{

    @Autowired
  private BookRepo bookRepo;
    @Autowired
  private AuthorRepo authorRepo;
    @Autowired
  private PublishRepo publishRepo;

    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Long noOfBookPublishedByAuthorInYear(Long authorId, int year) {
        return  publishRepo.countByAuthor_IdAndPublishYear(authorId,year);
    }
}

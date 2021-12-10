package com.junit.practice.service.impl;

import com.junit.practice.model.dto.BookRequestDTO;
import com.junit.practice.model.dto.BookResponseDTO;
import com.junit.practice.model.entity.BookEntity;
import com.junit.practice.model.mapper.BookMapper;
import com.junit.practice.repository.BookRepository;
import com.junit.practice.service.BookService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(@Lazy BookRepository bookRepository, @Lazy BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<BookEntity> foundBooks = bookRepository.findAll();
        List<BookResponseDTO> result = new ArrayList<>();
        for(BookEntity ent : foundBooks){
            result.add(bookMapper.bookEntity2ResponseDTO(ent));
        }
        return result;
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        Optional<BookEntity> book = bookRepository.findById(id);
        if(!book.isPresent()){
            throw new NoSuchElementException("No Book with ID: " + id);
        }
        BookEntity foundBook = book.get();
        return bookMapper.bookEntity2ResponseDTO(foundBook);
    }

    @Override
    public BookResponseDTO saveNewBook(BookRequestDTO newBook) {
        BookEntity bookEntity = bookMapper.bookRequestDTO2Entity(newBook);
        BookEntity savedBook = bookRepository.save(bookEntity);
        return bookMapper.bookEntity2ResponseDTO(savedBook);
    }

    @Override
    public BookResponseDTO editBookById(BookRequestDTO editBook, Long id) {
        Optional<BookEntity> book = bookRepository.findById(id);
        if(!book.isPresent()){
            throw new NoSuchElementException("No Book with ID: " + id);
        }
        BookEntity foundBook = book.get();
        foundBook.setName(editBook.getName());
        foundBook.setSummary(editBook.getSummary());
        foundBook.setRating(editBook.getRating());
        BookEntity editedBook = bookRepository.save(foundBook);
        return bookMapper.bookEntity2ResponseDTO(editedBook);
    }
}

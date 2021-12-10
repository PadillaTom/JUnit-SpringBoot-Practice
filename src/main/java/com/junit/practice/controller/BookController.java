package com.junit.practice.controller;

import com.junit.practice.model.dto.BookResponseDTO;
import com.junit.practice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(@Lazy BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooksList(){
        List<BookResponseDTO> myBooks = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(myBooks);
    }


}

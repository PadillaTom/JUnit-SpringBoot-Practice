package com.junit.practice.controller;

import com.junit.practice.model.dto.BookRequestDTO;
import com.junit.practice.model.dto.BookResponseDTO;
import com.junit.practice.service.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookDetails(@PathVariable Long id){
        BookResponseDTO bookDetails = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookDetails);
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> createNewBook(@RequestBody BookRequestDTO newBook){
        BookResponseDTO savedBook = bookService.saveNewBook(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> editSavedBook(@RequestBody BookRequestDTO editBook,@PathVariable Long id) {
        BookResponseDTO editedBook = bookService.editBookById(editBook, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(editedBook);
    }


}

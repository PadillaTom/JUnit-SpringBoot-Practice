package com.junit.practice.service;

import com.junit.practice.model.dto.BookRequestDTO;
import com.junit.practice.model.dto.BookResponseDTO;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getAllBooks();

    BookResponseDTO getBookById(Long id);

    BookResponseDTO saveNewBook(BookRequestDTO newBook);

    BookResponseDTO editBookById(BookRequestDTO editBook, Long id);
}

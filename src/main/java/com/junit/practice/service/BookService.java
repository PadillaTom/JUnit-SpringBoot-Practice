package com.junit.practice.service;

import com.junit.practice.model.dto.BookResponseDTO;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getAllBooks();
}

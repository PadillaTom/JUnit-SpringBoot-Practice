package com.junit.practice.service.impl;

import com.junit.practice.model.dto.BookResponseDTO;
import com.junit.practice.model.entity.BookEntity;
import com.junit.practice.model.mapper.BookMapper;
import com.junit.practice.repository.BookRepository;
import com.junit.practice.service.BookService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}

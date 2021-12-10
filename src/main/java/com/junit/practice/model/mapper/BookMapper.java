package com.junit.practice.model.mapper;

import com.junit.practice.model.dto.BookRequestDTO;
import com.junit.practice.model.dto.BookResponseDTO;
import com.junit.practice.model.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class BookMapper {

    // DTO -> ETITY
    public BookEntity bookRequestDTO2Entity(BookRequestDTO dto){
        BookEntity ent = new BookEntity();
        ent.setName(dto.getName());
        ent.setSummary(dto.getSummary());
        ent.setRating(dto.getRating());
        return ent;
    }

    // ENTITY -> DTO
    public BookResponseDTO bookEntity2ResponseDTO(BookEntity ent){
        return BookResponseDTO.builder()
                .id(ent.getId())
                .name(ent.getName())
                .summary(ent.getSummary())
                .rating(ent.getRating())
                .build();
    }


}

package com.junit.practice.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookResponseDTO {

    private Long id;
    private String name;
    private String summary;
    private int rating;
}

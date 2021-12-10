package com.junit.practice.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookRequestDTO {

    private String name;
    private String summary;
    private int rating;
}

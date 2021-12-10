package com.junit.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.junit.practice.model.entity.BookEntity;
import com.junit.practice.repository.BookRepository;
import com.junit.practice.service.impl.BookServiceImpl;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    // Mock BookRepository to prevent using it every time
    @Mock
    private BookRepository bookRepository;

    // Injectamos los Mocks creados previamente en nuestra Class:
    @InjectMocks
    private BookServiceImpl bookServiceImpl;

    // Creamos alguna Data:
    BookEntity RECORD_1 = new BookEntity(1L,"Book 1", "Todo sobre el Book 1", 1);
    BookEntity RECORD_2 = new BookEntity(2L,"Book 2", "Todo sobre el Book 2", 2);
    BookEntity RECORD_3 = new BookEntity(3L,"Book 3", "Todo sobre el Book 3", 3);

    // BEFORE -> Antes de realizar el Test.
    @Before
    private void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookServiceImpl).build();
    }

}

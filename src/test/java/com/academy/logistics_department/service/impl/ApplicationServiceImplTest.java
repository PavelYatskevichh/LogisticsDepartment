package com.academy.logistics_department.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class ApplicationServiceImplTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    ApplicationServiceImpl service;

    @Test
    void saveApplicationWithChange() {

    }
}

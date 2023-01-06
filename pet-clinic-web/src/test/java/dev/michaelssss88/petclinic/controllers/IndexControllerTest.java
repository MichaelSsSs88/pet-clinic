package dev.michaelssss88.petclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    @Mock
    Model model;
    IndexController controller;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController();
    }

    @Test
    void index() {
        String viewName = controller.index(model);
        assertEquals("index",viewName);
    }
}
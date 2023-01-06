package dev.michaelssss88.petclinic.controllers;

import dev.michaelssss88.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    OwnerController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller= new OwnerController(ownerService);
    }

    @Test
    void index() {
        String viewName= controller.index(model);
        assertEquals("owners/index", viewName);
    }
}
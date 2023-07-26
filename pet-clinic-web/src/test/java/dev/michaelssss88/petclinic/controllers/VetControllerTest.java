package dev.michaelssss88.petclinic.controllers;
import dev.michaelssss88.petclinic.models.Vet;
import dev.michaelssss88.petclinic.services.VetService;

import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.*;

class VetControllerTest {

    @Mock
    Model model;

    @Mock
    VetService vetService;

    VetController controller;
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller= new VetController(vetService);
    }

    @Test
    void index() {

        Set<Vet> vets= new HashSet<>();
        vets.add(new Vet());
        vets.add(new Vet());
        when(vetService.findAll()).thenReturn(vets);
        ArgumentCaptor<Set<Vet>> argumentCaptor= ArgumentCaptor.forClass(Set.class);
        String viewName=controller.index(model);
        assertEquals("vets/index", viewName);
        verify(vetService, times(1)).findAll();
        //verify(model,times(1)).addAttribute(ArgumentMatchers.eq("vets"), anySet());
        verify(model,times(1)).addAttribute(ArgumentMatchers.eq("vets"), argumentCaptor.capture());
        Set<Vet> vetInController= argumentCaptor.getValue();
        assertEquals(2,vetInController.size());
    }
}

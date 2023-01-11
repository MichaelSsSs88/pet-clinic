package dev.michaelssss88.petclinic.controllers;

import dev.michaelssss88.petclinic.models.Owner;
import dev.michaelssss88.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {


    Set<Owner> owners;
    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    @InjectMocks
    OwnerController controller;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners= new HashSet<>();
        owners.add(Owner.builder().build());
        owners.add(Owner.builder().build());
        //MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
        //controller= new OwnerController(ownerService);
    }

    @Test
    void index() throws Exception{
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners/"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
      /*  String viewName= controller.index(model);
        assertEquals("owners/index", viewName);*/
    }

    @Test
    void showOwner() throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().city("quesada").build());
        mockMvc.perform(get("/owners/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("city", is("quesada"))));

    }
}
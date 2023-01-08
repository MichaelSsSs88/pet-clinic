package dev.michaelssss88.petclinic.services.map;

import dev.michaelssss88.petclinic.services.SpecialitesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class VetServiceMapTest {

    @Mock
    SpecialitesService specialitesService;

    VetServiceMap vetServiceMap;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        vetServiceMap= new VetServiceMap(specialitesService);
        
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
    }
}
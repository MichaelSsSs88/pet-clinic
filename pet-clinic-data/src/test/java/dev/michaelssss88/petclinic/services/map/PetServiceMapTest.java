package dev.michaelssss88.petclinic.services.map;

import dev.michaelssss88.petclinic.models.Pet;
import dev.michaelssss88.petclinic.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {

    PetServiceMap petServiceMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        petServiceMap= new PetServiceMap();
        petServiceMap.save(Pet.builder().build());
        petServiceMap.save(Pet.builder().build());
        petServiceMap.save(Pet.builder().build());
    }

    @Test
    void findAll() {
        assertEquals(3, petServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(3L);
        assertEquals(2, petServiceMap.findAll().size());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(2L));
        assertEquals(2, petServiceMap.findAll().size());
    }

    @Test
    void save() {
        Pet petService= Pet.builder().build();
        petServiceMap.save(petService);
        assertEquals(4, petServiceMap.findAll().size());
    }
}
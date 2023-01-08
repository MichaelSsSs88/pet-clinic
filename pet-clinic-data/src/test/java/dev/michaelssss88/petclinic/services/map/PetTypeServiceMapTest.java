package dev.michaelssss88.petclinic.services.map;

import dev.michaelssss88.petclinic.models.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeServiceMapTest {

    PetTypeServiceMap petTypeServiceMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        petTypeServiceMap = new PetTypeServiceMap();
        petTypeServiceMap.save(Type.builder().build());
        petTypeServiceMap.save(Type.builder().build());
        petTypeServiceMap.save(Type.builder().build());
    }

    @Test
    void findAll() {
        assertEquals(3, petTypeServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        petTypeServiceMap.deleteById(2L);
        assertEquals(2, petTypeServiceMap.findAll().size());
    }

    @Test
    void delete() {
        Type type= petTypeServiceMap.findById(2L);
        petTypeServiceMap.delete(type);
        assertEquals(2, petTypeServiceMap.findAll().size());
    }

    @Test
    void save() {
        Type type = Type.builder().build();
        petTypeServiceMap.save(type);
        assertEquals(4, petTypeServiceMap.findAll().size());
    }
}
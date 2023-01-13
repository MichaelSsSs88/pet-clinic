package dev.michaelssss88.petclinic.services.map;

import dev.michaelssss88.petclinic.models.Owner;
import dev.michaelssss88.petclinic.repositories.OwnerRepository;
import dev.michaelssss88.petclinic.services.PetService;
import dev.michaelssss88.petclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    @Mock
    PetTypeService petTypeService;

    @Mock
    PetService petService;

    @Mock
    OwnerRepository ownerRepository;

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerServiceMap= new OwnerServiceMap(petTypeService, petService);
        ownerServiceMap.save(Owner.builder().lastName("Juemialma").build());
        ownerServiceMap.save(Owner.builder().lastName("que duro").build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet= ownerServiceMap.findAll();
       /* ownerSet.forEach(owner -> {
            System.out.println(owner.getId());
        });*/
        assertEquals(2,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(3L);
        Set<Owner> ownerSet= ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(1L));
        assertEquals(2,ownerServiceMap.findAll().size());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().build();
        owner.setLastName("Solis");
        ownerServiceMap.save(owner);

        assertEquals(3,ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Owner owner= ownerServiceMap.findById(3L);
       assertEquals(3,owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().id(20L).firstName("Michael").lastName("Solis").city("quesada").telephone("29292203").build();
       // owner.setLastName("Solis");
        ownerServiceMap.save(owner);
       assertEquals("Solis",ownerServiceMap.findByLastName("Solis").getLastName());

    }

    @Test
    void findAllByLastNameLike() {
    }
}
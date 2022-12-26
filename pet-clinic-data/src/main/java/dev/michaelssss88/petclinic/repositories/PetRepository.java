package dev.michaelssss88.petclinic.repositories;

import dev.michaelssss88.petclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

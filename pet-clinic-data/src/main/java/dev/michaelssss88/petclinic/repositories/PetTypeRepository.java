package dev.michaelssss88.petclinic.repositories;

import dev.michaelssss88.petclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

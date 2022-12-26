package dev.michaelssss88.petclinic.repositories;

import dev.michaelssss88.petclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

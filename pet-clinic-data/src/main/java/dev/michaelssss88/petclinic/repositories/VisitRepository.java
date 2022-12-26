package dev.michaelssss88.petclinic.repositories;

import dev.michaelssss88.petclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

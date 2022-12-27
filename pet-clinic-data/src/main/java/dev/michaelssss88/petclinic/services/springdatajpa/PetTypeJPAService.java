package dev.michaelssss88.petclinic.services.springdatajpa;

import dev.michaelssss88.petclinic.models.Type;
import dev.michaelssss88.petclinic.repositories.PetTypeRepository;
import dev.michaelssss88.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
@Primary
public class PetTypeJPAService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Type> findAll() {
        Set<Type> types = new HashSet<>();
        petTypeRepository.findAll().forEach(types::add);
        return types;
    }

    @Override
    public Type findById(Long aLong) {
        Optional<Type> optionalType = petTypeRepository.findById(aLong);
        return optionalType.orElse(null);
    }

    @Override
    public Type save(Type object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(Type object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}

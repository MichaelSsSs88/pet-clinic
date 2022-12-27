package dev.michaelssss88.petclinic.services.springdatajpa;

import dev.michaelssss88.petclinic.models.Speciality;
import dev.michaelssss88.petclinic.repositories.SpecialityRepository;
import dev.michaelssss88.petclinic.services.SpecialitesService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@Primary
public class SpecialitesJPAService implements SpecialitesService {

    private  final SpecialityRepository specialityRepository;

    public SpecialitesJPAService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities= new HashSet<>();
        this.specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return this.specialityRepository.findById(aLong).isPresent()?this.specialityRepository.findById(aLong).get():null;
    }

    @Override
    public Speciality save(Speciality object) {
        return this.specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        this.specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.specialityRepository.deleteById(aLong);
    }
}

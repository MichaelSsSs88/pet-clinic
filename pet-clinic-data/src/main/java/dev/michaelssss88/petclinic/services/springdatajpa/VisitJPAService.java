package dev.michaelssss88.petclinic.services.springdatajpa;

import dev.michaelssss88.petclinic.models.Visit;
import dev.michaelssss88.petclinic.repositories.VisitRepository;
import dev.michaelssss88.petclinic.services.VisitService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@Primary
public class VisitJPAService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        this.visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return this.visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return this.visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        this.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.deleteById(aLong);
    }
}

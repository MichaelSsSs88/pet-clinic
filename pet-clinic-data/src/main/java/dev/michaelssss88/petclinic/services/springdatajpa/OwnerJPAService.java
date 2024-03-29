package dev.michaelssss88.petclinic.services.springdatajpa;

import dev.michaelssss88.petclinic.models.Owner;
import dev.michaelssss88.petclinic.repositories.*;
import dev.michaelssss88.petclinic.services.OwnerService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Profile("springdatajpa")
@Primary
public class OwnerJPAService implements OwnerService {


    private final OwnerRepository ownerRepository;
    private  final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    private final SpecialityRepository specialityRepository;
    private final VetRepository vetRepository;
    private final VisitRepository visitRepository;

    public OwnerJPAService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository, SpecialityRepository specialityRepository, VetRepository vetRepository, VisitRepository visitRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        this.specialityRepository = specialityRepository;
        this.vetRepository = vetRepository;
        this.visitRepository = visitRepository;
    }


    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners= new HashSet<>();
        ownerRepository.findAll().forEach(owner ->
            owners.add(owner)
        );
        return  owners;
    }

    @Override
    public Owner findById(Long aLong) {

        Optional<Owner> optionalOwner= ownerRepository.findById(aLong);
        return optionalOwner.orElse(null);
        /*if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }
        else{
            return null;
        }*/

    }

    @Override
    public Owner save(Owner object) {
        System.out.println("*******************");
        System.out.println(object.getCity());
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }
}

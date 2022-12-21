package dev.michaelssss88.petclinic.bootstrap;

import dev.michaelssss88.petclinic.models.*;
import dev.michaelssss88.petclinic.services.OwnerService;
import dev.michaelssss88.petclinic.services.PetService;
import dev.michaelssss88.petclinic.services.PetTypeService;
import dev.michaelssss88.petclinic.services.VetService;
import dev.michaelssss88.petclinic.services.SpecialitesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;



@Component
public class DataLoader  implements CommandLineRunner {
    private final OwnerService ownerService;
    private  final PetTypeService petTypeService;
    private  final PetService petService;

    private final VetService vetService;

    private final SpecialitesService specialitesService;

    public DataLoader(OwnerService ownerService, PetTypeService petTypeService, PetService petService, VetService vetService, SpecialitesService specialitesService) {
        /*this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();    */
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.vetService = vetService;
        this.specialitesService = specialitesService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        Pet pet = new Pet();
        pet.setPetType(savedDog);
        pet.setBirthDate(LocalDate.now());
        pet.setName("Rosco");

        Pet pet1 = new Pet();
        pet1.setPetType(savedCat);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Fionna");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialitesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialitesService.save(dentistry);

        Owner owner1= new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Westonm");
        owner1.setAddress("300m west from the supermarket");
        owner1.setCity("London");
        owner1.setTelephone("0393029903409");
        owner1.getPets().add(pet);

        ownerService.save(owner1);


        Owner owner2= new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");
        owner2.setAddress("300m west from the butchery");
        owner2.setCity("Miami");
        owner2.setTelephone("23893293923");
        owner2.getPets().add(pet1);

        ownerService.save(owner2);
        System.out.println("Load owners");
        Vet vet1= new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);

        vetService.save(vet1);

        Vet vet2= new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Jake");
        vet2.setLastName("Brown");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        Vet vet3= new Vet();
        //vet3.setId(3L);
        vet3.setFirstName("Milaidy");
        vet3.setLastName("Waston");
        vet3.getSpecialities().add(dentistry);
        vetService.save(vet3);
        Vet vet4= new Vet();
        //vet3.setId(3L);
        vet4.setFirstName("Ruty");
        vet4.setLastName("Waston");

        vetService.save(vet4);
        System.out.println("Loud vets");
    }
}

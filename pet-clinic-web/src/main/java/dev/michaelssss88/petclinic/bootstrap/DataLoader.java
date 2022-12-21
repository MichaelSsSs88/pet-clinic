package dev.michaelssss88.petclinic.bootstrap;

import dev.michaelssss88.petclinic.models.Owner;
import dev.michaelssss88.petclinic.models.Pet;
import dev.michaelssss88.petclinic.models.PetType;
import dev.michaelssss88.petclinic.models.Vet;
import dev.michaelssss88.petclinic.services.OwnerService;
import dev.michaelssss88.petclinic.services.PetService;
import dev.michaelssss88.petclinic.services.PetTypeService;
import dev.michaelssss88.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;



@Component
public class DataLoader  implements CommandLineRunner {
    private final OwnerService ownerService;
    private  final PetTypeService petTypeService;
    private  final PetService petService;

    private final VetService vetService;

    public DataLoader(OwnerService ownerService, PetTypeService petTypeService, PetService petService, VetService vetService) {
        /*this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();    */
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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

        vetService.save(vet1);

        Vet vet2= new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Jake");
        vet2.setLastName("Brown");

        vetService.save(vet2);

        Vet vet3= new Vet();
        //vet3.setId(3L);
        vet3.setFirstName("Milaidy");
        vet3.setLastName("Waston");

        vetService.save(vet3);
        Vet vet4= new Vet();
        //vet3.setId(3L);
        vet4.setFirstName("Ruty");
        vet4.setLastName("Waston");

        vetService.save(vet4);
        System.out.println("Loud vets");
    }
}

package dev.michaelssss88.petclinic.bootstrap;

import dev.michaelssss88.petclinic.models.Owner;
import dev.michaelssss88.petclinic.models.Vet;
import dev.michaelssss88.petclinic.services.OwnerService;
import dev.michaelssss88.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        /*this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();    */
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1= new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Westonm");

        ownerService.save(owner1);


        Owner owner2= new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");

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
        System.out.println("Loud vets");
    }
}

package dev.michaelssss88.petclinic.controllers;

import dev.michaelssss88.petclinic.models.Owner;
import dev.michaelssss88.petclinic.models.Pet;
import dev.michaelssss88.petclinic.models.Type;
import dev.michaelssss88.petclinic.services.OwnerService;
import dev.michaelssss88.petclinic.services.PetService;
import dev.michaelssss88.petclinic.services.PetTypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {


    private final PetTypeService petTypeService;

    private final PetService petService;
    private final OwnerService ownerService;

    public PetController(PetTypeService petTypeService, PetService petService, OwnerService ownerServiceMap) {
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.ownerService = ownerServiceMap;
    }

    @ModelAttribute("types")
    public Collection<Type> popularPetTypes(){
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId){
        return this.ownerService.findById(ownerId);
    }

    @ModelAttribute("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model){
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner,Pet pet, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }

        //owner.getPets().add(pet);
        if (result.hasErrors()) {
            model.put("pet", pet);
            return  "pets/createOrUpdatePetForm";
        } else {
            pet.setOwner(owner);
           // owner.getPets().add(pet);
            ownerService.save(owner);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return "pets/createOrUpdatePetForm";
        } else {

            pet.setOwner(owner);
            //owner.getPets().add(pet);
           // ownerService.save(owner);
            petService.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }

}

package dev.michaelssss88.petclinic.controllers;

import dev.michaelssss88.petclinic.models.Owner;
import dev.michaelssss88.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"/","/index", "/index.html"})
    public String index(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
       ModelAndView mav = new ModelAndView("owners/ownerDetails");
       mav.addObject(ownerService.findById(ownerId));
       return  mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Map<String, Object> model){
        Owner owner = new Owner();
        model.put("owner",owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@Validated Owner owner, BindingResult result){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }else{
            this.ownerService.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateForm(@PathVariable("ownerId") Long ownerId, Model model){
        System.out.println(ownerId);
        Owner owner = this.ownerService.findById(ownerId);
        System.out.println(owner);
        model.addAttribute(owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateForm(@Validated Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }else{
            this.ownerService.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }





    @RequestMapping("/find")
    public String findOwner(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");
        System.out.println(results.size());
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }
}

package dev.michaelssss88.petclinic.controllers;

import ch.qos.logback.core.model.processor.ModelHandlerException;
import dev.michaelssss88.petclinic.exceptions.NotFoundException;
import dev.michaelssss88.petclinic.models.Owner;
import dev.michaelssss88.petclinic.services.OwnerService;
import jakarta.validation.Valid;
import jakarta.ws.rs.InternalServerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.thymeleaf.exceptions.TemplateInputException;
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Slf4j
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
        try {   ModelAndView mav=null;
            // log.debug("Deleting id: " + ownerId);
            mav= new ModelAndView("owners/ownerDetails");
            mav.addObject(ownerService.findById(ownerId));
            //model.addAttribute("owner", ownerService.findById(ownerId));
            //return "owners/ownerDetails";
            return  mav;}catch(Exception e){
            return handleNotFound(e);
        }

    }

    @GetMapping("/new")
    public String initCreationForm(Map<String, Object> model){
        Owner owner = new Owner();
        model.put("owner",owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid @ModelAttribute("owner") Owner owner, BindingResult result){
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

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView("404error");

      //  modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);


        return modelAndView;
    }

   /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNotRequest(Exception exception){

        log.error("Handling number format exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView("400error");

        //  modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);


        return modelAndView;
    }*/
}

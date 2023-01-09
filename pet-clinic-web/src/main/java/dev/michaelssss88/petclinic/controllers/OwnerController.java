package dev.michaelssss88.petclinic.controllers;

import dev.michaelssss88.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"","/","/index", "/index.html"})
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
}

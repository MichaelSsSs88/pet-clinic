package dev.michaelssss88.petclinic.formatters;


import dev.michaelssss88.petclinic.models.Type;
import dev.michaelssss88.petclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by jt on 9/22/18.
 */
@Component
public class PetTypeFormatter implements Formatter<Type> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(Type petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public Type parse(String text, Locale locale) throws ParseException {
        Collection<Type> findPetTypes = petTypeService.findAll();

        for (Type type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}

package dev.michaelssss88.petclinic.services.map;

import dev.michaelssss88.petclinic.models.Type;
import dev.michaelssss88.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<Type, Long> implements PetTypeService {
    @Override
    public Set<Type> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Type object) {
        super.delete(object);
    }

    @Override
    public Type save(Type object) {
        return super.save(object);
    }

    @Override
    public Type findById(Long id) {
        return super.findById(id);
    }
}

package dev.michaelssss88.petclinic.services.map;

import dev.michaelssss88.petclinic.models.Owner;
import dev.michaelssss88.petclinic.services.CrudService;
import dev.michaelssss88.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OwnerServiceMap extends  AbstractMapService<Owner,Long> implements OwnerService{
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
    super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }
}

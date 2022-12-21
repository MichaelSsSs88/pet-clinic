package dev.michaelssss88.petclinic.services.map;

import dev.michaelssss88.petclinic.models.Speciality;
import dev.michaelssss88.petclinic.services.SpecialitesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialitesServiceMap extends AbstractMapService<Speciality, Long>  implements SpecialitesService {
    @Override
    public Set<Speciality> findAll() {
        return  super.findAll();
    }

    @Override
    public Speciality findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);

    }
}

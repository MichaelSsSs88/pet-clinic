package dev.michaelssss88.petclinic.services.map;

import dev.michaelssss88.petclinic.models.Visit;
import dev.michaelssss88.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    /*private final VisitService visitService;

    public VisitServiceMap(VisitService visitService) {
        this.visitService = visitService;
    }*/

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit object) {
        int x=1;
        if (object.getPet()==null ){
            throw new RuntimeException("Invalid visit");
        }else if(object.getPet().getOwner()==null||object.getPet().getOwner().getId()==null ||object.getPet().getId()==null){
            throw new RuntimeException("Invalid visit");
        }

        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}

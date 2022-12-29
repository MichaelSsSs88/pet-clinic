package dev.michaelssss88.petclinic.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class Type extends BaseEntity{
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private Set<Pet> pets = new HashSet<>();

  /*  public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}

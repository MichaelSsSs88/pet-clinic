package dev.michaelssss88.petclinic.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{


    @Builder
    public Pet(Long id, String name, Type type, Owner owner, Set<Visit> visits, LocalDate birthDate) {
        super(id);
        this.name = name;
        this.type = type;
        this.owner = owner;
        this.visits = visits;
        this.birthDate = birthDate;
    }

    /*public Pet(String name, Type type, Owner owner, Set<Visit> visits, LocalDate birthDate) {
        this.name = name;
        this.type = type;
        this.owner = owner;
        this.visits = visits;
        this.birthDate = birthDate;
    }*/

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @Column(name = "birth_date")
    private LocalDate birthDate;
    public Type getPetType() {
        return type;
    }

    public void setPetType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pet{}";
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}

package dev.michaelssss88.petclinic.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity{

    /*public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/

    @Column(name = "description")
    private String description;

}

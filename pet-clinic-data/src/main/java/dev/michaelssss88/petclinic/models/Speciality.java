package dev.michaelssss88.petclinic.models;

public class Speciality extends BaseEntity{

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

}

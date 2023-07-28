package dev.michaelssss88.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan(basePackages ="dev.michaelssss88.petclinic.services")
@SpringBootApplication
//@EntityScan(basePackages = "dev.michaelssss88.petclinic.models")
//@EnableJpaRepositories(basePackages = "dev.michaelssss88.petclinic.repositories")
public class PetClinicApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(PetClinicApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PetClinicApplication.class);
    }
}

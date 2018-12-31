package tn.enis.gestion_des_medecins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.enis.gestion_des_medecins.entities.Role;
import tn.enis.gestion_des_medecins.entities.User;

import java.awt.*;
import java.util.Collection;

@SpringBootApplication
public class GestionDesMedecinsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDesMedecinsApplication.class, args);
    }
}

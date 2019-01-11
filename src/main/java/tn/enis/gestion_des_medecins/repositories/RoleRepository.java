package tn.enis.gestion_des_medecins.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.gestion_des_medecins.entities.Role;


public interface RoleRepository extends JpaRepository<Role, String> {

}
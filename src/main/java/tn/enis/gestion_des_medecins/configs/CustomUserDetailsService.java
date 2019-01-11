package tn.enis.gestion_des_medecins.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.enis.gestion_des_medecins.entities.Medecin;
import tn.enis.gestion_des_medecins.exeptions.ResourceNotFoundException;
import tn.enis.gestion_des_medecins.repositories.MedecinRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MedecinRepository medecinRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Medecin user = medecinRepository.findByEmail(usernameOrEmail);
        if (user == null)
            new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail);

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Medecin user = (Medecin) medecinRepository.findById(id).get();
        if (user == null) {
            throw new ResourceNotFoundException("User", "id", id);
        }

        return UserPrincipal.create(user);
    }

}
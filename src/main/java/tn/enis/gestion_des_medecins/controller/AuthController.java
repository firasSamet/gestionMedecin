package tn.enis.gestion_des_medecins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.enis.gestion_des_medecins.configs.JwtAuthenticationResponse;
import tn.enis.gestion_des_medecins.configs.JwtTokenProvider;
import tn.enis.gestion_des_medecins.entities.Medecin;
import tn.enis.gestion_des_medecins.entities.MedecinGeneraliste;
import tn.enis.gestion_des_medecins.entities.MedecinSpecialiste;
import tn.enis.gestion_des_medecins.repositories.MedecinGenarlisteRepository;
import tn.enis.gestion_des_medecins.repositories.MedecinRepository;
import tn.enis.gestion_des_medecins.repositories.MedecinSpecialisteRepository;
import tn.enis.gestion_des_medecins.utils.ApiResponse;
import tn.enis.gestion_des_medecins.utils.LoginRequest;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MedecinGenarlisteRepository medecinGenarlisteRepository;
    @Autowired
    MedecinSpecialisteRepository medecinSpecialisteRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Medecin medecin) {


        if (medecinGenarlisteRepository.existsByEmail(medecin.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }


        medecin.setPassword(passwordEncoder.encode(medecin.getPassword()));

        if (medecin.getType().equals("MG")) {
            MedecinGeneraliste result = new MedecinGeneraliste();
            result.setNom(medecin.getNom());
            result.setPrenom(medecin.getPrenom());
            result.setEmail(medecin.getEmail());
            result.setPassword(medecin.getPassword());
            result.setType(medecin.getType());
            medecinGenarlisteRepository.saveAndFlush(result);
        }

        if (medecin.getType().equals("MS")) {
            MedecinSpecialiste result = new MedecinSpecialiste();
            result.setNom(medecin.getNom());
            result.setPrenom(medecin.getPrenom());
            result.setEmail(medecin.getEmail());
            result.setPassword(medecin.getPassword());
            result.setType(medecin.getType());
            medecinSpecialisteRepository.save(result);
        }


        return ResponseEntity.accepted()
                .body(new ApiResponse(true, "User registered successfully"));
    }
}
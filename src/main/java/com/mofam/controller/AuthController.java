package com.mofam.controller;

import com.mofam.Exception.BadRequestException;
import com.mofam.Exception.ResourceNotFoundException;
import com.mofam.dao.*;
import com.mofam.entities.AuthProvider;
import com.mofam.entities.Role;
import com.mofam.entities.RoleEnum;
import com.mofam.entities.Utilisateur;
import com.mofam.payload.*;
import com.mofam.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenProvider tokenProvider;
    
    @PostConstruct
    public void initialisation() {
    	System.out.println("Création auth controller");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @RequestMapping(value = "/admin/signup", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (utilisateurRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Cet adresse email est déjà utilisé.");
        }

        // Creating user's account
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(signUpRequest.getPrenom());
        utilisateur.setNom(signUpRequest.getNom());
        utilisateur.setEmail(signUpRequest.getEmail());
        utilisateur.setPassword(signUpRequest.getPassword());
        utilisateur.setActived(true);
        utilisateur.setProvider(AuthProvider.local);
        utilisateur.setProviderId("1");
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        Utilisateur result = utilisateurRepository.save(utilisateur);
        addRoleToUser(result.getId(),RoleEnum.PRESTATAIRE.getId());

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/currentUser")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Utilisateur crée avec succé"));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/admin/newRole", method = RequestMethod.POST)
    public Role saveRole(@Valid @RequestBody RoleRequest roleRequest) {
        if (roleRepository.existsByNom(roleRequest.getNom())) {
            throw new BadRequestException("Ce rôle est déjà enregistré.");
        }

        Role role = new Role();
        role.setNom(roleRequest.getNom());
        role.setDescription(roleRequest.getDescription());

        return roleRepository.save(role);
    }

    @RequestMapping(value = "/admin/addRoleToUser", method = RequestMethod.POST)
    public void addRoleToUser(Long idUtilisateur, Long idRole) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
        		.orElseThrow(() -> new ResourceNotFoundException("Utilisateur"," introuvable ou inexistante",idUtilisateur));
        Role role = roleRepository.findById(idRole)
        		.orElseThrow(() -> new ResourceNotFoundException("Rôle"," introuvable ou inexistante",idRole));
        utilisateur.getRoles().add(role);
    }
    
    @RequestMapping(value = "/admin/listeRole", method = RequestMethod.GET)
    public List<Role> listeRole(){
    	return roleRepository.findAll();
    }
    
    @RequestMapping(value = "/admin/deleteRole", method = RequestMethod.DELETE)
    public void deleteRole(Long id) {
    	Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role"," introuvable ou inexistante",id));
    	roleRepository.delete(role);
    }
    
    @PreDestroy
    public void destruction() {
    	System.out.println("Destruction auth controller");
    }
}

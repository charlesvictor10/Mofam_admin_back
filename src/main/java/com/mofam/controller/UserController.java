package com.mofam.controller;

import com.mofam.Exception.ResourceNotFoundException;
import com.mofam.dao.UtilisateurRepository;
import com.mofam.entities.Utilisateur;
import com.mofam.security.CurrentUser;
import com.mofam.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    @GetMapping(value = "/admin/currentUser")
    public Utilisateur getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return utilisateurRepository.findById(userPrincipal.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", userPrincipal.getId()));
    }
}

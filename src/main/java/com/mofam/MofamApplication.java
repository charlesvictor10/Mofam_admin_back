package com.mofam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mofam.config.AppProperties;
import com.mofam.dao.UtilisateurRepository;
import com.mofam.entities.Utilisateur;
import com.mofam.service.ProduitMetierImpl;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class MofamApplication implements CommandLineRunner{
	@Autowired
	UtilisateurRepository user;
	
	public static void main(String[] args) {
		SpringApplication.run(MofamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//user.save(new Utilisateur("admin@admin.com", new BCryptPasswordEncoder().encode("Passer"), "admin", "admin"));
	}
}

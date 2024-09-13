package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")	//desta forma o Spring consegue identificar que vamos rodar esta implementacao apenas quadno estiver no perfil de test
public class TestConfig implements CommandLineRunner{

	@Autowired	//com isto, o Spring qunado tiver a rodar a app, vai resolver esta dependencia e associar uma instancia de um repository aqui dentro
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));	//salvar a lista na base de dados
		
	}
	
	
}

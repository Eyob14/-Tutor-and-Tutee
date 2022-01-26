package Tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import Tutorial.mainClasses.User;
import Tutorial.repository.UserRepository;
import Tutorial.mainClasses.User.Gender;
import Tutorial.mainClasses.User.Role;

@SpringBootApplication

public class TutorAndTuteeApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepo;

	@Autowired	
	PasswordEncoder passwordEncoder;

	@Override
	// @Bean
	public void run(String... args) throws Exception {

		if (userRepo.findByRole(Role.ADMIN) == null) {
			User admin = new User();
			admin.setPassword(passwordEncoder.encode("admin"));
			admin.setUsername("admin");
			admin.setFirstName("ADMIN");
			admin.setLastName("ADMIN");
			admin.setEmail("admin12@gmail.com");
			admin.setRole(Role.ADMIN);
			admin.setPhone("0947408989");
			admin.setGender(Gender.MALE);
			userRepo.save(admin);
		}
		 
	}

	public static void main(String[] args) {
		SpringApplication.run(TutorAndTuteeApplication.class, args);

	}

}

package Tutorial.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Tutorial.mainClasses.RegistrationForm;
import Tutorial.mainClasses.TuteeProfile;
import Tutorial.mainClasses.TutorProfile;
import Tutorial.mainClasses.User.Role;
import Tutorial.repository.TuteeProfileRepository;
import Tutorial.repository.TutorProfileRepository;
import Tutorial.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepo;
    private final TutorProfileRepository tutorProfileRepository;
    private final TuteeProfileRepository tuteeProfileRepository;
    private final PasswordEncoder passwordEncoder;

    public String saveTutor(RegistrationForm registrationForm){
        var user = registrationForm.toUser(passwordEncoder);
        user.setRole(Role.TUTOR);
        userRepo.save(user);
        var profile = new TutorProfile();
        profile.setUser(user);
        tutorProfileRepository.save(profile);
        return "redirect:/login";
    }

    public String saveTutee(RegistrationForm registrationForm){

        var user = registrationForm.toUser(passwordEncoder);
        user.setRole(Role.TUTEE);
        userRepo.save(user);
        var profile = new TuteeProfile();
        profile.setUser(user);
        tuteeProfileRepository.save(profile);
        return "redirect:/login";

    }

    
}

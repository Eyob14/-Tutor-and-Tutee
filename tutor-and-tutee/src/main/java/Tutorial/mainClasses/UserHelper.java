package Tutorial.mainClasses;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.password.PasswordEncoder;

// import Tutorial.mainClasses.TutorProfile.Level;
import Tutorial.mainClasses.TutorProfile.Course;
// import Tutorial.mainClasses.TutorProfile;
import Tutorial.mainClasses.TutorProfile.Level;
import Tutorial.mainClasses.User.Gender;
import Tutorial.mainClasses.User.Location;
import Tutorial.mainClasses.User.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHelper {

    

    @NotBlank(message="first name is required")  
    private String firstName;


    @NotBlank(message="last name is required")  
    private String lastName;


    @NotBlank(message="username is required")  
    private String username;

    @Email(message = "email must include @")
    @NotBlank(message="email is required")  
    private String email;


    @NotBlank(message="phone number is required")  
    private String phone;

    private Long id;

    
    @NotBlank(message="password is required")  
    private String password;

    private Gender gender;


    private Location location;

    private Course course;

    private String description;

    private Level level;

    private Role role;

    
    public User toUser(PasswordEncoder encoder){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setLocation(location);
        user.setRole(role);
        return user;
    }

    public TutorProfile tProfile(){
        TutorProfile tutorProfile = new TutorProfile();
        tutorProfile.setCourse(course);
        tutorProfile.setLevel(level);
        tutorProfile.setDescription(description);
        return tutorProfile;
    }
}

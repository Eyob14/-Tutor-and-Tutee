package Tutorial.mainClasses;

import org.springframework.security.crypto.password.PasswordEncoder;

import Tutorial.mainClasses.User.Gender;
import Tutorial.mainClasses.User.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminAddUserForm {    

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private String password;
    private Gender gender;
    private Role role;
    
    public User toUser(PasswordEncoder encoder){
        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(encoder.encode(password));
        user.setGender(gender);
        user.setRole(role);
        return user;
    }
}

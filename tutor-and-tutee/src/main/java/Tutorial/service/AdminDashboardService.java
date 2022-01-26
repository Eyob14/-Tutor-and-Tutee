package Tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Tutorial.mainClasses.AdminAddUserForm;
import Tutorial.mainClasses.User;
import Tutorial.mainClasses.UserHelper;
import Tutorial.repository.TuteeProfileRepository;
import Tutorial.repository.TutorProfileRepository;
import Tutorial.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
// @NoArgsConstructor
@AllArgsConstructor
public class AdminDashboardService {
    @Autowired
    private UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final TutorProfileRepository tutorProfileRepository;
    private final TuteeProfileRepository tuteeProfileRepository;

    public String addUser(@ModelAttribute AdminAddUserForm adminAddUserForm) {
        return "addUserForm";
    }

    public ModelAndView showUpdateForm(Long userId, UserHelper userHelper) {
        ModelAndView mav = new ModelAndView("edituser");
        mav.addObject("userId", userId);
        User user = userRepo.findById(userId).get();
        userHelper.setFirstName(user.getFirstName());
        userHelper.setLastName(user.getLastName());
        userHelper.setUsername(user.getUsername());
        userHelper.setEmail(user.getEmail());
        userHelper.setPhone(user.getPhone());
        userHelper.setGender(user.getGender());
        userHelper.setPassword(user.getPassword());
        userHelper.setRole(user.getRole());
        mav.addObject("EditByAdmin", userHelper);

        return mav;

    }

    public String saveUser(Long userId, User user, UserHelper userHelper) {
        user = userRepo.findById(userId).get();
        user.setFirstName(userHelper.getFirstName());
        user.setLastName(userHelper.getLastName());
        user.setEmail(userHelper.getEmail());
        user.setUsername(userHelper.getUsername());
        user.setPhone(userHelper.getPhone());
        user.setLocation(userHelper.getLocation());
        user.setGender(userHelper.getGender());
        user.setPassword(encoder.encode(userHelper.getPassword()));
        userRepo.save(user);
        return "redirect:/adminDashBoard";
    }

    public String deleteUsers(@RequestParam Long userId) {
        userRepo.deleteById(userId);
        return "redirect:/adminDashBoard";
    }

}

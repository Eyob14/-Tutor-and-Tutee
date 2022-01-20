package Tutorial.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/tutorsignup")
    public ModelAndView tutorSignup() {
        return new ModelAndView("tutor_signup");
    }

    @GetMapping("/tuteesignup")
    public ModelAndView tuteeSignup() {
        return new ModelAndView("tutee_signup");
    }

    @GetMapping("/tutor")
    public ModelAndView tutorProfile() {
        return new ModelAndView("tutor_profile");
    }

    @GetMapping("/tutee")
    public ModelAndView tuteeProfile() {
        return new ModelAndView("tutee_profile");
    }

    @GetMapping("/tutors")
    public ModelAndView tutors() {
        return new ModelAndView("tutors");
    }

    @GetMapping("/edittutor")
    public ModelAndView editTutorProfile() {
        return new ModelAndView("edit_tutor_profile");
    }

    @GetMapping("/edittutee")
    public ModelAndView editTuteeProfile() {
        return new ModelAndView("edit_tutee_profile");
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:";
    }

    @GetMapping("/deleteaccount")
    public ModelAndView deleteAccount() {
        return new ModelAndView("delete_account");
    }

    @GetMapping("/test")
    public ModelAndView test() {
        return new ModelAndView("test");
    }
}

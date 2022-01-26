package Tutorial.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import Tutorial.mainClasses.RegistrationForm;
import Tutorial.service.UserService;
import lombok.AllArgsConstructor;
@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/error")
    public ModelAndView error(){
        ModelAndView model=new ModelAndView("errorPage");
        return model;
    }

    @GetMapping("/tutorsignup")
    public String tutorRegisterForm(@ModelAttribute RegistrationForm registrationForm) {
        return "tutorSignup";
    }

    @PostMapping("/savetutor")
    public String saveTutor(@Valid @ModelAttribute RegistrationForm registrationForm, Errors errors) {
        if (errors.hasErrors()){
            return "tutorSignup";
        }
        return userService.saveTutor(registrationForm);
    }

    @GetMapping("/tuteesignup")
    public String tuteeRegisterForm(@ModelAttribute RegistrationForm registrationForm) {
        return "tuteeSignup";
    }

    @PostMapping("/savetutee")
    public String saveTutee(@Valid @ModelAttribute RegistrationForm registrationForm, Errors errors) {
        if (errors.hasErrors()){
            return "tuteeSignup";
        }
        return userService.saveTutee(registrationForm);
    }
}



package Tutorial.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TutorSignupController {
    @GetMapping("/tutorSignup")
    public String tutorSignup() {

        return "tutorSignup";
    }
}

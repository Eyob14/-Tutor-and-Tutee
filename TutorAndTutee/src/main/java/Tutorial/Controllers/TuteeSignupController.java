package Tutorial.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TuteeSignupController {
    
    @GetMapping("/tuteeSignup")
    public String tuteeSignup() {

        return "tuteeSignup";
    }
}

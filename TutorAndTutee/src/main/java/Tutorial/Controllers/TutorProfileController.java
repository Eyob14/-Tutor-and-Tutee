package Tutorial.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TutorProfileController {
    @GetMapping("/tutorProfileController")
    public String tutorProfile() {

        return "tutorProfile";
    }
}

package Tutorial.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TuteeProfileController {

    @GetMapping("/TuteeProfile")
    public String tuteeProfile() {
    
        return "tuteeProfile";
    }
}

package Tutorial.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Tutorial.mainClasses.RegistrationForm;
import Tutorial.mainClasses.TutorProfile;
import Tutorial.mainClasses.User;
import Tutorial.mainClasses.UserHelper;
import Tutorial.service.TutorProfileService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TutorProfileController {

    @Autowired
    private final TutorProfileService tutorProfileService;
    
    @GetMapping("/displayTutorProfile")
    public ModelAndView viewTutorProfile( @AuthenticationPrincipal User user){
        return tutorProfileService.viewTutorProfile(user);
    }

    @GetMapping("/editTutorProfile")
    public ModelAndView editTutorProfile(@RequestParam Long userId, @RequestParam Long tutorId, UserHelper userHelper ){ 
        return tutorProfileService.editTutorProfile(userId, tutorId, userHelper);
    }
    
    
    @PostMapping("/saveprofile")
    public String saveTutor(@AuthenticationPrincipal User user, @ModelAttribute("tutor") UserHelper userHelper){
        return tutorProfileService.saveTutor(user, userHelper);
    }

    @PostMapping("/deleteTutor")
    public String deleteTutee(@RequestParam Long tutorId){
        return tutorProfileService.deleteUsers(tutorId);
    }
    

    @PostMapping("/deleteTutorAccount/{id}")
    public ModelAndView deleteTutorAccount(@PathVariable String id) {
        return new ModelAndView("/deleteTutorAccount", "userId", id);
    }
    
}
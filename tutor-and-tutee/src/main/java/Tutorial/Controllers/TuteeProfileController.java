package Tutorial.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Tutorial.mainClasses.SearchTutor;
import Tutorial.mainClasses.TuteeProfile;
import Tutorial.mainClasses.User;
import Tutorial.mainClasses.UserHelper;
import Tutorial.repository.TuteeProfileRepository;
import Tutorial.repository.UserRepository;
import Tutorial.service.TuteeProfileService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller

public class TuteeProfileController {

    @Autowired
    private final TuteeProfileRepository tuteeProfileRepository;
    private final TuteeProfileService tuteeProfileService;
    private final UserRepository userRepo;




    @GetMapping("/displayTuteeProfile")
    public ModelAndView viewTuteeProfile(@AuthenticationPrincipal User user) { 
        return tuteeProfileService.viewTuteeProfile(user);
    }

    @GetMapping("/editTuteeProfile")
    public ModelAndView editTutorProfile(@RequestParam Long userId, @RequestParam Long tuteeId, UserHelper userHelper) {

        return tuteeProfileService.editTutorProfile(userId,tuteeId, userHelper);
    }

    @PostMapping("/saveTuteeprofile")
    public String saveTutee(@AuthenticationPrincipal User user, @ModelAttribute("tutee") UserHelper userHelper) {
        
        return tuteeProfileService.saveTutee(user, userHelper);

        }

    @PostMapping("deleteTutee")
    public String deleteTutee(@RequestParam Long tuteeId, @AuthenticationPrincipal User user){
        return tuteeProfileService.deleteUsers(tuteeId);
    }
      

    @PostMapping(path = "/Searched")
    public ModelAndView search(@AuthenticationPrincipal User user, @ModelAttribute SearchTutor searchTutor) {
        return tuteeProfileService.search(user, searchTutor);
    }

    @PostMapping("/send-request/{id}")
    public String sendRequest(@PathVariable String id, @AuthenticationPrincipal User user) {
        return tuteeProfileService.sendRequest(id, user);
    }

    @PostMapping("/deleteTuteeAccount/{id}")
    public ModelAndView deleteTuteeAccount(@PathVariable String id) {
        return new ModelAndView("/deleteTuteeAccount", "userId", id);
    }

    @GetMapping("/requestSuccess")
    public String requestSuccess() {
        return "successTeller";
    }

}

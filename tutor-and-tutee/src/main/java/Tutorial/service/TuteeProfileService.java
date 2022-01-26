package Tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Tutorial.mainClasses.Request;
import Tutorial.mainClasses.SearchTutor;
import Tutorial.mainClasses.TuteeProfile;
import Tutorial.mainClasses.TutorProfile;
import Tutorial.mainClasses.User;
import Tutorial.mainClasses.UserHelper;
import Tutorial.repository.RequestRepo;
import Tutorial.repository.TuteeProfileRepository;
import Tutorial.repository.TutorProfileRepository;
import Tutorial.repository.UserRepository;

import java.util.*;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor


@Service
public class TuteeProfileService {

    @Autowired
    private final TuteeProfileRepository tuteeProfileRepository;
    private final RequestRepo requestRepo;
    private final UserRepository userRepo;
    private final TutorProfileRepository tutorProfileRepository;
    private final PasswordEncoder encoder;

    public ModelAndView viewTuteeProfile(@AuthenticationPrincipal User user) {

        ModelAndView mav = new ModelAndView("displayTuteeProfile");
        TuteeProfile tProfile = user.getTuteeProfile();
        List<TutorProfile> randomTutor = tutorProfileRepository.findAll();

        mav.addObject("TuteeProfileModel", tProfile);
        mav.addObject("Query", new SearchTutor());
        mav.addObject("Tutors", randomTutor);
      
        return mav;
    }

    public ModelAndView editTutorProfile(@RequestParam Long userId, @RequestParam Long tuteeId, UserHelper userHelper) {
        
        ModelAndView mav = new ModelAndView("tuteeProfile");
        User tuteeUser = userRepo.findById(userId).get();
        TuteeProfile tProfile = tuteeProfileRepository.findById(tuteeId).get();

        userHelper.setFirstName(tuteeUser.getFirstName());
        userHelper.setLastName(tuteeUser.getLastName());
        userHelper.setEmail(tuteeUser.getEmail());
        userHelper.setGender(tuteeUser.getGender());
        userHelper.setLocation(tuteeUser.getLocation());
        userHelper.setPhone(tuteeUser.getPhone());
        userHelper.setUsername(tuteeUser.getUsername());
        userHelper.setPassword(tuteeUser.getPassword());
        mav.addObject("tuteeProfile", userHelper);

        return mav;
    }

        public String saveTutee(@AuthenticationPrincipal User user, UserHelper userHelper){
            
            var profile = user.getTuteeProfile();
            user.setFirstName(userHelper.getFirstName());
            user.setLastName(userHelper.getLastName());
            user.setEmail(userHelper.getEmail());
            user.setUsername(userHelper.getUsername());
            user.setPhone(userHelper.getPhone());
            user.setLocation(userHelper.getLocation());
            user.setPassword(encoder.encode(userHelper.getPassword()));
            userRepo.save(user);
            tuteeProfileRepository.save(profile);

            return "redirect:/displayTuteeProfile";
        }

    

    public ModelAndView search(@AuthenticationPrincipal User user, @ModelAttribute SearchTutor searchTutor) {
        
        TuteeProfile tProfile = user.getTuteeProfile();
        ModelAndView model = new ModelAndView("displayTuteeProfile");
        List<TutorProfile> tutors = tutorProfileRepository.searchByLevelAndCourse(searchTutor.getLevel(), searchTutor.getCourse());
        
        model.addObject("TuteeProfileModel", tProfile);
        model.addObject("Query", new SearchTutor());
        model.addObject("Tutors", tutors);
        
        return model;

    }
    public String sendRequest(@PathVariable String id, @AuthenticationPrincipal User user) {
        
        TutorProfile currentTutor = tutorProfileRepository.findById(Long.parseLong(id)).get();
        Request rq = new Request();
        TuteeProfile tuteeProfile = user.getTuteeProfile();
        
        rq.setTutee(tuteeProfile.getId());
        rq.setTutor(currentTutor.getId());
        requestRepo.save(rq);
        
        return "redirect:/requestSuccess";
    }

    public String deleteUsers(Long tuteeId) {
        userRepo.deleteById(tuteeId);
        return "redirect:/login";
    }

}

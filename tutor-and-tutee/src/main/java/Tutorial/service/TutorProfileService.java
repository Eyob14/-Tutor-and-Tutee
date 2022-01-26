package Tutorial.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Tutorial.mainClasses.TuteeProfile;
import Tutorial.mainClasses.TutorProfile;
import Tutorial.mainClasses.User;
import Tutorial.mainClasses.UserHelper;
import Tutorial.repository.TuteeProfileRepository;
import Tutorial.repository.TutorProfileRepository;
import Tutorial.repository.UserRepository;
import Tutorial.repository.RequestRepo;




import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TutorProfileService {
    
    @Autowired
    private final TutorProfileRepository profileRepository;
    private final UserRepository userRepo;
    private final TuteeProfileRepository tuteeProfileRepository;
    private final RequestRepo requestRepo;
    private final PasswordEncoder encoder;



    public ModelAndView viewTutorProfile( @AuthenticationPrincipal User user){

        ModelAndView mav = new ModelAndView("displayTutorProfile");
        TutorProfile tProfile = user.getTutorProfile();

        long sendId = user.getTutorProfile().getId();
        Optional<List<Long>> tuteeIdList = requestRepo.search(sendId);
        List<Long> t = tuteeIdList.get();
        List<TuteeProfile> tuteeProfiles = new ArrayList<TuteeProfile>();

        for (Long tuteeId : t) { 
            tuteeProfiles.add(tuteeProfileRepository.searchfor(tuteeId));   
        }
        mav.addObject("TutorProfileModel", tProfile);
        mav.addObject("TuteeRequests", tuteeProfiles);

        return mav;
    }


    public ModelAndView editTutorProfile(@RequestParam Long userId, @RequestParam  Long tutorId,  UserHelper userHelper){
        ModelAndView mav = new ModelAndView("tutorProfile");
        User tutorUser = userRepo.findById(userId).get();
        TutorProfile tProfile = profileRepository.findById(tutorId).get();

        userHelper.setFirstName(tutorUser.getFirstName());
        userHelper.setLastName(tutorUser.getLastName());
        userHelper.setEmail(tutorUser.getEmail());
        userHelper.setGender(tutorUser.getGender());
        userHelper.setLocation(tutorUser.getLocation());
        userHelper.setPhone(tutorUser.getPhone());
        userHelper.setUsername(tutorUser.getUsername());
        userHelper.setCourse(tProfile.getCourse());
        userHelper.setLevel(tProfile.getLevel());
        userHelper.setDescription(tProfile.getDescription());
        userHelper.setPassword(tutorUser.getPassword());

    
        mav.addObject("tutorProfile", userHelper);
        return mav;
    }

    public String saveTutor(@AuthenticationPrincipal User user, UserHelper userHelper){
        var profile = user.getTutorProfile();

        profile.setCourse(userHelper.getCourse());
        profile.setDescription(userHelper.getDescription());
        profile.setLevel(userHelper.getLevel());
        user.setFirstName(userHelper.getFirstName());
        user.setLastName(userHelper.getLastName());
        user.setEmail(userHelper.getEmail());
        user.setUsername(userHelper.getUsername());
        user.setPhone(userHelper.getPhone());
        user.setLocation(userHelper.getLocation());
        user.setPassword(encoder.encode(userHelper.getPassword()));
        userRepo.save(user);
        profileRepository.save(profile);
        return "redirect:/displayTutorProfile";
    }

    public String deleteUsers(Long tutorId) {
        userRepo.deleteById(tutorId);
        return "redirect:/login";
    }

}

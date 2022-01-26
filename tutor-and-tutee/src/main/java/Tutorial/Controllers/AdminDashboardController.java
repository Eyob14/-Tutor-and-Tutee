package Tutorial.Controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Tutorial.mainClasses.User;
import Tutorial.mainClasses.UserHelper;
import Tutorial.mainClasses.AdminAddUserForm;
import Tutorial.repository.UserRepository;
import Tutorial.service.AdminDashboardService;

import java.util.*;

import lombok.AllArgsConstructor;


@Controller

@AllArgsConstructor
public class AdminDashboardController {
    @Autowired
    private final UserRepository userRepo;
    private final AdminDashboardService adminDashboardService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/adminDashBoard")
    public ModelAndView userDisplay() {
        ModelAndView adminModel = new ModelAndView("adminDashboard.html");
        List<User> list = userRepo.findAll();
        adminModel.addObject("ListOfUsers", list);
        return adminModel;
    }


    // @GetMapping("/adminDashBoard/addUsers")
    // public ModelAndView addUser(){
    //     ModelAndView mav = new ModelAndView("addUserForm");
    //     User newUser = new User();
    //     mav.addObject("User", newUser);
    //     return mav;
    // } 
    @GetMapping("/adminDashBoard/addUsers") 
    public String addUser(@ModelAttribute AdminAddUserForm adminAddUserForm) {
        return adminDashboardService.addUser(adminAddUserForm);
    }

    @PostMapping("/adminDashBoard/saveUser")
    public String saveCustomer(@ModelAttribute AdminAddUserForm adminAddUserForm){
        var user = adminAddUserForm.toUser(passwordEncoder);
        userRepo.save(user);
        return "redirect:/adminDashBoard";
    }

    @GetMapping("/adminDashBoard/updateUsers")
    public ModelAndView showUpdateForm(@RequestParam Long userId, @ModelAttribute UserHelper userHelper){

        return adminDashboardService.showUpdateForm(userId, userHelper);
    }


    @GetMapping("/adminDashBoard/deleteUsers")
    public String deleteUsers(@RequestParam Long userId){
        return adminDashboardService.deleteUsers(userId);
    
    }
    
    @PostMapping("adminDashBoard/saveprofile")
    public String saveTutor(@RequestParam Long userId,User user, @ModelAttribute("EditByAdmin") UserHelper userHelper){
        return adminDashboardService.saveUser(userId,user,userHelper);
    }

    
}

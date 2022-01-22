package com.group.tuteetutor.security;

import com.group.tuteetutor.model.Users;
import com.group.tuteetutor.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class RegistrationController {
 
    @Autowired
    private  UsersService userService;
     
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){

        model.addAttribute("user", new Users());

        return "signup_form";
    }

@GetMapping("/user")
public String listUsers(Model model) {
  model.addAttribute("users", userService.getAllUsers()); 
     
    return "users";
}

//    @GetMapping("/login")
//    public String loginPage(){
//        return "home";
//    }

    @PostMapping("/process_register")
    public String processRegister(Users user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userService.addUser(user);

        return "register_success"; 

    }
}
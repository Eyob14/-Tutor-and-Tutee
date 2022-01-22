// package com.group.tuteetutor.controller;

// import com.group.tuteetutor.model.Users;
// import com.group.tuteetutor.service.UsersService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;

// @Controller
// public class UserController {

//     @Autowired
//     private UsersService userService;

//     @GetMapping("/")
//     public String showRegistrationForm(Model model) {

//         model.addAttribute("user", new Users());

//         return "signup_form";
//     }


//     @PostMapping("/process_register")
//     public String processRegister(Users user) {

//         userService.addUser(user);

//         return "register_success";

//     }

//     }

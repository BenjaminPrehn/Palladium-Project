package com.managment.palladium.controllers;

import com.managment.palladium.dao.UserAccountRepository;
import com.managment.palladium.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    UserAccountRepository accountRepo;
    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    //Loding our register page for people to signup
    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount",userAccount);

        return "security/register";
    }

    // Saving the user to our database and using Bcrypt to encrypt the password before saving to database.
    @PostMapping("register/save")
    public String saveUser(Model model, UserAccount user){
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        accountRepo.save(user);
        return "redirect:/";
    }


}

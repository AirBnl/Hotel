package com.airbnl.hotelservice.controller;

import com.airbnl.hotelservice.model.User;
import com.airbnl.hotelservice.service.interfaces.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.result.view.RedirectView;

@Controller
public class authController {
    private final IUserService userService;

    public authController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@RequestParam("username") String username, @RequestParam("password") String password) {
        userService.save(new User(-1, username, password, username, 2));
        return "redirect:/login";
    }

}

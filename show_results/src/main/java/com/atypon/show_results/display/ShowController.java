package com.atypon.show_results.display;

import com.atypon.show_results.AuthenticationService;
import com.atypon.show_results.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShowController {
    private final ShowService showService;
    private final AuthenticationService authenticationService;
    private String nextUrl;

    @Autowired
    public ShowController(ShowService showService, AuthenticationService authenticationService) {
        this.showService = showService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/authenticate")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "authenticate";
    }

    @PostMapping("/authenticate")
    public String loginSubmit(@ModelAttribute User user, Model model) {
        authenticationService.validate(user);
        if (authenticationService.isAuthenticated()) {
            return "redirect:" + nextUrl;
        }
        return "failed-authentication";
    }

    @GetMapping("/analyzed_data")
    public String getAnalysed(Model model) {
        nextUrl = "analyzed_data";
        if (authenticationService.isAuthenticated()) {
            authenticationService.setAuthenticationStatus(false);
            model.addAttribute("rows", showService.getAllAnalyzed());
            return "analyzed";
        }
        return "redirect:authenticate";
    }

    @GetMapping("/all_data")
    public String getAll(Model model) {
        nextUrl = "all_data";
        if (authenticationService.isAuthenticated()) {
            authenticationService.setAuthenticationStatus(false);
            model.addAttribute("rows", showService.getAll());
            return "alldata";
        }
        return "redirect:authenticate";
    }
}

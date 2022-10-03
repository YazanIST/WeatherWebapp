package com.atypon.data_entry.weather_entry;

import com.atypon.data_entry.AuthenticationService;
import com.atypon.data_entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WeatherEntryController {
    private final WeatherEntryService weatherEntryService;
    private final AuthenticationService authenticationService;

    @Autowired
    public WeatherEntryController(WeatherEntryService weatherEntryService, AuthenticationService authenticationService) {
        this.weatherEntryService = weatherEntryService;
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
            return "redirect:add";
        }
        return "failed-authentication";
    }

    @GetMapping("/add")
    public String enterNewEntry(Model model) {
        if (authenticationService.isAuthenticated()) {
            model.addAttribute("weatherEntry", new WeatherEntry());
            return "add";
        }
        return "redirect:authenticate";
    }

    @PostMapping("/add")
    public String addWeatherEntry(@ModelAttribute WeatherEntry weatherEntry) {
        if (authenticationService.isAuthenticated()) {
            if (weatherEntryService.addWeatherEntry(weatherEntry)) {
                return "after-add";
            } else {
                return "failed-add";
            }
        }
        return "redirect:authenticate";
    }

    @GetMapping("/")
    public String goToHome() {
        return "redirect:home";
    }

    @GetMapping("/home")
    public String getHomePage(WeatherEntry weatherEntry) {
        authenticationService.setAuthenticationStatus(false);
        return "index";
    }

    @GetMapping("/weatherentry")
    @ResponseBody
    public List<WeatherEntry> getWeatherEntries() {
        return weatherEntryService.getWeatherEntries();
    }
}

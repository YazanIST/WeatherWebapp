package com.atypon.authentication_service;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationServiceController {
    @PostMapping(value = "/*", consumes = "application/json", produces = "application/json")
    public Boolean postBody(@RequestBody User user) {
        return user.getUsername().equals("root") && user.getPassword().equals("root");
    }

    @GetMapping("/*")
    @ResponseBody
    public String getCheck() {
        return "running";
    }
}
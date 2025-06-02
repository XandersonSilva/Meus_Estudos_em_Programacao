package xanderson.edu.learnSpringSecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WellcomeController {

    @GetMapping
    public String wellcome(){
        return "Wellcome to my Spring API";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('managers', 'users')")
    public String users(){
        return "Authorized user";
    }

    @GetMapping("/managers")
    @PreAuthorize("hasRole('managers')")
    public String managers(){
        return "Authorized manager";
    }
    
}
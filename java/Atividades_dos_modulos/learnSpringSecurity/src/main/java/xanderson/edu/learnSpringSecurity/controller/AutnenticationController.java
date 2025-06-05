package xanderson.edu.learnSpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xanderson.edu.learnSpringSecurity.model.User.AuthResponseDTO;
import xanderson.edu.learnSpringSecurity.model.User.AuthenticationDTO;
import xanderson.edu.learnSpringSecurity.model.User.RegisterDTO;
import xanderson.edu.learnSpringSecurity.model.User.UserEntity;
import xanderson.edu.learnSpringSecurity.repository.UserRepository;
import xanderson.edu.learnSpringSecurity.security.TokenService;

@RestController
public class AutnenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        UsernamePasswordAuthenticationToken usernamePassword;
        usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());

        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((UserEntity) auth.getPrincipal());


        return ResponseEntity.ok(new AuthResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){
        if (this.repository.findByUsername(data.username())!= null) {
            return ResponseEntity.badRequest().build();
            
        }
        String encryptedPassword =  new BCryptPasswordEncoder().encode(data.password());
        UserEntity user = new UserEntity(data.name(), data.username(), encryptedPassword, data.role());

        this.repository.save(user);

        return ResponseEntity.ok().build();

    }
}

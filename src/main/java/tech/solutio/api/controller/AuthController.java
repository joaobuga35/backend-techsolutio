package tech.solutio.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.solutio.api.domain.user.dto.DataLogin;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataLogin dataLogin){
        var token = new UsernamePasswordAuthenticationToken(dataLogin.email(),dataLogin.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}

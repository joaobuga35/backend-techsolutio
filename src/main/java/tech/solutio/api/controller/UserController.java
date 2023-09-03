package tech.solutio.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.solutio.api.user.DataListUsers;
import tech.solutio.api.user.User;
import tech.solutio.api.user.UserRepository;
import tech.solutio.api.user.UserRequest;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;
    @PostMapping
    @Transactional
    public User register(@RequestBody @Valid UserRequest userData){
        User newUser = repository.save(new User(userData));
        return newUser;
    }

    @GetMapping
    public List<DataListUsers> listAllUsers(){
        return repository.findAll().stream().map(DataListUsers::new).toList();
    }
}

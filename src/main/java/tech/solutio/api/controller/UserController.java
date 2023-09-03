package tech.solutio.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.solutio.api.dto.DataListUsers;
import tech.solutio.api.model.User;
import tech.solutio.api.dto.UserRequest;
import tech.solutio.api.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    @Transactional
    public User register(@RequestBody @Valid UserRequest userData){
        User newUser = userService.createUser(userData);
        return newUser;
    }

    @GetMapping
    public List<DataListUsers> listAllUsers(){
        return userService.findAllUsers();
    }
}

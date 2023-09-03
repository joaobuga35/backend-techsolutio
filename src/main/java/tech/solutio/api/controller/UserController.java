package tech.solutio.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> register(@RequestBody @Valid UserRequest userData){
        User newUser = userService.createUser(userData);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created with successful");
    }

    @GetMapping
    public Page<DataListUsers> listAllUsers(Pageable pagination){
        return userService.findAllUsers(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> listOneUser(@PathVariable Long id){
        return userService.findOneUser(id);
    }
}

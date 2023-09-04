package tech.solutio.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.solutio.api.dto.DataListUsers;
import tech.solutio.api.dto.UserEditRequest;
import tech.solutio.api.model.User;
import tech.solutio.api.dto.UserRequest;
import tech.solutio.api.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    @Transactional
    public ResponseEntity<DataListUsers> register(@RequestBody @Valid UserRequest userData, UriComponentsBuilder uriBuilder){
        User newUser = userService.createUser(userData);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataListUsers(newUser));
    }

    @GetMapping
    public ResponseEntity listAllUsers(Pageable pagination){
        var users = userService.findAllUsers(pagination);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity listOneUser(@PathVariable Long id){
        var user = userService.findOneUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<User> editUser(@RequestBody @Valid UserEditRequest userData, @PathVariable Long id){
        var userUpdated = userService.editUser(userData,id);
        return ResponseEntity.ok(userUpdated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}

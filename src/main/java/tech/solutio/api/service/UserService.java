package tech.solutio.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.solutio.api.dto.DataListUsers;
import tech.solutio.api.dto.UserEditRequest;
import tech.solutio.api.dto.UserRequest;
import tech.solutio.api.model.User;
import tech.solutio.api.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userData){
        User newUser = new User(userData);
        return userRepository.save(newUser);
    }

    public Page<DataListUsers> findAllUsers(@PageableDefault(sort = {"name"}) Pageable pagination){
        return userRepository.findAll(pagination).map(DataListUsers::new);
    }

    public ResponseEntity<User> findOneUser(Long id){
        User findUser = userRepository.findById(id).orElse(null);
        if (findUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(findUser);
    }

    public ResponseEntity<User> editUser(UserEditRequest userData, Long id){
        User findUser = userRepository.findById(id).orElse(null);
        if (findUser == null) {
            return ResponseEntity.notFound().build();
        }

        findUser.updateUser(userData);
        return ResponseEntity.ok(findUser);
    }

    public ResponseEntity<Object> deleteUser(Long id){
        User findUser = userRepository.findById(id).orElse(null);
        if (findUser == null) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.noContent().build();
    }
}

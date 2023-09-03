package tech.solutio.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.solutio.api.dto.DataListUsers;
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

    public List<DataListUsers> findAllUsers(){
        return userRepository.findAll().stream().map(DataListUsers::new).toList();
    }
}

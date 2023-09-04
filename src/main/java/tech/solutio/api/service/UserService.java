package tech.solutio.api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.solutio.api.domain.user.User;
import tech.solutio.api.domain.user.dto.UserEditRequest;
import tech.solutio.api.domain.user.repository.UserRepository;
import tech.solutio.api.domain.user.dto.DataListUsers;
import tech.solutio.api.domain.user.dto.UserRequest;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userData){
        User userEmail = userRepository.findByEmail(userData.email());
        if (userEmail != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }
        User newUser = new User(userData);
        return userRepository.save(newUser);
    }

    public Page<DataListUsers> findAllUsers(@PageableDefault(sort = {"name"}) Pageable pagination){
        return userRepository.findAll(pagination).map(DataListUsers::new);
    }

    public User findOneUser(Long id){
        User findUser = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return findUser;
    }

    public User editUser(UserEditRequest userData, Long id){
        User findUser = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        User findEmail = userRepository.findByEmail(userData.email());
        if (findEmail != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }

        findUser.updateUser(userData);
        return findUser;
    }

    public void deleteUser(Long id){
        userRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        userRepository.deleteById(id);
    }
}

package tech.solutio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.solutio.api.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

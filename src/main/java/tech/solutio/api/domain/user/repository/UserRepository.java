package tech.solutio.api.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.solutio.api.domain.user.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

package tech.solutio.api.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.solutio.api.domain.user.dto.UserEditRequest;
import tech.solutio.api.domain.user.dto.UserRequest;

@Table(name = "users")
@Entity(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;

    public User(UserRequest userData) {
        this.name = userData.name();
        this.email = userData.email();
        this.password = userData.password();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void updateUser(UserEditRequest userData) {
        if (userData.name() != null){
            this.name = userData.name();
        }

        if (userData.email() != null){
            this.email = userData.email();
        }

        if (userData.password() != null){
            this.password = userData.password();
        }
    }
}

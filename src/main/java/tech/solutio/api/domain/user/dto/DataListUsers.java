package tech.solutio.api.domain.user.dto;

import tech.solutio.api.domain.user.User;

public record DataListUsers(Long id, String name, String email) {
    public DataListUsers(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}

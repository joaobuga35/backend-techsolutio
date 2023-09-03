package tech.solutio.api.dto;

import tech.solutio.api.model.User;

public record DataListUsers(Long id, String name, String email) {
    public DataListUsers(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}

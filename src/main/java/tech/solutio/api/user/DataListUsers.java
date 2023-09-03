package tech.solutio.api.user;

public record DataListUsers(Long id, String name, String email) {
    public DataListUsers(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}

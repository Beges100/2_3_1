package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void dropUsersTable();

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
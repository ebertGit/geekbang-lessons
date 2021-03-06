package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new DatabaseUserRepository(new DBConnectionManager());

    @Override
    public boolean register(User user) {
        int count = userRepository.save(user);
        return count > 0 ? true : false;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }

    @Override
    public boolean emailExisted(String email) {
        return userRepository.emailExisted(email);
    }
}

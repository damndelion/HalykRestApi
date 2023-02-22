package kz.halyk.rest.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kz.halyk.rest.api.model.User;
import kz.halyk.rest.api.repository.UserJdbcRepository;
import kz.halyk.rest.api.repository.UserRepository;
import kz.halyk.rest.api.util.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for users.
 */

@Service
public class UserService {
  /**
   * Model for users.
   */
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserJdbcRepository userJdbcRepository;

  /**
   * findAll for user.
   */
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  /**
   * Get user by name for user.
   */

  public List<User> getUserByName(String name) throws UserException {
    if (name.matches(".*\\d.*")) {
      return null;
    }
    if (name.split(" ").length > 5) {
      throw new UserException("Long name");
    }

    return userRepository.findByName(name);
  }

  /**
   * Get user by id of user.
   */

  public Optional<User> getUserById(long id) {
    return userRepository.findById(id);
  }

  /**
   * Update user.
   */

  public User updateUser(long id, User user) {
    user.setId(id);
    userRepository.save(user);
    return user;
  }

  /**
   * Delete user.
   */

  public void deleteUser(long id) {
    userRepository.deleteById(id);
  }

  /**
   * Insert for user.
   */

  public User save(User user) {
    userRepository.save(user);
    return user;
  }

  public void clear() {
    userRepository.deleteAll();
  }
}



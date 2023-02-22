package kz.halyk.rest.api.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import kz.halyk.rest.api.model.User;
import kz.halyk.rest.api.service.UserService;
import kz.halyk.rest.api.util.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for users.
 */
@RestController
public class UserController {
  @Autowired
  UserService userService;

  @ApiOperation(value = "Get all users", notes = "Returns all users from db")
  @GetMapping("/users")
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @GetMapping("/users/{id}")
  public Optional<User> getUserById(@PathVariable(name = "id") long id) {
    return userService.getUserById(id);
  }

  @GetMapping("/users/{name}")
  public List<User> getUserByName(@PathVariable(name = "name") String name) throws UserException {
    return userService.getUserByName(name);
  }

  @PostMapping("/users/")
  public User insertUser(@RequestBody User user) {
    return userService.save(user);
  }

  /**
   * update user.
   */
  @PutMapping("/users/{id}")
  public User updateUser(@PathVariable(name = "id") long id, @RequestBody User user) {
    return userService.updateUser(id, user);
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable(name = "id") long id) {
    userService.deleteUser(id);
  }
}


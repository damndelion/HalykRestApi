package kz.halyk.rest.api.service;

import java.util.List;
import kz.halyk.rest.api.App;
import kz.halyk.rest.api.model.User;
import kz.halyk.rest.api.util.UserException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integreation test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserServiceIt {

  /**
   * Before.
   */
  @Before
  public void fillDataInDb() {
    User user = new User();
    user.setName("student");
    user.setAge(23);
    userService.save(user);
  }

  @Autowired
  UserService userService;

  @Test
  public void getUserByName() throws UserException {
    String name = "student";
    List<User> list = userService.getUserByName(name);
    Assert.assertEquals(1, list.size());
  }

  @After
  public void clearDb() {
    userService.clear();
  }
}

package kz.halyk.rest.api.service;

import java.util.ArrayList;
import java.util.List;
import kz.halyk.rest.api.App;
import kz.halyk.rest.api.model.User;
import kz.halyk.rest.api.util.UserException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

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
  public void getUserByNameCheckNumberInName() throws UserException {
    String name = "student2";
    Assert.assertNull(userService.getUserByName(name));
  }

  @Test
  public void getUserByNameCheck() throws UserException {
    String name = "test test test test test test";

    Assert.assertThrows("Long name", UserException.class,
        () -> userService.getUserByName(name));
  }

  @Test
  public void getUserByNameCheckWithMock() throws UserException {
    UserService userServiceMock = Mockito.mock(UserService.class);
    String name = "test test test test test test";

    Mockito.when(userServiceMock.getUserByName(name)).thenThrow(UserException.class);

    Assert.assertThrows("Long name", UserException.class,
        () -> userServiceMock.getUserByName(name));
  }


  @Test
  public void getUsers() throws UserException {
    String name = "student";

    //prepare mock response
    User expectedUser = new User();
    expectedUser.setName(name);
    expectedUser.setAge(23);
    List<User> expectedUserList = new ArrayList<>();
    expectedUserList.add(expectedUser);

    UserService userServiceMock = Mockito.mock(UserService.class);

    //define action
    Mockito.when(userServiceMock.getUserByName(name)).thenReturn(expectedUserList);

    //test
    List<User> users =  userService.getUserByName(name);
    Assert.assertTrue(users.size() > 0);
    User user = users.get(0);
    Assert.assertEquals(user.getName(), name);
  }

  @After
  public void clearDb() {
    userService.clear();
  }
}

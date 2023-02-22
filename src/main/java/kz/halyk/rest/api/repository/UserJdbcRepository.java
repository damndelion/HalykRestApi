package kz.halyk.rest.api.repository;

import java.util.List;
import kz.halyk.rest.api.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository for users.
 */
@Repository
public class UserJdbcRepository {

  JdbcTemplate jdbcTemplate;

  /**
   * Insert new  users.
   */
  public void insertUser(User user) {
    jdbcTemplate.execute(
            String.format("INSERT INTO \"user\" (\"name\", age) VALUES ('%s', %d)",
                    user.getName(), user.getAge())
    );
  }

  /**
   * Find all users.
   */
  public List<User> findAll() {
    return jdbcTemplate.query("SELECT * FROM \"user\"",
        (resultSet, rows) -> new User(resultSet.getString("name"), resultSet.getInt("age")));
  }

  /**
   * Find user by name.
   */
  public List<User> findByName(String name) {
    return jdbcTemplate.query("SELECT * FROM \"user\" WHERE \"name\" = '" + name + "'",
        (resultSet, rows) -> new User(resultSet.getString("name"), resultSet.getInt("age")));

  }

  /**
   * Find user by name and age.
   */
  public List<User> findByNameAndAge(String name, int age) {
    return jdbcTemplate.query("SELECT * FROM \"user\" WHERE \"name\" = '" + name + "' "
                    + "AND age = '" + age + "'",
        (resultSet, rows) -> new User(resultSet.getString("name"), resultSet.getInt("age")));

  }

  /**
   * Find user by name and age.
   */
  public void updateUser(User user, String oldName, int oldAge) {
    jdbcTemplate.update("UPDATE \"user\" SET \"name\" = '" + user.getName() + "',"
            + "age = " + user.getAge() + "WHERE \"name\" = '" + oldName + "' "
            + "AND age = " + oldAge + ";");
  }

  /**
   * Delete user.
   */
  public void delete(String name, int age) {
    jdbcTemplate.execute("DELETE FROM \"user\" WHERE \"name\" = '" + name + "' "
            + "AND age = " + age);
  }

}

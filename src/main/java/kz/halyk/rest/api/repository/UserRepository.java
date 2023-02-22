package kz.halyk.rest.api.repository;

import java.util.List;
import kz.halyk.rest.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  Jpa Repository for User.
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByName(String name);
}

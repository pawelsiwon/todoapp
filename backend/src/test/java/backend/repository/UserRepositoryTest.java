package backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import backend.model.Role;
import backend.model.User;

@DataJpaTest
public class UserRepositoryTest {

  @Autowired
  UserRepository userRepo;


  public static User createUserUninitialized() {
    return User.builder()
                .username("test")
                .email("test@todoapp.com")
                .password("password")
                .build();
  }

  public static User createUserRoleInizialized() {
    List<Role> roles = Arrays.asList(
                              new Role(null, "USER", "user role", "user role description"),
                              new Role(null, "ADMIN", "admin role", "admin role description")
                            );

    return User.builder()
                .username("test")
                .email("test@todoapp.com")
                .password("password")
                .roles(roles)
                .build();
  }

  @Test
  @DisplayName("Save user with no lists and roles")
  public void saveTest() {
      User u = createUserUninitialized();
      u = userRepo.save(u);

      Optional<User> oUser = userRepo.findById(u.getId());

      assertTrue(oUser.isPresent());
      u = oUser.get();
      assertNotNull(u);
      assertNotNull(u.getRoles());
      assertNotNull(u.getAuthorities());
      assertNotNull(u.getTodoLists());
      assertTrue(u.getId() > 0);
  }

  @Test
  @DisplayName("Save user inizialized with roles")
  public void saveInizialized() {
    User u = createUserRoleInizialized();
    u = userRepo.save(u);

    Optional<User> oUser = userRepo.findById(u.getId());


    assertTrue(oUser.isPresent());
    u = oUser.get();
    u.getRoles().forEach(role -> assertNotNull(role.getId()));
  }

  @Test
  @DisplayName("Remove user")
  public void removeUser() {
    User u = createUserUninitialized();
    u = userRepo.save(u);

    Optional<User> oUser = userRepo.findById(u.getId());
    assertTrue(oUser.isPresent());
    userRepo.delete(oUser.get());
    oUser = userRepo.findById(u.getId());
    assertFalse(oUser.isPresent());
  }

  @Test
  @DisplayName("Update user")
  public void updateUser() {
    User u = createUserUninitialized();
    u = userRepo.save(u);
    Long id = u.getId();

    u.setEmail("test");

    u = userRepo.save(u);
    Optional<User> oUser = userRepo.findById(id);
    
    assertTrue(oUser.isPresent());
    assertEquals("test", oUser.get().getEmail());
  }
  
}

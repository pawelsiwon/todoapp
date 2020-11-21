package backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import backend.model.Role;

@DataJpaTest
public class RoleRepositoryTest {

  @Autowired
  private RoleRepository roleRepo;

  public static Role createRole() {
    Role r = new Role();
    r.setName("User");
    r.setRole("USER");
    r.setDescription("Role for USER");

    return r;
  }
  
  @Test
  @DisplayName("role save test")
  public void saveTest() {
    Role r = createRole();

    r = roleRepo.save(r);
    
    assertNotNull(r);
    assertNotNull(r.getId());
    assertEquals("User", r.getName());
    assertEquals("USER", r.getRole());
    assertEquals("Role for USER", r.getDescription());
  }

  @Test
  @DisplayName("role update test")
  public void updateTest() {
    Role r = createRole();

    Role saved = roleRepo.save(r);
    saved.setName("User update");
    saved.setRole("USER UPDATE");
    saved.setDescription("Role for USER update");
    Role updated = roleRepo.save(r);

    assertNotNull(r);
    assertEquals(saved.getId(), updated.getId());
    assertEquals("User update", updated.getName());
    assertEquals("USER UPDATE", updated.getRole());
    assertEquals("Role for USER update", updated.getDescription());
  }

  @Test
  @DisplayName("find all test")
  public void findAllTest() {
    Role r = createRole();
    roleRepo.save(r);

    List<Role> roles = roleRepo.findAll();
    
    assertTrue(roles.size() > 0);
  }

  @Test
  @DisplayName("find by id")
  public void findById() {
    Role r = createRole();
    r = roleRepo.save(r);
    Optional<Role> oRole = roleRepo.findById(r.getId());

    assertTrue(oRole.isPresent());
  }

  @Test
  @DisplayName("deletion test")
  public void remove() {
    Role r = createRole();
    r = roleRepo.save(r);
    roleRepo.delete(r);

    Optional<Role> oRole = roleRepo.findById(r.getId());

    assertFalse(oRole.isPresent());
  }
}

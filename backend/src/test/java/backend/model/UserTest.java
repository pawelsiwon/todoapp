package backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
  @DisplayName("User all args constructor")
  public void testConstructor() {
    User u = new User(100L, "username", "username@test.pl", "password", new ArrayList<>(), null, true, true, true);

    assertEquals(100L, u.getId());
    assertEquals("username", u.getUsername());
    assertEquals("username@test.pl", u.getEmail());
    assertEquals("password", u.getPassword());
    assertNotNull(u.getTodoLists());
    assertTrue(u.isLocked());
    assertTrue(u.isExpired());
    assertTrue(u.isEnabled());
  }

  @Test
  @DisplayName("Add role to user")
  public void addRoleTest() {
    List<Role> roles = spy(new ArrayList<>());
    User u = User.builder().roles(roles).build();
    
    Role r = new Role(null, "User", "USER", "User role");
    u.addRole(r);

    assertEquals(1, u.getRoles().size());
    verify(roles, times(1)).add(r);
  }

  @Test
  @DisplayName("Remove user's role")
  public void removeRoleTest() {
    List<Role> roles = spy(new ArrayList<>());
    User u = User.builder().roles(roles).build();
    
    Role r = new Role(null, "User", "USER", "User role");
    u.addRole(r);
    u.removeRole(r);

    assertEquals(0, u.getRoles().size());
    verify(roles, times(1)).remove(r);
  }

}

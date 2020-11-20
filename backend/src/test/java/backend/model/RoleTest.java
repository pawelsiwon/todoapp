package backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class RoleTest {

  @Test
  @DisplayName("Role no args constructor")
  public void noArgsConstructorTest() {
    Role r = new Role();
    assertNull(r.getId());
    assertNull(r.getName());
    assertNull(r.getDescription());
    assertNull(r.getRole());
  }

  @Test
  @DisplayName("Role args constructor")
  public void argsConstructorTest() {
    Role r = new Role(100L, "User", "USER", "Role for normal users");
    assertNotNull(r.getId());
    assertNotNull(r.getName());
    assertNotNull(r.getDescription());
    assertNotNull(r.getRole());
  }

  @Test
  @DisplayName("Throw exception on uninitialized role")
  public void throwException() {
      Role r = new Role();
      assertThrows(IllegalArgumentException.class, () -> r.toGrantedAuthority());
  }

  @Test
  @DisplayName("Map user to role")
  public void mapUserToRole() {
      Role r = new Role();
      r.setRole("USER");

      SimpleGrantedAuthority authrity = r.toGrantedAuthority();

      assertEquals("USER", authrity.getAuthority());
  }

}

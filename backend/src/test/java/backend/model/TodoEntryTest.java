package backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TodoEntryTest {
  
  @Test
  @DisplayName("")
  public void constructorTest() {
    TodoEntry t = new TodoEntry(100L, "TITLE", "DESCRIPTION");

    assertEquals(100L, t.getId());
    assertEquals("TITLE", t.getTitle());
    assertEquals("DESCRIPTION", t.getDescription());
  }
}

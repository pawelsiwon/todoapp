package backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import backend.model.TodoEntry;

@DataJpaTest
public class TodoEntryRepositoryTest {
  
  @Autowired
  TodoEntryRepository todoRepo;

  @Test
  @DisplayName("save test")
  public void saveTest() {
    TodoEntry e = new TodoEntry(null, "TITLE", "DESCRIPTION");
    
    e = todoRepo.save(e);

    assertNotNull(e);
    assertNotNull(e.getId());
  }

  @Test
  @DisplayName("edit todo entry")
  public void editEntry() {
    TodoEntry e = new TodoEntry(null, "TITLE", "DESCRIPTION");
    TodoEntry saved = todoRepo.save(e);
    saved.setTitle("Updated");
    saved.setDescription("Updated");
    TodoEntry updated = todoRepo.save(saved);


    assertEquals(saved.getId(), updated.getId());
    assertEquals("Updated", saved.getTitle());
    assertEquals("Updated", saved.getDescription());
  }

  @Test
  @DisplayName("remove todo entry")
  public void removeTest() {
    TodoEntry e = new TodoEntry(null, "TITLE", "DESCRIPTION");
    Long beforeSave = todoRepo.count();
    TodoEntry saved = todoRepo.save(e);
    Long afterSave = todoRepo.count();
    todoRepo.delete(saved);
    Long afterDeletion = todoRepo.count();

    assertNotEquals(beforeSave, afterSave);
    assertEquals(beforeSave, afterDeletion);
  }
}

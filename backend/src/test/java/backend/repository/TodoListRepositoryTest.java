package backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import backend.model.TodoEntry;
import backend.model.TodoList;

@DataJpaTest
public class TodoListRepositoryTest {
  
  @Autowired
  TodoListRepository todoListRepo;

  @Autowired
  TodoEntryRepository todoRepo;
  
  @Test
  @DisplayName("empty todo list save")
  public void saveEmptyTest() {
    TodoList l = TodoList.builder().name("Important").build();
    Long beforeSave = todoListRepo.count();
    TodoList saved = todoListRepo.save(l);

    assertNotNull(saved);
    assertNotNull(saved.getId());
    assertNotEquals(beforeSave, todoListRepo.count());
  }

  @Test
  @DisplayName("non empty todo list save")
  public void saveNonEmpty() {
    List<TodoEntry> entries = Arrays.asList(
      new TodoEntry(null, "1", "1 d"),
      new TodoEntry(null, "2", "2 d"),
      new TodoEntry(null, "3", "3 d"),
      new TodoEntry(null, "4", "4 d")
    );

    TodoList l = TodoList.builder().name("Not empty").entries(entries).build();
    Long entriesBeforeSave = todoRepo.count();
    TodoList saved = todoListRepo.save(l);

    assertNotNull(saved);
    assertNotNull(saved.getEntries());
    assertNotEquals(entriesBeforeSave, todoRepo.count());
    saved.getEntries().forEach(entry -> assertNotNull(entry.getId()));
  }

  @Test
  @DisplayName("non empty todo list remove")
  public void removeNonEmpty() {
    List<TodoEntry> entries = Arrays.asList(
      new TodoEntry(null, "1", "1 d"),
      new TodoEntry(null, "2", "2 d"),
      new TodoEntry(null, "3", "3 d"),
      new TodoEntry(null, "4", "4 d")
    );

    TodoList l = TodoList.builder().name("Not empty").entries(entries).build();
    Long listCountBeforeSave = todoListRepo.count();
    Long todoEntriesCountBeforeSave = todoRepo.count();
    TodoList saved = todoListRepo.save(l);
    Long listCountAfterSave = todoListRepo.count();
    Long todoEntriesCountAfterSave = todoRepo.count();
    todoListRepo.delete(saved);
    Long listCountAfterRemove = todoListRepo.count();
    Long todoEntriesCountAfterRemove = todoRepo.count();

    assertNotEquals(listCountBeforeSave, listCountAfterSave);
    assertEquals(listCountBeforeSave, listCountAfterRemove);
    assertNotEquals(todoEntriesCountBeforeSave, todoEntriesCountAfterSave);
    assertEquals(todoEntriesCountBeforeSave, todoEntriesCountAfterRemove);
  }
}

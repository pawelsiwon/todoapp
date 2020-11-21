package backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TodoListTest {
  
  @Test
  @DisplayName("no args constructor")
  public void constructorTest() {
    TodoList t = new TodoList();

    assertNull(t.getId());
    assertNotNull(t.getEntries());
    assertNull(t.getName());
  }

  @Test
  @DisplayName("add entry")
  public void addTodoEntryTest() {
    List<TodoEntry> entries = spy(new ArrayList<>());
    TodoList list = TodoList.builder().entries(entries).build();
    TodoEntry entry = mock(TodoEntry.class);

    list.addEntry(entry);

    verify(entries, times(1)).add(entry);
    assertEquals(1, list.getEntries().size());
  }

  @Test
  @DisplayName("set entries")
  public void setEntryListTest() {
    List<TodoEntry> entries = spy(new ArrayList<>());
    TodoList list = TodoList.builder().entries(entries).build();

    assertEquals(entries, list.getEntries());
  }

  @Test
  @DisplayName("remove entry")
  public void removeTodoEntryTest() {
    List<TodoEntry> entries = spy(new ArrayList<>());
    TodoList list = TodoList.builder().entries(entries).build();
    TodoEntry entry = mock(TodoEntry.class);

    list.addEntry(entry);
    list.removeEntry(entry);

    verify(entries, times(1)).remove(entry);
    assertEquals(0, list.getEntries().size());
  }
}

package backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoList {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  
  @Builder.Default
  @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
  private List<TodoEntry> entries = new ArrayList<>();

  public void addEntry(TodoEntry entry) {
    entries.add(entry);
  }

  public void removeEntry(TodoEntry entry) {
    entries.remove(entry);
  }

  public void removeEntry(Long id) {
    entries.removeIf(todoEntry -> todoEntry.getId().equals(id));
  }
}

package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.model.TodoEntry;

@Repository
public interface TodoEntryRepository extends JpaRepository<TodoEntry, Long> {
  
}

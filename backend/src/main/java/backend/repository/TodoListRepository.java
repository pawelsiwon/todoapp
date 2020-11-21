package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.model.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
  
}

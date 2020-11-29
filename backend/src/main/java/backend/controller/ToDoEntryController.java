package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.model.TodoEntry;
import backend.repository.TodoEntryRepository;

@RestController
@RequestMapping("/todo")
public class ToDoEntryController {
  
  private TodoEntryRepository todoEntryRepo;

  @Autowired
  public ToDoEntryController(TodoEntryRepository todoEntryRepo) {
    this.todoEntryRepo = todoEntryRepo;
  }


  @GetMapping
  public List<TodoEntry> getAllEntries() {
    return todoEntryRepo.findAll();
  }
}

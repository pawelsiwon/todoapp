package backend.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import backend.model.TodoEntry;
import backend.model.TodoList;
import backend.model.User;
import backend.repository.UserRepository;

@Configuration
@Profile("development")
public class DevelopmentConfig {
  
  @Bean
  public CommandLineRunner dataLoader(UserRepository userRepo) {
    return new CommandLineRunner() {

      @Override
      public void run(String... args) throws Exception {

          TodoList tdl1 = new TodoList();
          tdl1.setName("Important stuff");
          TodoList tdl2 = new TodoList();
          tdl2.setName("Job stuff");

          tdl1.addEntry(new TodoEntry(null, "list 1 : entry 1", "list 1 : entry 1"));
          tdl1.addEntry(new TodoEntry(null, "list 1 : entry 2", "list 1 : entry 2"));
          tdl1.addEntry(new TodoEntry(null, "list 1 : entry 3", "list 1 : entry 3"));
          tdl1.addEntry(new TodoEntry(null, "list 1 : entry 4", "list 1 : entry 4"));
          tdl1.addEntry(new TodoEntry(null, "list 1 : entry 5", "list 1 : entry 5"));
          tdl1.addEntry(new TodoEntry(null, "list 1 : entry 6", "list 1 : entry 6"));

          tdl2.addEntry(new TodoEntry(null, "list 2 : entry 1", "list 2 : entry 1"));
          tdl2.addEntry(new TodoEntry(null, "list 2 : entry 2", "list 2 : entry 2"));
          tdl2.addEntry(new TodoEntry(null, "list 2 : entry 3", "list 2 : entry 3"));
          tdl2.addEntry(new TodoEntry(null, "list 2 : entry 4", "list 2 : entry 4"));
          tdl2.addEntry(new TodoEntry(null, "list 2 : entry 5", "list 2 : entry 5"));
          tdl2.addEntry(new TodoEntry(null, "list 2 : entry 6", "list 2 : entry 6"));
          tdl2.addEntry(new TodoEntry(null, "list 2 : entry 7", "list 2 : entry 7"));

          List<TodoList> tdlists = Arrays.asList(tdl1, tdl2);

          User u = new User();
          u.setUsername("test");
          u.setEmail("test@todoapp.com");
          u.setTodoLists(tdlists);
          u.setExpired(false);
          u.setEnabled(true);
          u.setLocked(false);
          

          userRepo.save(u);
      }
      
    };
    
  }
}

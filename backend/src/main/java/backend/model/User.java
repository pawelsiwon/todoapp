package backend.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String username;
  private String email;
  private String password;

  @Builder.Default
  @OneToMany
  private List<TodoList> todoLists = new ArrayList<>();

  @Builder.Default
  @OneToMany(cascade = CascadeType.PERSIST)
  private List<Role> roles = new ArrayList<>();

  private boolean locked;
  private boolean expired;
  private boolean enabled;

  public User(String username, String email, String password) {
    this.id = null;
    this.username = username;
    this.email = email;
    this.password = password;
    this.enabled = true;
  }

  public void addTodoList(TodoList todolist) {
    todoLists.add(todolist);
  }

  public void addRole(Role role) {
    roles.add(role);
  }

  public void removeRole(Role role) {
    roles.remove(role);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream()
            .map(Role::toGrantedAuthority)
            .collect(Collectors.toList());
  }

  @Override
  public boolean isAccountNonExpired() {
    return !expired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !locked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return expired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
  
}

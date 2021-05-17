package br.com.youtube.apirest.persistence.repository;

import br.com.youtube.apirest.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

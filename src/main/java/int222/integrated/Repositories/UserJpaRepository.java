package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int222.integrated.Models.AuthenticationUser;

public interface UserJpaRepository extends JpaRepository<AuthenticationUser, Integer> {
	AuthenticationUser findByUsername(String username);
}
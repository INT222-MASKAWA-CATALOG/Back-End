package int222.integrated.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import int222.integrated.Models.AuthenticationUser;

public interface UserJpaRepository extends JpaRepository <AuthenticationUser, Integer>{

}
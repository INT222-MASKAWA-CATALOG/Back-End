package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int222.integrated.Models.color;

public interface ColorJpaRepository extends JpaRepository <color, Integer>{}

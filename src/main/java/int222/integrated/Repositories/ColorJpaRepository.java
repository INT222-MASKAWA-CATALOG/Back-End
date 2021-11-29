package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int222.integrated.Models.Color;

public interface ColorJpaRepository extends JpaRepository <Color, Integer>{}

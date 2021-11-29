package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int222.integrated.Models.Record;

public interface RecordJpaRepository extends JpaRepository<Record, Integer> {
}

package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int222.integrated.Models.Member;

public interface MemberJpaRepository extends JpaRepository <Member, Integer>{}
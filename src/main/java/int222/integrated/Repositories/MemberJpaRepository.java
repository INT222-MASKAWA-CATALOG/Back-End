package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int222.integrated.Models.member;

public interface MemberJpaRepository extends JpaRepository <member, Integer>{}
package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int222.integrated.Models.Onlineshop;

public interface ShopJpaRepository extends JpaRepository < Onlineshop, Integer>{}
package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int222.integrated.Models.Bookmark;

public interface BookmarkJpaRepository extends JpaRepository < Bookmark, Integer>{}
package int222.integated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Bookmark;
import int222.integrated.Repositories.BookmarkJpaRepository;

@RestController
public class BookmarkController {
	@Autowired
	private BookmarkJpaRepository bookmarkJpa;
	
	@GetMapping("/bookmark")
	public List<Bookmark> showAllBookmarks() {
		return bookmarkJpa.findAll();
	}
}

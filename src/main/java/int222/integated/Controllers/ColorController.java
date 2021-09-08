package int222.integated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Color;
import int222.integrated.Repositories.ColorJpaRepository;

@RestController
public class ColorController {
	@Autowired
	private ColorJpaRepository colorJpa;
	
	@GetMapping("/color")
	public List<Color> showAll() {
		return colorJpa.findAll();
	}
}
package int222.integated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Size;
import int222.integrated.Repositories.SizeJpaRepository;

@RestController
public class SizeController {
	@Autowired
	private SizeJpaRepository SizeJpa;
	
	@GetMapping("/size")
	public List<Size> showAllSizes() {
		return SizeJpa.findAll();
	}
}

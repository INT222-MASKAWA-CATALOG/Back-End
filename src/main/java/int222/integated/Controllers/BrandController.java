package int222.integated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Brand;
import int222.integrated.Repositories.BrandJpaRepository;

@RestController
public class BrandController {
	@Autowired
	private BrandJpaRepository brandJpa;
	
	@GetMapping("/brand")
	public List<Brand> showAllBrands() {
		return brandJpa.findAll();
	}
}

package int222.integrated.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import int222.integrated.Models.Brand;
import int222.integrated.Repositories.BrandJpaRepository;

@CrossOrigin
@RestController
public class BrandController {
	@Autowired
	private BrandJpaRepository brandJpa;

	@GetMapping("/brand")
	public List<Brand> showAllBrands() {
		return brandJpa.findAll();
	}

	@GetMapping("/brand/{brandid}")
	public Brand showBrand(@PathVariable int brandid) {
		Brand brand = this.brandJpa.findById(brandid).orElse(null);
		return brand;
	}
}

package int222.integrated.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import int222.integrated.Models.brand;
import int222.integrated.Repositories.BrandJpaRepository;

@CrossOrigin
@RestController
public class BrandController {
	@Autowired
	private BrandJpaRepository brandJpa;

	@GetMapping("/brand")
	public List<brand> showAllBrands() {
		return brandJpa.findAll();
	}

	@GetMapping("/brand/{brandid}")
	public brand showBrand(@PathVariable int brandid) {
		brand brand = this.brandJpa.findById(brandid).orElse(null);
		return brand;
	}
	
	@PostMapping(value = "/add-brand")
	public brand createBrand(@RequestBody brand newBrand) {
		return brandJpa.save(newBrand);	
	}
	
	@DeleteMapping("/brand/{brandid}")
	public String delete(@PathVariable Integer brandid) {
		brandJpa.findById(brandid).orElse(null);
		brandJpa.deleteById(brandid);
		return "Delete Brand Success";
	}
}

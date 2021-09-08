package int222.integated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Productsize;
import int222.integrated.Repositories.ProductsizeJpaRepository;

@RestController
public class ProductsizeController {
	@Autowired
	private ProductsizeJpaRepository ProductsizeJpa;
	
	@GetMapping("/productsize")
	public List<Productsize> showAllProductsizes() {
		return ProductsizeJpa.findAll();
	}
}

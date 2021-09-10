package int222.integrated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Product;
import int222.integrated.Repositories.ProductJpaRepository;

@RestController
public class ProductController {
	@Autowired
	private ProductJpaRepository productJpa;
	
	@GetMapping("/product")
	public List<Product> showAllProducts() {
		return productJpa.findAll();
	}
}

package int222.integrated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Product;
import int222.integrated.Repositories.ProductJpaRepository;

@CrossOrigin
@RestController
public class ProductController {
	@Autowired
	private ProductJpaRepository productJpa;

	@GetMapping("/product")
	public List<Product> showAllProducts() {
		return productJpa.findAll();
	}

	@GetMapping("/product/{productid}")
	public Product showProduct(@PathVariable int productid) {
		Product product = this.productJpa.findById(productid).orElse(null);
		return product;
	}
	
	@PostMapping(value = "/addProduct")
	public Product create(@RequestBody Product newProduct) {
		return productJpa.save(newProduct);
	}

	// ยังไม่ได้ทำ throw Exception
	@DeleteMapping("/product/{productid}")
	public String delete(@PathVariable Integer productid) {
		productJpa.findById(productid).orElse(null);
		productJpa.deleteById(productid);
		return "Delete Product Success";
	}

	@PutMapping("/updateProduct/{productid}")
	public Product updateProduct(@RequestBody Product updateProduct, @PathVariable int productid) throws Exception {
		if(productJpa.findById(productid).orElse(null) == null) {
			throw new Exception("Not Found Product");
		}
		productJpa.findById(productid).orElse(null);
		return productJpa.save(updateProduct);
	}
	
	
}


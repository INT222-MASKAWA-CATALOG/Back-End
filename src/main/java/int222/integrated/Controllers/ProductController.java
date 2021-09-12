package int222.integrated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Exception.ExceptionResponse;
import int222.integrated.Exception.ProductException;
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
	
	@GetMapping("/product/{productcode}")
	public Product showProduct(@PathVariable int productid) {
		Product product = this.productJpa.findById(productid).orElse(null);
		if (product == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.PRODUCT_DOES_NOT_EXIST,
					"Can not Find this Product Because Product Id : " + productid + " does not exist.");
		}
		return product;
	}
}

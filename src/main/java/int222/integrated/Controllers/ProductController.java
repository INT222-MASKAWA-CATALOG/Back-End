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

import int222.integrated.Exception.ExceptionResponse;
import int222.integrated.Exception.ProductException;
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
		if (product == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.PRODUCT_ID_DOES_NOT_EXIST,
					"Product id : " + productid + " does not exist ");
		}
		return product;
	}

	// ยังไม่ได้ทำ throw Exception //Add ได้ เเต่ยังทำ Exception ไม่ได้
	@PostMapping(value = "/addProduct")
	public Product create(@RequestBody Product newProduct) {

		/*
		 * Product p = productJpa.FindProductByProductName(newProduct.getProductname());
		 * if (p.getProductname().equals(newProduct.getProductname())) { throw new
		 * ProductException(ExceptionResponse.ERROR_CODE.PRODUCT_NAME_ALREADY_EXIST,
		 * "Product name : " + newProduct.getProductname() + " already exist "); }
		 */

		return productJpa.save(newProduct);

	}

	@DeleteMapping("/product/{productid}")
	public String delete(@PathVariable Integer productid) {
		Product product = productJpa.findById(productid).orElse(null);
		if (product == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.PRODUCT_ID_DOES_NOT_EXIST,
					"Product id : " + productid + " does not exist ");
		}
		productJpa.deleteById(productid);
		return "Delete Product Success";
	}

	// ยังไม่ได้ทำ throw Exception //ยังไม่ได้ test Update
	@PutMapping("/updateProduct/{productid}")
	public Product updateProduct(@RequestBody Product updateProduct, @PathVariable int productid) throws Exception {
		if (productJpa.findById(productid).orElse(null) == null) {
			throw new Exception("Not Found Product");
		}
		productJpa.findById(productid).orElse(null);
		return productJpa.save(updateProduct);
	}
}
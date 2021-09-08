package int222.integated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Productcolor;
import int222.integrated.Repositories.ProductColorJpaRepository;

@RestController
public class ProductcolorController {
	@Autowired
	private ProductColorJpaRepository ProductcolorJpa;
	
	@GetMapping("/productscolor")
	public List<Productcolor> showAllProductcolors() {
		return ProductcolorJpa.findAll();
	}
}

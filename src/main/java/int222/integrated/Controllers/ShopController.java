package int222.integrated.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import int222.integrated.Models.shop;
import int222.integrated.Repositories.ShopJpaRepository;

@CrossOrigin
@RestController
public class ShopController {
	@Autowired
	private ShopJpaRepository shopJpa;

	@GetMapping("/shop")
	public List<shop> showAllShops() {
		return shopJpa.findAll();
	}

	@GetMapping("/shop/{shopid}")
	public shop showOnlineshops(@PathVariable int shopid) {
		shop shop = this.shopJpa.findById(shopid).orElse(null);
		return shop;
	}
	//ดึงรูป Logo Shop
}

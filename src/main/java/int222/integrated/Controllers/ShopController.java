package int222.integrated.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import int222.integrated.Models.Shop;
import int222.integrated.Repositories.ShopJpaRepository;

@RestController
public class ShopController {
	@Autowired
	private ShopJpaRepository shopJpa;
	
	

	@GetMapping("/shop")
	public List<Shop> showAllShops() {
		return shopJpa.findAll();
	}

	@GetMapping("/shop/{shopid}")
	public Shop showOnlineshops(@PathVariable int shopid) {
		Shop shop = this.shopJpa.findById(shopid).orElse(null);
		return shop;
	}
	//ดึงรูป Logo Shop
}

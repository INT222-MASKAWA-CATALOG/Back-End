package int222.integrated.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int222.integrated.Models.Onlineshop;
import int222.integrated.Repositories.OnlineShopJpaRepository;


@RestController
public class OnlineshopController {
	@Autowired
	private OnlineShopJpaRepository onlineShopJpa;
	
	@GetMapping("/onlineshop")
	public List<Onlineshop> showAllOnlineshops() {
		return onlineShopJpa.findAll();
	}
}

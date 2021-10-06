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

//import int222.integrated.Exception.ExceptionResponse;
//import int222.integrated.Exception.OnlineshopException;
import int222.integrated.Models.Onlineshop;
import int222.integrated.Repositories.OnlineShopJpaRepository;

@CrossOrigin
@RestController
public class OnlineshopController {
	@Autowired
	private OnlineShopJpaRepository onlineShopJpa;

	@GetMapping("/onlineshop")
	public List<Onlineshop> showAllOnlineshops() {
		return onlineShopJpa.findAll();
	}

	@GetMapping("/onlineshop/{onlineid}")
	public Onlineshop showOnlineshops(@PathVariable int onlineid) {
		Onlineshop onlineshop = this.onlineShopJpa.findById(onlineid).orElse(null);
		return onlineshop;
	}
	
	@PostMapping(value = "/addOnlineshop")
	public Onlineshop create(@RequestBody Onlineshop newOnlineshop) {
		return onlineShopJpa.save(newOnlineshop);
	}
	
	@DeleteMapping("/onlineshop/{onlineid}")
	public String delete(@PathVariable Integer onlineid) {
		onlineShopJpa.findById(onlineid).orElse(null);
		onlineShopJpa.deleteById(onlineid);
		return "Delete Online Shop  Success";
	}
}

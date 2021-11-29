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
import int222.integrated.Exception.*;
import int222.integrated.Models.Onlineshop;
import int222.integrated.Repositories.OnlineShopJpaRepository;

@CrossOrigin
@RestController
public class OnlineshopController {
	@Autowired
	private OnlineShopJpaRepository onlineShopJpa;
	
//  ---------------------------------- GetMapping ----------------------------------
	//Show a list of all onlineshop.
	@GetMapping("/onlineshop")
	public List<Onlineshop> showAllOnlineshops() {
		return onlineShopJpa.findAll();
	}
	
    //Show list of onlineshop by onlineshopid
	@GetMapping("/onlineshop/{onlineid}")
	public Onlineshop showOnlineshops(@PathVariable int onlineid) {
		Onlineshop onlineshop = this.onlineShopJpa.findById(onlineid).orElse(null);
		if (onlineshop == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.ONLINE_ID_DOES_NOT_EXIST,
					"onlineid id : " + onlineid + " does not exist ");
		}
		return onlineshop;
	}
	
//  ---------------------------------- PostMapping ----------------------------------
	//add onlineshop
	@PostMapping(value = "/addonlineshop")
	public Onlineshop create(@RequestBody Onlineshop newOnlineshop) {
		return onlineShopJpa.save(newOnlineshop);
	}
	
//  ---------------------------------- DeleteMapping ----------------------------------
	//delete onlineshop
	@DeleteMapping("/onlineshop/{onlineid}")
	public String delete(@PathVariable Integer onlineid) {
		Onlineshop onlineshop = this.onlineShopJpa.findById(onlineid).orElse(null);
		if (onlineshop == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.ONLINE_ID_DOES_NOT_EXIST,
					"onlineid id : " + onlineid + " does not exist ");
		}
		onlineShopJpa.deleteById(onlineid);
		return "Delete Online Shop  Success";
	}
}
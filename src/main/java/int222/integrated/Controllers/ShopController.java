package int222.integrated.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;
import int222.integrated.Exception.ExceptionResponse;
import int222.integrated.Exception.ProductException;
import int222.integrated.Exception.StorageFileNotFoundException;
import int222.integrated.Models.Shop;
import int222.integrated.Repositories.ShopJpaRepository;
import int222.integrated.Service.StorageService;

@CrossOrigin
@RestController
public class ShopController {
	@Autowired
	private ShopJpaRepository shopJpa;

	final StorageService storageService;

	@Autowired
	public ShopController(StorageService storageService) {
		this.storageService = storageService;
	}

//  ---------------------------------- GetMapping ----------------------------------
	//Show a list of all shops.
	@GetMapping("/shop")
	public List<Shop> showAllShops() {
		return shopJpa.findAll();
	}

	//Show list of shop by shopid
	@GetMapping("/shop/{shopid}")
	public Shop showOnlineshops(@PathVariable int shopid) {
		Shop shop = this.shopJpa.findById(shopid).orElse(null);
		if (shop == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.SHOP_ID_DOES_NOT_EXIST,
					"Shop id : " + shopid + " does not exist ");
		}
		return shop;
	}

//  ---------------------------------- PostMapping ----------------------------------
	//add shop with image
	@PostMapping("/addShopWithImage")
	public String createShop(@RequestParam("shop") String newShop, @RequestParam("file") MultipartFile file) {
		Shop shop = new Gson().fromJson(newShop, Shop.class);
		shopJpa.save(shop);
		handleFileUpload(file);
		return "Complete";
	}

	//add shop image
	@PostMapping("/uploadShopImage")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		return file.getOriginalFilename() + "Upload complete";
	}

//  ---------------------------------- PutMapping ----------------------------------

//  ---------------------------------- DeleteMapping ----------------------------------
	//delete shop
	@DeleteMapping("/shop/{shopid}")
	public String delete(@PathVariable int shopid) {
		Shop shop = this.shopJpa.findById(shopid).orElse(null);
		if (shop == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.SHOP_ID_DOES_NOT_EXIST,
					"shop id : " + shopid + " does not exist ");
		}
		shopJpa.deleteById(shopid);
		return "Delete Shop Success";
	}

//  ---------------------------------- ExceptionHandler ----------------------------------

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
}
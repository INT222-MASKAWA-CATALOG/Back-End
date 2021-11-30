package int222.integrated.Controllers;

import java.util.List;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;
import int222.integrated.Models.Product;
import int222.integrated.Repositories.ProductJpaRepository;
import int222.integrated.Service.StorageService;
import int222.integrated.Exception.*;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductJpaRepository productsJpa;

	final StorageService storageService;

	@Autowired
	public ProductController(StorageService storageService) {
		this.storageService = storageService;
	}

//  ---------------------------------- GetMapping ----------------------------------
	// Show a list of all products.
	@GetMapping("/product")
	public List<Product> showAllProducts() {
		return productsJpa.findAll();
	}

	// Show list of product by productid
	@GetMapping("/product/{productid}")
	public Product showProduct(@PathVariable int productid) {
		Product product = this.productsJpa.findById(productid).orElse(null);
		if (product == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.PRODUCT_ID_DOES_NOT_EXIST,
					"Product id : " + productid + " does not exist ");
		}
		return product;
	}

	// browse images files
	@GetMapping(value = "/Files/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public Resource serveProduct(@PathVariable String filename) {
		return storageService.loadAsResource(filename);
	}

//  ---------------------------------- PostMapping ----------------------------------
	// add product with add image
	@PostMapping("/addProductWithImage")
	public String createProduct(@RequestParam("product") String newProduct, @RequestParam("file") MultipartFile file) {
		Product product = new Gson().fromJson(newProduct, Product.class);
		productsJpa.save(product);
		handleFileUpload(file);
		return "Complete";
	}

	// add a image
	@PostMapping("/uploadImage")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		return file.getOriginalFilename() + "Upload complete";
	}

//  ---------------------------------- PutMapping ----------------------------------
	// edit product information
	@PutMapping("/product/{productid}")
	public Product updateProduct(@RequestBody Product updateProduct, @PathVariable int productid) throws Exception {
		if (productsJpa.findById(productid).orElse(null) == null) {
			throw new Exception("Not Found Product");
		}
		productsJpa.findById(productid).orElse(null);
		return productsJpa.save(updateProduct);
	}

	// Update image according to the productid.
	@PutMapping("/updateImage/{productcode}")
	public String handleFileUpdate(@PathVariable int productcode, @RequestParam("file") MultipartFile file)
			throws Exception {
		String oldImage = productsJpa.findById(productcode).get().getImage();
		storageService.delete(productsJpa.findById(productcode).get().getImage());
		storageService.store(file);
		return "Update complete: Change " + oldImage + " to " + file.getOriginalFilename();
	}

	// Edit product information with image [Not Finish]
	@PutMapping("/updateProductWithImage/{productid}")
	public String updateProduct(@PathVariable int productid, @RequestParam("product") String updateProduct, @RequestParam("file") MultipartFile file) throws Exception {
		Product editDataProduct = new Gson().fromJson(updateProduct, Product.class);
		Product product = productsJpa.findById(productid).orElse(null);
		storageService.delete(product.getImage());
		product.setAll(editDataProduct);
		productsJpa.save(product);
		storageService.store(file);
		return "Update Success";
	}

//  ---------------------------------- DeleteMapping ----------------------------------
	// Delete products by productid
	@DeleteMapping("/product/{productid}")
	public String deleteProduct(@PathVariable int productid) throws IOException {
		Product product = productsJpa.findById(productid).orElse(null);
		storageService.delete(product.getImage());
		productsJpa.deleteById(productid);
		return "Delete Post Number: " + productid + " complete.";
	}

	// delete photo
	@DeleteMapping(value = "/deleteFile/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public String deleteFile(@PathVariable String filename) throws IOException {
		storageService.delete(filename);
		return "Delete image filename: " + filename;
	}

//  ---------------------------------- ExceptionHandler ----------------------------------
	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
}
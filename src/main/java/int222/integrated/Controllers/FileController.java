package int222.integrated.Controllers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import int222.integrated.Repositories.ProductJpaRepository;
import int222.integrated.Service.StorageService;
import int222.integrated.Exception.*;
import int222.integrated.Models.Product;

@CrossOrigin
@RestController
public class FileController {

	@Autowired
	ProductJpaRepository productsJpaRepository;

	final StorageService storageService;

	@Autowired
	public FileController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping(value = "/Files/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public Resource serveProduct(@PathVariable String filename) {
		return storageService.loadAsResource(filename);
	}
	
	@PostMapping("/uploadImage")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		return file.getOriginalFilename()+"Upload complete";
	}

	@PutMapping("/updateimage/{productcode}")
	public String handleFileUpdate(@PathVariable int productcode, @RequestParam("file") MultipartFile file)
			throws IOException {
		String oldImage = productsJpaRepository.findById(productcode).get().getImage();
		storageService.delete(productsJpaRepository.findById(productcode).get().getImage());
		storageService.store(file);
		return "Update complete: Change " + oldImage + " to " + file.getOriginalFilename();
	}

	@DeleteMapping(value = "/deleteFile/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public String deleteFile(@PathVariable String filename) throws IOException {
		storageService.delete(filename);
		return "Delete image filename: "+filename;
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/addProductWithImage")
    public String createPost(@RequestParam("product") String newProduct , @RequestParam("file") MultipartFile file) {
		Product product = new Gson().fromJson(newProduct, Product.class);
		productsJpaRepository.save(product);
    	handleFileUpload(file);
    	return "Complete";
    }
    
    @DeleteMapping("/product/{productid}")
    public String deletePost(@PathVariable int productid) throws IOException {
    	Product product = productsJpaRepository.findById(productid).orElse(null);
    	storageService.delete(product.getImage());
    	productsJpaRepository.deleteById(productid);
       return "Delete Post Number: "+productid+" complete." ;
   }
}

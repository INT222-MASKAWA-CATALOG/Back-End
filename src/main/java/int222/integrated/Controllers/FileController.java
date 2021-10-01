package int222.integrated.Controllers;

import java.io.IOException;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import int222.integrated.Repositories.ProductJpaRepository;
import int222.integrated.Models.Product;
import int222.integrated.Service.StorageService;
import int222.integrated.Exception.*;

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
		return "Upload complete";
	}

//	@PutMapping("/updateimage/{productcode}")
//	public String handleFileUpdate(@PathVariable int productcode, @RequestParam("file") MultipartFile file)
//			throws IOException {
//		String oldImage = productsJpaRepository.findById(productcode).get().getImages();
//		storageService.delete(productsJpaRepository.findById(productcode).get().getImages());
//		storageService.store(file);
//		return "Update complete: Change " + oldImage + " to " + file.getOriginalFilename();
//	}
//
//	@DeleteMapping(value = "/deleteFile/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
//	public void deleteFile(@PathVariable String filename) throws IOException {
//		storageService.delete(filename);
//	}
//
//	@ExceptionHandler(StorageFileNotFoundException.class)
//	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//		return ResponseEntity.notFound().build();
//	}
}

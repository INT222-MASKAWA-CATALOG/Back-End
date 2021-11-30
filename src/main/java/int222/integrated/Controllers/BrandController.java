package int222.integrated.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import int222.integrated.Exception.ExceptionResponse;
import int222.integrated.Exception.ProductException;
import int222.integrated.Models.Brand;
import int222.integrated.Repositories.BrandJpaRepository;

@CrossOrigin
@RestController
public class BrandController {
	@Autowired
	private BrandJpaRepository brandJpa;

//  ---------------------------------- GetMapping ----------------------------------
	// Show a list of all brands.
	@GetMapping("/brand")
	public List<Brand> showAllBrands() {
		return brandJpa.findAll();
	}

	// Show list of brand by brandid
	@GetMapping("/brand/{brandid}")
	public Brand showBrand(@PathVariable int brandid) {
		Brand brand = this.brandJpa.findById(brandid).orElse(null);
		if (brand == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.BRAND_ID_DOES_NOT_EXIST,
					"brand id : " + brandid + " does not exist ");
		}
		return brand;
	}

//  ---------------------------------- PostMapping ----------------------------------
	// add brand
	@PostMapping(value = "/addbrand")
	public Brand createBrand(@RequestBody Brand newBrand) {
		return brandJpa.save(newBrand);
	}

//  ---------------------------------- DeleteMapping ----------------------------------
	// delete brand
	@DeleteMapping("/brand/{brandid}")
	public String delete(@PathVariable Integer brandid) {
		Brand brand = this.brandJpa.findById(brandid).orElse(null);
		if (brand == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.BRAND_ID_DOES_NOT_EXIST,
					"brand id : " + brandid + " does not exist ");
		}
		brandJpa.deleteById(brandid);
		return "Delete Brand Success";
	}
//  ---------------------------------- PutMapping ----------------------------------
	// update brand
	@PutMapping("/updatebrand")
	public Brand updateBrand(@RequestBody Brand newBrand) throws Exception {
		Brand editbrand = brandJpa.findById(newBrand.getBrandid()).orElse(null);
		if (editbrand != null) {
			editbrand.setBrandname(newBrand.getBrandname());
			editbrand.setBrandlink(newBrand.getBrandlink());
			brandJpa.save(editbrand);
		}
		return editbrand;
	}
}
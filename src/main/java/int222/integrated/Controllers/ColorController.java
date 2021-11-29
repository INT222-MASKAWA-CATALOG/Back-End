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
import int222.integrated.Models.Color;
import int222.integrated.Repositories.ColorJpaRepository;

@CrossOrigin
@RestController
public class ColorController {
	@Autowired
	private ColorJpaRepository colorJpa;

//  ---------------------------------- GetMapping ----------------------------------
	// Show a list of all colors.
	@GetMapping("/color")
	public List<Color> showAll() {
		return colorJpa.findAll();
	}

	// Show list of color by colorid
	@GetMapping("/color/{colorid}")
	public Color showBrand(@PathVariable int colorid) {
		Color color = this.colorJpa.findById(colorid).orElse(null);
		if (color == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.COLOR_ID_DOES_NOT_EXIST,
					"color id : " + colorid + " does not exist ");
		}
		return color;
	}

//  ---------------------------------- PostMapping ----------------------------------
	// add color
	@PostMapping(value = "/addcolor")
	public Color createColor(@RequestBody Color newColor) {
		return colorJpa.save(newColor);
	}

//  ---------------------------------- DeleteMapping ----------------------------------
	// delete color
	@DeleteMapping("/color/{colorid}")
	public String delete(@PathVariable Integer colorid) {
		Color color = this.colorJpa.findById(colorid).orElse(null);
		if (color == null) {
			throw new ProductException(ExceptionResponse.ERROR_CODE.COLOR_ID_DOES_NOT_EXIST,
					"color id : " + colorid + " does not exist ");
		}
		colorJpa.deleteById(colorid);
		return "Delete Color Success";
	}
	
//  ---------------------------------- PutMapping ----------------------------------
	// update color
	@PutMapping("/updatecolor")
	public Color updateColor(@RequestBody Color newColor) throws Exception {
		Color editcolor = colorJpa.findById(newColor.getColorid()).orElse(null);
		if (editcolor != null) {
			editcolor.setColorname(newColor.getColorname());
			editcolor.setHexcode(newColor.getHexcode());
			colorJpa.save(editcolor);
		}
		return editcolor;
	}
}
package int222.integrated.Models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "colorid")
	private int Colorid;

	@Column(name = "colorname")
	private String Colorname;
	
	@Column(name = "hexcode")
	private String Hexcode;
	
	@OneToMany(mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Product> product;

	public int getColorid() {
		return Colorid;
	}

	public void setColorid(int colorid) {
		Colorid = colorid;
	}

	public String getHexcode() {
		return Hexcode;
	}

	public void setHexcode(String hexcode) {
		Hexcode = hexcode;
	}

	public String getColorname() {
		return Colorname;
	}

	public void setColorname(String colorname) {
		Colorname = colorname;
	}


	

	

}
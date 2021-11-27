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
	private int colorid;

	@Column(name = "colorname")
	private String colorname;
	
	@Column(name = "hexcode")
	private String hexcode;
	
	@OneToMany(mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Product> product;

	public int getColorid() {
		return colorid;
	}

	public void setColorid(int colorid) {
		this.colorid = colorid;
	}

	public String getHexcode() {
		return hexcode;
	}

	public void setHexcode(String hexcode) {
		this.hexcode = hexcode;
	}

	public String getColorname() {
		return colorname;
	}

	public void setColorname(String colorname) {
		this.colorname = colorname;
	}


	

	

}

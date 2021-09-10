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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "colorid")
	private int Colorid;
	
	@Column(name = "hexcode")
	private String Hexcode;

	@Column(name = "colorname")
	private String Colorname;
	
	@OneToMany(mappedBy = "colorid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Product> product;

	

}

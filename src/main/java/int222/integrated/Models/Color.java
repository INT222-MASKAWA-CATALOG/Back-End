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
@Table(name = "Color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Colorid")
	private int Colorid;
	
	@Column(name = "Hexcode")
	private String Hexcode;

	@Column(name = "Colorname")
	private String Colorname;
	
	@OneToMany(mappedBy = "Colorid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Productcolor> productcolors;

	

}

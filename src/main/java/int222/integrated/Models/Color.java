package int222.integrated.Models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Color")
public class Color {

	@Id
	@Column(name = "Colorid")
	private int Colorid;

	@Column(name = "Colorname")
	private String Colorname;

	@Column(name = "Hexcode")
	private String Hexcode;

}

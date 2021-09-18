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
@Table(name = "brand")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brandid")
	private int Brandid;

	@Column(name = "brandname")
	private String Brandname;

	@Column(name = "brandlink")
	private String Brandlink;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Product> product;

	public int getBrandid() {
		return Brandid;
	}

	public void setBrandid(int brandid) {
		Brandid = brandid;
	}

	public String getBrandname() {
		return Brandname;
	}

	public void setBrandname(String brandname) {
		Brandname = brandname;
	}

	public String getBrandlink() {
		return Brandlink;
	}

	public void setBrandlink(String brandlink) {
		Brandlink = brandlink;
	}

	
	
}

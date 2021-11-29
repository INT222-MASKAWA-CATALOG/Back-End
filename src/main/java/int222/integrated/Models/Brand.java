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
	private int brandid;

	@Column(name = "brandname")
	private String brandname;

	@Column(name = "brandlink")
	private String brandlink;

	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Product> product;

//	Getter
	public int getBrandid() {
		return brandid;
	}

	public String getBrandname() {
		return brandname;
	}

	public String getBrandlink() {
		return brandlink;
	}

//	Setter
	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public void setBrandlink(String brandlink) {
		this.brandlink = brandlink;
	}

}

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "brandid")
	private int Brandid;

	@Column(name = "brandname")
	private String Brandname;

	@Column(name = "brandlink")
	private String Brandlink;
	
	@OneToMany(mappedBy = "brandid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Product> product;
}

package int222.integrated.Models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Brand")
public class Brand {

	@Id
	@Column(name = "Brandid")
	private int Brandid;

	@Column(name = "Brandname")
	private String Brandname;

	@Column(name = "Brandlink")
	private String Brandlink;
}

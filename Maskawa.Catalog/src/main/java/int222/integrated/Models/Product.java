package int222.integrated.Models;

import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@Column(name = "Productid")
	private int Productid;

	@Column(name = "Productname")
	private String Productname;

	@Column(name = "Price")
	private int Price;

	@Column(name = "Saledate")
	private java.sql.Date Saledate;

	@Column(name = "Description")
	private String Description;

	@Column(name = "Description")
	private String Productlink;

}

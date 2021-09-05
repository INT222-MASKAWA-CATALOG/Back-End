package int222.integrated.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "Productlink")
	private String Productlink;
	
	@Column(name = "Brandid")
	private String Brandid;
	
	@ManyToOne
    @JoinColumn(name = "Brandid", insertable = false, updatable = false)
	Brand brand;

//	@ManyToOne
//    @JoinColumn(name = "Userid", insertable = false, updatable = false)
//	Bookmark bookmark;
	
//	@ManyToOne
//    @JoinColumn(name = "Productid", insertable = false, updatable = false)
//	Bookmark bookmark;

}

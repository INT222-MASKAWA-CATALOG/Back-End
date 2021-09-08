package int222.integrated.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid")
	private int Productid;

	@Column(name = "productname")
	private String Productname;

	@Column(name = "price")
	private int Price;

	@Column(name = "saledate")
	private java.sql.Date Saledate;

	@Column(name = "description")
	private String Description;

	@Column(name = "productlink")
	private String Productlink;
	
	@Column(name = "brandid")
	private String Brandid;
	
	@ManyToOne
    @JoinColumn(name = "brandid", insertable = false, updatable = false)
	Brand brand;
	
	@OneToMany(mappedBy = "productid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Productcolor> productcolor;
	
	@OneToMany
	@JoinColumns( {
	    @JoinColumn(name="userid", referencedColumnName="userid"),
	    @JoinColumn(name="productid", referencedColumnName="productid")
	} )
	private Bookmark bookmark;


}

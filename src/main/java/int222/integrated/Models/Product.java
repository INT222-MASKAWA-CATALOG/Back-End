package int222.integrated.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private int Productid;

	@Column(name = "productname")
	private String Productname;

	@Column(name = "saledate")
	private java.sql.Date Saledate;
	
	@Column(name = "description")
	private String Description;

	@Column(name = "image")
	private String Image;
	
	@Column(name = "brandid")
	private int Brandid;
	
	@Column(name = "colorid")
	private int Colorid;
		
	
	@ManyToOne
    @JoinColumn(name = "brandid", insertable = false, updatable = false)
	Brand brand;

	@ManyToOne
    @JoinColumn(name = "colorid", insertable = false, updatable = false)
	Color color;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Onlineshop> onlineshop;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Record> record;
	

	public int getProductid() {
		return Productid;
	}

	public void setProductid(int productid) {
		this.Productid = productid;
	}

	public String getProductname() {
		return Productname;
	}

	public void setProductname(String productname) {
		this.Productname = productname;
	}

	public java.sql.Date getSaledate() {
		return Saledate;
	}
	
	public void setSaledate(java.sql.Date saledate) {
		this.Saledate = saledate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		this.Image = image;
	}

	public void setBrandid(int brandid) {
		this.Brandid = brandid;
	}

	public void setColorid(int colorid) {
		this.Colorid = colorid;
	}

//	public Brand getBrand() {
//		return brand;
//	}
	
	public String getBrandname() {
		return brand.getBrandname();
	}

	public String getColorname() {
		return color.getColorname();
	}
	
	public Set<Onlineshop> getOnlineshop() {
		return onlineshop;
		
	}

}

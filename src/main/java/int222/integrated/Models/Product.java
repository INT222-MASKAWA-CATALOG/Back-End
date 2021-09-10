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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "Brandid", insertable = false, updatable = false)
	Brand brand;

	@ManyToOne
    @JoinColumn(name = "Colorid", insertable = false, updatable = false)
	Color color;
	
	@OneToMany(mappedBy = "Shopid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Onlineshop> onlineshop;

	@OneToMany(mappedBy = "Recordid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Record> record;
	

	public int getProductid() {
		return Productid;
	}

	public void setProductid(int productid) {
		Productid = productid;
	}

	public String getProductname() {
		return Productname;
	}

	public void setProductname(String productname) {
		Productname = productname;
	}

	public java.sql.Date getSaledate() {
		return Saledate;
	}

	public void setSaledate(java.sql.Date saledate) {
		Saledate = saledate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public int getBrandid() {
		return Brandid;
	}

	public void setBrandid(int brandid) {
		Brandid = brandid;
	}

	public int getColorid() {
		return Colorid;
	}

	public void setColorid(int colorid) {
		Colorid = colorid;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}



	
	


}

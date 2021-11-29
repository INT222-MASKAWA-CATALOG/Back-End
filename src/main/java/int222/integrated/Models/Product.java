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
	private int productid;

	@Column(name = "productname")
	private String productname;

	@Column(name = "saledate")
	private String saledate;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "brandid")
	private int brandid;

	@Column(name = "colorid")
	private int colorid;

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

//	Getter
	public int getProductid() {
		return productid;
	}

	public String getProductname() {
		return productname;
	}

	public String getSaledate() {
		return saledate;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public int getBrandid() {
		return brand.getBrandid();
	}

	public String getBrandname() {
		return brand.getBrandname();
	}

	public int getColorid() {
		return color.getColorid();
	}

	public String getColorname() {
		return color.getColorname();
	}

	public Set<Onlineshop> getOnlineshop() {
		return onlineshop;
	}

//	Setter
	public void setProductid(int productid) {
		this.productid = productid;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public void setColorid(int colorid) {
		this.colorid = colorid;
	}
}
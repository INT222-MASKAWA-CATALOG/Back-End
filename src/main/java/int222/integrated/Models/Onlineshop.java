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
@Table(name = "onlineshop")
public class Onlineshop {
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "onlineid")
	private int Onlineid;
	
	@Column(name = "productid")
	private int Productid;
	
	@Column(name = "price")
	private Float Price;
	
	@Column(name = "productlink")
	private String Productlink;
	
	@Column(name = "shopid")
	private String Shopid;
	
	@ManyToOne //เชื่อมถูกแล้ว
    @JoinColumn(name = "productid", insertable = false , updatable = false)
	Product product;
	
	@ManyToOne //เชื่อมถูกแล้ว
    @JoinColumn(name = "shopid", insertable = false, updatable = false)
	Shop shop;
	
//	Getter
	public int getOnlineid() {
		return Onlineid;
	}

	public Float getPrice() {
		return Price;
	}

	public String getProductlink() {
		return Productlink;
	}
	
	public String getShopname() {
		return shop.getShopname();
	}
	
	public String getLogo() {
		return shop.getLogo();
	}
	
//	Setter
	public void setOnlineid(int onlineid) {
		Onlineid = onlineid;
	}

	public void setProductid(int productid) {
		Productid = productid;
	}

	public void setPrice(Float price) {
		Price = price;
	}

	public void setProductlink(String productlink) {
		Productlink = productlink;
	}

	public void setShopid(String shopid) {
		Shopid = shopid;
	}

	
	
		
}
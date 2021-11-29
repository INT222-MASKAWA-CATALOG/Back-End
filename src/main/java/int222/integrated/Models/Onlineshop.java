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
	private int onlineid;

	@Column(name = "productid")
	private int productid;

	@Column(name = "price")
	private Float price;

	@Column(name = "productlink")
	private String productlink;

	@Column(name = "shopid")
	private String shopid;

	@ManyToOne // เชื่อมถูกแล้ว
	@JoinColumn(name = "productid", insertable = false, updatable = false)
	Product product;

	@ManyToOne // เชื่อมถูกแล้ว
	@JoinColumn(name = "shopid", insertable = false, updatable = false)
	Shop shop;

//	Getter
	public int getOnlineid() {
		return onlineid;
	}

	public Float getPrice() {
		return price;
	}

	public String getProductlink() {
		return productlink;
	}

	public Shop getShop() {
        return shop;
    }

//	Setter
	public void setOnlineid(int onlineid) {
		this.onlineid = onlineid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setProductlink(String productlink) {
		this.productlink = productlink;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
}
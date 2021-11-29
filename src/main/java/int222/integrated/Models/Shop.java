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
@Table(name = "shop")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shopid")
	private int shopid;

	@Column(name = "shopname")
	private String shopname;

	@Column(name = "logo")
	private String logo;

	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Onlineshop> onlineshop;

//	Getter

	public int getShopid() {
		return shopid;
	}

	public String getLogo() {
		return logo;
	}

	public String getShopname() {
		return shopname;
	}

//	Setter

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}

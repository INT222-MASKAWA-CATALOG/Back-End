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
public class shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shopid")
	private int Shopid;

	@Column(name = "shopname")
	private String Shopname;

	@Column(name = "logo")
	private String Logo;
	
	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<onlineshop> onlineshop;

	public int getShopid() {
		return Shopid;
	}

	public void setShopid(int shopid) {
		Shopid = shopid;
	}

	public String getShopname() {
		return Shopname;
	}

	public void setShopname(String shopname) {
		Shopname = shopname;
	}

	public String getLogo() {
		return Logo;
	}

	public void setLogo(String logo) {
		Logo = logo;
	}
	
	
}

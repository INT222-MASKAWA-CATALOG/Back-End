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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shopid")
	private int Shopid;
	
	@Column(name = "brandid")
	private int Brandid;
	
	@Column(name = "price")
	private Float Price;
	
	@Column(name = "productlink")
	private String Productlink;
	
	@ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
	Product product;
}

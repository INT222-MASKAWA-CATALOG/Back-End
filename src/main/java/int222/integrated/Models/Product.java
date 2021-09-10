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
    @JoinColumn(name = "brandid", insertable = false, updatable = false)
	Brand brand;

	@ManyToOne
    @JoinColumn(name = "colorid", insertable = false, updatable = false)
	Color color;
	
	@OneToMany(mappedBy = "shopid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Onlineshop> onlineshop;

	@OneToMany(mappedBy = "recordid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Record> record;


}

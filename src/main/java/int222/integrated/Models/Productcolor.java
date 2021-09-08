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
@Table(name = "productcolor")
public class Productcolor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productcolorid")
	private int Productcolorid;

	@Column(name = "Pproductid")
	private int Productid;

	@Column(name = "colorid")
	private int Colorid;

	@Column(name = "imagepath")
	private String Imagepath;
	
	@ManyToOne
    @JoinColumn(name = "colorid", insertable = false, updatable = false)
    Color color;

	@ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    Product product;
}

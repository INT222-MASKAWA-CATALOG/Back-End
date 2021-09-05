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
@Table(name = "Productcolor")
public class Productcolor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Productcolorid")
	private int Productcolorid;

	@Column(name = "Productid")
	private int Productid;

	@Column(name = "Colorid")
	private int Colorid;

	@Column(name = "Imagepath")
	private String Imagepath;
	
	@ManyToOne
    @JoinColumn(name = "Colorid", insertable = false, updatable = false)
    Color color;

	@ManyToOne
    @JoinColumn(name = "Productid", insertable = false, updatable = false)
    Product product;
}

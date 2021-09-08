package int222.integrated.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productsize")
public class Productsize {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productsizeid")
	private int Productsizeid;
	
	@Column(name = "productcolorid")
	private int Productcolorid;
	
	@Column(name = "sizecode")
	private int Sizecode;
	
	@ManyToOne
    @JoinColumn(name = "sizecode", insertable = false, updatable = false)
	Size size;
	
	@ManyToOne
    @JoinColumn(name = "Productcolorid", insertable = false, updatable = false)
	Productcolor productcolor;
}

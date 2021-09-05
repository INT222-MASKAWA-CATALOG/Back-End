package int222.integrated.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bookmark")
public class Bookmark {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Userid")
	private int Userid;
	
	@Column(name = "Productid")
	private int Productid;
	
	@ManyToOne
    @JoinColumn(name = "Userid", insertable = false, updatable = false)
	Member member;
	
	@ManyToOne
    @JoinColumn(name = "Productid", insertable = false, updatable = false)
	Product product;
}

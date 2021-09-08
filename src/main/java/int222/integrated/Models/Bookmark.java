package int222.integrated.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookmark")
public class Bookmark {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int Userid;
	
	@Column(name = "productid")
	private int Productid;
	
	@ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
	Member member;
	
	@ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
	Product product;
	
	
}

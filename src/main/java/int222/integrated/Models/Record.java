package int222.integrated.Models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Record {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recordid")
	private int recordid;
	
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "productid")
	private int productid;
	
	@ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
	AuthenticationUser user;
	
	@ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
	Product product;

	public int getRecordid() {
		return recordid;
	}

	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	/*public Product getProduct() {
		return product;
	}*/

	
	
	
	
	
	
	
}

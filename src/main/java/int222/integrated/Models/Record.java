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

//	Getter

	public int getRecordid() {
		return recordid;
	}

	public int getProductid() {
		return productid;
	}

	public int getUserid() {
		return userid;
	}
	
	public Product getProduct() {
		return product;
	}

//	Setter

	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}
}
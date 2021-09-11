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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recordid")
	private int Recordid;
	
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

	public int getRecordid() {
		return Recordid;
	}

	public void setRecordid(int recordid) {
		Recordid = recordid;
	}

	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public int getProductid() {
		return Productid;
	}

	public void setProductid(int productid) {
		Productid = productid;
	}

	
	
}

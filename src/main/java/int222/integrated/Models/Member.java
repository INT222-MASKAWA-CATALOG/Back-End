package int222.integrated.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int Userid;

	@Column(name = "password")
	private String Password;

	@Column(name = "username")
	private String Username;

	@Column(name = "email")
	private String Email;

	@Column(name = "phonenumber")
	private String Phonenumber;

	@Column(name = "gender")
	private String Gender;
	
	@Column(name = "type")
	private String Type;

	@Column(name = "status")
	private String Status;
	
	@OneToMany
	@JoinColumns( {
	    @JoinColumn(name="userid", referencedColumnName="userid",insertable = false, updatable = false),
	    @JoinColumn(name="productid", referencedColumnName="productid",insertable = false, updatable = false)
	} )
	private Bookmark bookmark;
}

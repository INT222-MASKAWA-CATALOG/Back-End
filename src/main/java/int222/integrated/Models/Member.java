package int222.integrated.Models;

import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class Member {
	@Id
	@Column(name = "Userid")
	private int Userid;

	@Column(name = "Password")
	private String Password;

	@Column(name = "Username")
	private String Username;

	@Column(name = "Email")
	private String Email;

	@Column(name = "Phonenumber")
	private String Phonenumber;

	@Column(name = "Gender")
	private String Gender;

	@Column(name = "Status")
	private String Status;
}

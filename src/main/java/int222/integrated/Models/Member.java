package int222.integrated.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "status")
	private String Status;
	
	@OneToMany(mappedBy = "userid", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Record> record;


}

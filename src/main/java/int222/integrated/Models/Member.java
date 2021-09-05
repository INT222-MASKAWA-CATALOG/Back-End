package int222.integrated.Models;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
//	@OneToMany(mappedBy = "?????", cascade = CascadeType.ALL, orphanRemoval = true)
//	Set<Bookmark> bookmark;
}

package int222.integrated.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;

@Entity(name = "user")
public class AuthenticationUser /*extends User implements Serializable*/ {

	/*private static final long serialVersionUID = -7924450568553326886L;

	public AuthenticationUser() {
		super("anonymous", "", new ArrayList<>());
	}

	public AuthenticationUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int Userid;

	@Column(name = "password")
	private String Password;

	@Column(name = "username")
	private String Username;

	@Column(name = "email")
	private String Email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "gender")
	private String Gender;

	@Column(name = "roleid")
	private int Roleid;

	@ManyToOne
	@JoinColumn(name = "roleid", insertable = false, updatable = false)
	Role role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Record> record;

	public int getUserid() {
		return Userid;
	}

	public String getPassword() {
		return Password;
	}

	public String getUsername() {
		return Username;
	}

	public String getEmail() {
		return Email;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return Gender;
	}

}

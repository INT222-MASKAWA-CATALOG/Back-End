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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Entity(name = "user")
public class AuthenticationUser extends User implements Serializable {

	public AuthenticationUser() {
		super("anonymous", "", new ArrayList<>());
	}

	public AuthenticationUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private int userid;

	@Column(name = "password")
	private String pass;

	@Column(name = "username")
	private String usernames;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "gender")
	private String gender;

	@Column(name = "roleid")
	private int roleid;

	@ManyToOne
	@JoinColumn(name = "roleid", insertable = false, updatable = false)
	Role role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Record> record;

//	Getter

	public int getUserid() {
		return userid;
	}

	public String getPassword() {
		return pass;
	}

	public String getUsername() {
		return usernames;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	public int getRoleid() {
		return roleid;
	}

	public Role getRole() {
		return role;
	}

	public Set<Record> getRecord() {
		return record;
	}

//	Setter

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}

	public void setUsername(String username) {
		this.usernames = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setRecord(Set<Record> record) {
		this.record = record;
	}
}
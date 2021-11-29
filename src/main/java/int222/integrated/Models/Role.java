package int222.integrated.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleid")
	private int roleid;
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<AuthenticationUser> authenticationUser;

	@Column(name = "name")
	private String name;

//	Getter
	public String getName() {
		return name;
	}

}

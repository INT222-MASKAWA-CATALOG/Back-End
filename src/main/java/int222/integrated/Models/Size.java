package int222.integrated.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "size")
public class Size {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sizecode")
	private int Sizecode;
	
	@Column(name = "size")
	private int Size;
	
	@OneToMany(mappedBy = "sizecode", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Productsize> productsize;
}

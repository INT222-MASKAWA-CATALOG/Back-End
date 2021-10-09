package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int222.integrated.Models.product;

public interface ProductJpaRepository extends JpaRepository<product, Integer> {
	//product FindProductByProductName(String Productname);
}
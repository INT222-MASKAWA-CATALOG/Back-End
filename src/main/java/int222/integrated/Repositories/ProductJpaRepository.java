package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int222.integrated.Models.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
	//Product FindProductByProductName(String Productname);
}
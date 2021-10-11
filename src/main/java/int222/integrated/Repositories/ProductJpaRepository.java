package int222.integrated.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import int222.integrated.Models.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
	
	@Query("select Productname from Product")
	Product FindProductByProductName(String Productname);
}
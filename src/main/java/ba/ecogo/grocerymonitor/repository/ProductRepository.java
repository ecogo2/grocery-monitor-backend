package ba.ecogo.grocerymonitor.repository;

import ba.ecogo.grocerymonitor.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}

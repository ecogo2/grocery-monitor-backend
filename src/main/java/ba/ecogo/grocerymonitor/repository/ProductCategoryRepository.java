package ba.ecogo.grocerymonitor.repository;

import ba.ecogo.grocerymonitor.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
}

package ba.ecogo.grocerymonitor.repository;

import ba.ecogo.grocerymonitor.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ProductRepository extends BaseModelRepository<Product> {

}

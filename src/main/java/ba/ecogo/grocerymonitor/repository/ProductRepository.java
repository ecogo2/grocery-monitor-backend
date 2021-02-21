package ba.ecogo.grocerymonitor.repository;

import ba.ecogo.grocerymonitor.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ProductRepository extends BaseModelRepository<Product> {
//@Query("SELECT t FROM #{#entityName} t WHERE t.status <> 'DRAFT' AND t.reporter = :reporter AND t.active = true ORDER BY t.periodTo DESC")
//    @Query(value = "select p from Product p where p.id = :id and (p.userId IS NULL or p.userId = :userId)")
//    Product getAllByIdAndUserIdOrNull(UUID id, UUID userId);

}

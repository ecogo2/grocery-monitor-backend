package ba.ecogo.grocerymonitor.repository;

import ba.ecogo.grocerymonitor.model.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseModelRepository<T> extends JpaRepository<T, UUID> {

    T findByIdAndUserId(UUID id, UUID userId);

    @Query(value = "select t from #{#entityName} t where t.id = :id and (t.userId IS NULL or t.userId = :userId)")
    T getAllByIdAndUserIdOrNull(UUID id, UUID userId);

    @EntityGraph(attributePaths = {"items"})
    List<T> findByUserId(UUID userId);
}

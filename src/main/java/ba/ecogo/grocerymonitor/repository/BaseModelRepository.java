package ba.ecogo.grocerymonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseModelRepository<T> extends JpaRepository<T, UUID> {

    T findByIdAndUserId(UUID id, UUID userId);

}

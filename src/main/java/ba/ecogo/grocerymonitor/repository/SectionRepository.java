package ba.ecogo.grocerymonitor.repository;

import ba.ecogo.grocerymonitor.model.Section;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;
import java.util.UUID;

public interface SectionRepository extends BaseModelRepository<Section>{
    @Override
    @EntityGraph(attributePaths = {"items.product"})
    List<Section> findByUserId(UUID userId);

    @Override
    @EntityGraph(attributePaths = {"items.product"})
    Section findByIdAndUserId(UUID id, UUID userId);
}

package ba.ecogo.grocerymonitor.repository;

import ba.ecogo.grocerymonitor.model.base.CustomClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomClientDetailsRepository extends JpaRepository<CustomClientDetails, UUID> {
}

package ba.ecogo.grocerymonitor.api;


import ba.ecogo.grocerymonitor.model.BaseModel;
import ba.ecogo.grocerymonitor.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public abstract class BaseResource<T extends BaseModel, R extends JpaRepository<T, UUID>, S extends BaseService<T, R>> {



}

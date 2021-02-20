package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.base.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public abstract class BaseService<T extends BaseModel, R extends JpaRepository<T, UUID>> {

    @Autowired R repository;

}

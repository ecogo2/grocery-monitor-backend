package ba.ecogo.grocerymonitor.service.base;

import ba.ecogo.grocerymonitor.model.base.BaseModel;
import ba.ecogo.grocerymonitor.repository.BaseModelRepository;
import ba.ecogo.grocerymonitor.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public abstract class BaseService<T extends BaseModel, R extends BaseModelRepository<T>> {

    protected @Autowired SecurityService securityService;
    protected @Autowired R repository;
    protected T model;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public T createModel(T input) {
        logger.info("Saving {}, user id: {}", input.getClass().getSimpleName(), securityService.getToken().getUserId());
        input.setUserId(securityService.getToken().getUserId());
        return repository.saveAndFlush(input);
    }

    public T getModel(UUID input) {
        logger.info("Getting {}, user id: {}", input.getClass().getSimpleName(), securityService.getToken().getUserId());
        return repository.findByIdAndUserId(input, securityService.getToken().getUserId());
    }

    public List<T> getModels() {
        logger.info("Getting Objects, user id: {}", securityService.getToken().getUserId());
        return repository.findByUserId(securityService.getToken().getUserId());
    }

    public void deleteModel(UUID id) {
        logger.info("Deleting Object, user id: {}", securityService.getToken().getUserId());
        repository.delete(repository.findByIdAndUserId(id, securityService.getToken().getUserId()));
    }
}

package ba.ecogo.grocerymonitor.api.base;


import ba.ecogo.grocerymonitor.model.base.BaseModel;
import ba.ecogo.grocerymonitor.repository.BaseModelRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

public abstract class BaseResource<T extends BaseModel, R extends BaseModelRepository<T>, S extends BaseService<T, R>> {

    protected @Autowired S service;
    protected T model;

    @PostMapping
    @ResponseBody
    public T createModel(@RequestBody T input) {
        return service.createModel(input);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public T getModel(@PathVariable("id") UUID id) {
        return service.getModel(id);
    }

    @GetMapping()
    @ResponseBody
    public List<T> getModels() {
        return service.getModels();
    }

    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable("id") UUID id) {
        service.deleteModel(id);
    }
}

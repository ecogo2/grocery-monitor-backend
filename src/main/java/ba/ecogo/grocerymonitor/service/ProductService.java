package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.Product;
import ba.ecogo.grocerymonitor.repository.ProductRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService extends BaseService<Product, ProductRepository> {

    @Autowired ProductCategoryService productCategoryService;

    @Override
    public Product createModel(Product input) {
        input.setProductCategory(productCategoryService.getModel(input.getProductCategory().getId()));
        return super.createModel(input);
    }

    @Override
    public Product getModel(UUID input) {
        logger.info("Getting {}, user id: {}", input.getClass().getSimpleName(), securityService.getToken().getUserId());
        return repository.getAllByIdAndUserIdOrNull(input, securityService.getToken().getUserId());
    }
}

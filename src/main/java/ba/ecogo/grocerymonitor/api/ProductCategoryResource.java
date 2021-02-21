package ba.ecogo.grocerymonitor.api;

import ba.ecogo.grocerymonitor.api.base.BaseResource;
import ba.ecogo.grocerymonitor.model.ProductCategory;
import ba.ecogo.grocerymonitor.repository.ProductCategoryRepository;
import ba.ecogo.grocerymonitor.service.ProductCategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product-categories")
@PreAuthorize("hasAuthority('USER')")
public class ProductCategoryResource extends BaseResource<ProductCategory, ProductCategoryRepository, ProductCategoryService> {
}

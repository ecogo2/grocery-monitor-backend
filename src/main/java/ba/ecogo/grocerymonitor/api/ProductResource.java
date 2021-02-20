package ba.ecogo.grocerymonitor.api;

import ba.ecogo.grocerymonitor.api.base.BaseResource;
import ba.ecogo.grocerymonitor.model.Product;
import ba.ecogo.grocerymonitor.repository.ProductRepository;
import ba.ecogo.grocerymonitor.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
public class ProductResource extends BaseResource<Product, ProductRepository, ProductService> {
}

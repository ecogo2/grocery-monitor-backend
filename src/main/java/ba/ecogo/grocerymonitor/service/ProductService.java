package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.Product;
import ba.ecogo.grocerymonitor.repository.ProductRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product, ProductRepository> {
}

package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.Product;
import ba.ecogo.grocerymonitor.model.Section;
import ba.ecogo.grocerymonitor.model.SectionItem;
import ba.ecogo.grocerymonitor.model.in.SectionItemIn;
import ba.ecogo.grocerymonitor.repository.SectionRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SectionService extends BaseService<Section, SectionRepository> {

    @Autowired ProductService productService;

    @Override
    public Section createModel(Section input) {
        Set<SectionItem> items = input.getItems().stream().map(i -> {
            i.setProduct(productService.getModel(i.getProduct().getId()));
            i.setUserId(securityService.getToken().getUserId());
            return i;
        }).collect(Collectors.toSet());
        input.setItems(items);
        input.setUserId(securityService.getToken().getUserId());
        return super.createModel(input);
    }

    public Section addItem(SectionItemIn input) {
        Section section = repository.findByIdAndUserId(input.getSection(), securityService.getToken().getUserId());
        Product product = productService.getModel(input.getProduct());
        SectionItem item = new SectionItem(input, section, product);
        section.getItems().addAll(Set.of(item));
        return repository.saveAndFlush(section);
    }
}

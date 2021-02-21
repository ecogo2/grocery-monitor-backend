package ba.ecogo.grocerymonitor.api;

import ba.ecogo.grocerymonitor.api.base.BaseResource;
import ba.ecogo.grocerymonitor.model.SectionItem;
import ba.ecogo.grocerymonitor.model.in.SectionItemIn;
import ba.ecogo.grocerymonitor.repository.SectionItemRepository;
import ba.ecogo.grocerymonitor.service.SectionItemService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/section-items")
public class SectionItemResource extends BaseResource<SectionItem, SectionItemRepository, SectionItemService> {

    @PutMapping
    @ResponseBody
    public SectionItem updateItem(@RequestBody SectionItemIn input) {
       return service.updateItem(input);
    }

}

package ba.ecogo.grocerymonitor.api;

import ba.ecogo.grocerymonitor.api.base.BaseResource;
import ba.ecogo.grocerymonitor.model.GroupItem;
import ba.ecogo.grocerymonitor.repository.GroupItemRepository;
import ba.ecogo.grocerymonitor.service.GroupItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/group-items")
public class GroupItemResource extends BaseResource<GroupItem, GroupItemRepository, GroupItemService> {
}

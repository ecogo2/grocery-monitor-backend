package ba.ecogo.grocerymonitor.api;

import ba.ecogo.grocerymonitor.api.base.BaseResource;
import ba.ecogo.grocerymonitor.model.Group;
import ba.ecogo.grocerymonitor.repository.GroupRepository;
import ba.ecogo.grocerymonitor.service.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/groups")
public class GroupResource extends BaseResource<Group, GroupRepository, GroupService> {
}

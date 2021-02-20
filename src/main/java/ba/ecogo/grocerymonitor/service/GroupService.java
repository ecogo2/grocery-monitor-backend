package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.Group;
import ba.ecogo.grocerymonitor.repository.GroupRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends BaseService<Group, GroupRepository> {
}

package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.GroupItem;
import ba.ecogo.grocerymonitor.repository.GroupItemRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GroupItemService extends BaseService<GroupItem, GroupItemRepository> {
}

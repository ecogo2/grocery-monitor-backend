package ba.ecogo.grocerymonitor.api;

import ba.ecogo.grocerymonitor.api.base.BaseResource;
import ba.ecogo.grocerymonitor.model.Section;
import ba.ecogo.grocerymonitor.repository.SectionRepository;
import ba.ecogo.grocerymonitor.service.SectionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sections")
@PreAuthorize("hasAuthority('USER')")
public class SectionResource extends BaseResource<Section, SectionRepository, SectionService> {
}

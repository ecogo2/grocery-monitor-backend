package ba.ecogo.grocerymonitor.service;

import ba.ecogo.grocerymonitor.model.SectionItem;
import ba.ecogo.grocerymonitor.model.in.SectionItemIn;
import ba.ecogo.grocerymonitor.repository.SectionItemRepository;
import ba.ecogo.grocerymonitor.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionItemService extends BaseService<SectionItem, SectionItemRepository> {
    @Autowired ProductService productService;
    @Autowired SectionService sectionService;

    @Override
    public SectionItem createModel(SectionItem input) {
        logger.info("Saving {}, user id: {}", input.getClass().getSimpleName(), securityService.getToken().getUserId());
        input.setUserId(securityService.getToken().getUserId());
        input.setProduct(productService.getModel(input.getProduct().getId()));
        return repository.saveAndFlush(input);
    }

    public SectionItem updateItem(SectionItemIn input) {
        SectionItem item = repository.findByIdAndUserId(input.getId(), securityService.getToken().getUserId());
        if(input.getChangeRefQuantity() != null && input.getChangeRefQuantity())
            item.setRefQuantity(item.getCurrentQuantity());
        if(input.getCurrentQuantity() >= item.getRefQuantity())
            item.setRefQuantity(input.getCurrentQuantity());
        item.setPercentage(recalculatePercentage(item.getRefQuantity(), input.getCurrentQuantity()));
        return repository.saveAndFlush(updateItemModel(item, input));
    }

    private SectionItem updateItemModel(SectionItem model, SectionItemIn input) {
        if(input.getRefQuantity() != null)
            model.setRefQuantity(input.getRefQuantity());
        if(input.getCurrentQuantity() != null)
            model.setCurrentQuantity(input.getCurrentQuantity());
        if(input.getMeasurementUnit() != null)
            model.setMeasurementUnit(input.getMeasurementUnit());
        return model;
    }

    private Double recalculatePercentage(Double ref, Double curr) {
        return (curr / ref) * 100;
    }
}

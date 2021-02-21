package ba.ecogo.grocerymonitor.model.in;

import ba.ecogo.grocerymonitor.model.MeasurementUnit;
import ba.ecogo.grocerymonitor.model.base.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class SectionItemIn extends BaseModel {
    private UUID section;
    private UUID product;
    private Double refQuantity;
    private Double currentQuantity;
    private MeasurementUnit measurementUnit;
    private Double percentage;
    private Boolean changeRefQuantity;
}

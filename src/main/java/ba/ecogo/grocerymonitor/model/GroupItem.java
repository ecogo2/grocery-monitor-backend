package ba.ecogo.grocerymonitor.model;

import ba.ecogo.grocerymonitor.model.base.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name="group_item")
public class GroupItem extends BaseModel {

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "product_category", referencedColumnName = "id", nullable = false, insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "fk_group_item_group_id"))
    private Group group;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Product product;

    @Column(name = "ref_quantity")
    private Double refQuantity;

    @Column(name = "current_quantity")
    private Double currentQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "measurement_unit")
    private MeasurementUnit measurementUnit;

    @Column(name = "percentage")
    private Double percentage;

}

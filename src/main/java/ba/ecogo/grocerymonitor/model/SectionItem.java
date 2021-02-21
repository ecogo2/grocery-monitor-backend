package ba.ecogo.grocerymonitor.model;

import ba.ecogo.grocerymonitor.model.base.BaseModel;
import ba.ecogo.grocerymonitor.model.in.SectionItemIn;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.criteria.Selection;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name="section_item")
public class SectionItem extends BaseModel {

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "section_item", referencedColumnName = "id", nullable = false, insertable = true, updatable = true,
            foreignKey = @ForeignKey(name = "fk_section_item_section_id"))
    private Section section;

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

    public SectionItem(SectionItemIn input, Section section, Product product) {
        super();
        this.section = section;
        this.product = product;
        this.refQuantity = input.getRefQuantity();
        this.currentQuantity = input.getCurrentQuantity();
        this.measurementUnit = input.getMeasurementUnit();
        this.percentage = input.getPercentage();
    }

}

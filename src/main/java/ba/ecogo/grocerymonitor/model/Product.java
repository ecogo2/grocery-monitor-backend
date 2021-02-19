package ba.ecogo.grocerymonitor.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
public class Product extends BaseModel {

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "product_category", referencedColumnName = "id", nullable = false, insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "fk_product_category_product_id"))
    private ProductCategory productCategory;

    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "amount")
    private Double amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "measurement_unit")
    private MeasurementUnit measurementUnit;


}


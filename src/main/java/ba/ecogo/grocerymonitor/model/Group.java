package ba.ecogo.grocerymonitor.model;

import ba.ecogo.grocerymonitor.model.base.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name="group")
public class Group extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "priority")
    private Integer priority;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "group_items", referencedColumnName = "id", nullable = true, insertable = true, updatable = true)
    private Set<GroupItem> items = new HashSet<>();
}

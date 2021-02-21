package ba.ecogo.grocerymonitor.model.in;

import ba.ecogo.grocerymonitor.model.SectionItem;
import ba.ecogo.grocerymonitor.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class SelectionIn extends BaseModel {
    private String name;
    private Integer priority;
    private Set<SectionItem> items = new HashSet<>();
}

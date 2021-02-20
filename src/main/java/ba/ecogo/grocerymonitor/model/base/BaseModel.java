package ba.ecogo.grocerymonitor.model.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@MappedSuperclass
public class BaseModel {
    @Id
    protected UUID id;
    @Version
    protected Integer version;
    protected LocalDateTime dateCreated;
    protected UUID userId;

    @PrePersist
    private void populateFields() {
        if(this.id == null)
            this.id = UUID.randomUUID();
        if(this.dateCreated == null)
            this.dateCreated = LocalDateTime.now();
    }

}

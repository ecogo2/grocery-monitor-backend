package ba.ecogo.grocerymonitor.model.base;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    private UUID id;
    @Version
    private Integer version;
    private LocalDateTime dateCreated;
    private UUID userId;

}

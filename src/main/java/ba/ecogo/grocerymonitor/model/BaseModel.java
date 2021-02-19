package ba.ecogo.grocerymonitor.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    private UUID id;
    private LocalDateTime dateCreated;
    private UUID userId;

}

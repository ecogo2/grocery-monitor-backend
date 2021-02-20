package ba.ecogo.grocerymonitor.model.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class JWT implements Serializable {
    private static final long serialVersionUID = 5806403392739298628L;

    private @ToString.Exclude
    UUID userId;
    private @JsonProperty("user_name")
    String userName;
    private @ToString.Exclude
    List<String> authorities = new ArrayList<>();

}

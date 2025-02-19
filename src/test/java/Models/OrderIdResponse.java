package Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderIdResponse {
    private int Id;
    private long petId;
    private int quantity;
    private String shipDate;
    private String status;
    private Boolean complete;
}

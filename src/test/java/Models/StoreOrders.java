package Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class StoreOrders {
    private long id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private Boolean complete;

}

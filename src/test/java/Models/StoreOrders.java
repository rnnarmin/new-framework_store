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

//    public int getId() { return id; }
//    public int getPetId() { return petId; }
//    public int getQuantity() { return quantity; }
//    public String getShipDate() { return shipDate; }
//    public String getStatus() { return status; }
//    public Boolean getComplete() { return complete; }
//
//    // Сеттеры
//    public void setId(int id) { this.id = id; }
//    public void setPetId(int petId) { this.petId = petId; }
//    public void setQuantity(int quantity) { this.quantity = quantity; }
//    public void setShipDate(String shipDate) { this.shipDate = shipDate; }
//    public void setStatus(String status) { this.status = status; }
//    public void setComplete(Boolean complete) { this.complete = complete; }
}

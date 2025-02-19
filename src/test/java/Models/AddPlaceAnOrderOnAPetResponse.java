package Models;


import lombok.Data;

@Data
public class AddPlaceAnOrderOnAPetResponse {
            private long id;
            private int petId;
            private int quantity;
            private String shipDate;
            private String status;
            private Boolean complete;
}

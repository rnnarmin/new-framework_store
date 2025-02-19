package Models;


import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class AddPlaceAnOrderOnAPetResponse {
            private long id;
            private int petId;
            private int quantity;
            private String shipDate;
            private String status;
            private Boolean complete;
            private int orderId;
            private int code;
}

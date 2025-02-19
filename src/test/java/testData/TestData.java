package testData;

import Models.OrderById;
import Models.StoreOrders;
import io.restassured.builder.RequestSpecBuilder;

public class TestData {

    public static final StoreOrders DEFAULT_STORE_ORDERS = StoreOrders.builder()
            .id(0)
            .petId(0)
            .quantity(0)
            .shipDate("2025-02-18T10:47:40.873Z")
            .status("placed")
            .complete(true)
            .build();
    public static final StoreOrders INVALID_STORE_ORDERS = StoreOrders.builder().build();


    public static final OrderById DEFAULT_ORDER_BY_ID = OrderById.builder()
            .orderId(1)
            .build();

}
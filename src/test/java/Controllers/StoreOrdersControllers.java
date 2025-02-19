package Controllers;

import Models.StoreOrders;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static Constants.CommonConstants.BASE_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static testData.TestData.DEFAULT_STORE_ORDERS;

public class StoreOrdersControllers {
    RequestSpecification requestSpecification;
    public static final String STORE_ORDERS_ENDPOINT= "store/order";

    public StoreOrdersControllers() {
        this.requestSpecification = given()
                .accept(JSON)
                .contentType(JSON)
                .baseUri(BASE_URL);
    }

    public Response createStoreOrders(StoreOrders storeOrders) {
        return given(this.requestSpecification)
                .body(storeOrders)
                .when()
                .post(STORE_ORDERS_ENDPOINT)
                .andReturn();
    }
}

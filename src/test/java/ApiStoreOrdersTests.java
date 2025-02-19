import Controllers.StoreOrdersControllers;
import Models.AddPlaceAnOrderOnAPetResponse;
import Models.OrderIdResponse;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static Constants.CommonConstants.BASE_URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static Controllers.StoreOrdersControllers.STORE_ORDERS_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testData.TestData.DEFAULT_ORDER_BY_ID;
import static testData.TestData.DEFAULT_STORE_ORDERS;


public class ApiStoreOrdersTests {


    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    void postStoreOrdersTest() {
        String bodyJSon = """
                {
                    "id": 0,
                    "petId": 0,
                    "quantity": 0,
                    "shipDate": "2025-02-18T09:38:21.571Z",
                    "status": "placed",
                    "complete": true
                }""";

        ValidatableResponse response =
                given()
                        .header("accept", "application/json")
                        .header("Content-Type", "application/json")
                        .body(bodyJSon)
                        .when()
                        .post(BASE_URL+STORE_ORDERS_ENDPOINT)
                        .then()
                        .statusCode(200)
                        .body("petId", Matchers.notNullValue())
                        .body("petId", Matchers.equalTo(0))
                        .body("quantity", Matchers.equalTo(0))
                        .body("status", Matchers.equalTo("placed"))
                        .body("complete", Matchers.equalTo(true));

        System.out.println(response);

    }
/*
    StoreOrders storeOrders = new StoreOrders(
            0,
            0,
            0,
            "shipDate",
            "status",
        true);*/

    @Test
    void createStoreOrdersControllerTest(){
        Response response = new StoreOrdersControllers().createStoreOrders(DEFAULT_STORE_ORDERS);
        AddPlaceAnOrderOnAPetResponse createStoreOrdersResponse = response.as(AddPlaceAnOrderOnAPetResponse.class);

        assertEquals(200,response.getStatusCode());
        Assertions.assertNotNull(response.body().jsonPath().getLong("id"), "ID is null!");
        assertEquals(0,createStoreOrdersResponse.getPetId());
        assertEquals(0,createStoreOrdersResponse.getQuantity());
        Assertions.assertEquals(response.body().jsonPath().get("status"), "placed");
        Assertions.assertNotNull(response.body().jsonPath().getChar("shipDate"), "SHIPDATE is null!");
    }

    @Test
    void findOrdersByIdControllerTest(){

        Response response = new StoreOrdersControllers().findOrdersById(DEFAULT_ORDER_BY_ID);
        Assertions.assertEquals(200,response.getStatusCode());

        if (response.getContentType() != null && response.getContentType().contains("application/json")) {
            OrderIdResponse orderIdResponse = response.as(OrderIdResponse.class);
            Assertions.assertNotNull(response.body().jsonPath().getInt("id"), "ID is null!");
        } else {
            System.out.println("Response is not JSON. Raw response: " + response.getBody().asString());
        }
    }

}


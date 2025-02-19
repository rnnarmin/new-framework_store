import Controllers.StoreOrdersControllers;
import Models.AddPlaceAnOrderOnAPetResponse;
import Models.StoreOrders;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static Constants.CommonConstants.BASE_URL;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static Constants.CommonConstants.BASE_URL;
import static Controllers.StoreOrdersControllers.STORE_ORDERS_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

}


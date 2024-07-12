package com.emirhanarici.order_service.web.controllers;

import com.emirhanarici.order_service.AbstractIT;
import com.emirhanarici.order_service.testdata.TestDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;


class OrderControllerTests extends AbstractIT {


    @Nested
    class CreateOrderTests {
        /*
        @Test
        void shouldCreateOrderSuccessfully() {
            mockGetProductByCode("P100", "Product 1", new BigDecimal("25.50"));
            var payload =
                    """
                                {
                                    "customer" : {
                                        "name": "emirhan",
                                        "email": "emirhan@gmail.com",
                                        "phone": "999999999"
                                    },
                                    "deliveryAddress" : {
                                        "addressLine1": "HNO 123",
                                        "addressLine2": "Kukatpally",
                                        "city": "Kocaeli",
                                        "state": "Kandira",
                                        "zipCode": "500072",
                                        "country": "Turkey"
                                    },
                                    "items": [
                                        {
                                            "code": "P100",
                                            "name": "Product 1",
                                            "price": 25.50,
                                            "quantity": 1
                                        }
                                    ]
                                }
                            """;
            given().contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post("/api/orders")
                    .then()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("orderNumber", notNullValue());
        }
         */

        @Test
        void shouldReturnBadRequestWhenMandatoryDataIsMissing() {
            var payload = TestDataFactory.createOrderRequestWithInvalidCustomer();
            given().contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post("/api/orders")
                    .then()
                    .statusCode(HttpStatus.BAD_REQUEST.value());
        }
    }
}

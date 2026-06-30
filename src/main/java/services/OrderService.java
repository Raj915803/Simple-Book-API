package services;

import constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.OrderRequest;
import payloads.UpdateOrderRequest;

import static io.restassured.RestAssured.*;

public class OrderService {

	public Response createOrder(String token, OrderRequest request) {

		return given()

				.contentType(ContentType.JSON)

				.header("Authorization", "Bearer " + token)

				.body(request)

				.when()

				.post(EndPoints.ORDERS);
	}

	public Response getOrder(String token, String orderId) {

		return given()

				.header("Authorization", "Bearer " + token)

				.when()

				.get(EndPoints.ORDERS + "/" + orderId);
	}

	public Response updateOrder(String token, String orderId, UpdateOrderRequest request) {

		return given()

				.contentType(ContentType.JSON)

				.header("Authorization", "Bearer " + token)

				.body(request)

				.when()

				.patch(EndPoints.ORDERS + "/" + orderId);
	}

	public Response deleteOrder(String token, String orderId) {

		return given()

				.header("Authorization", "Bearer " + token)

				.when()

				.delete(EndPoints.ORDERS + "/" + orderId);
	}
}
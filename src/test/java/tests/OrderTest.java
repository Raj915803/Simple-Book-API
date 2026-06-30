package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.OrderRequest;
import payloads.UpdateOrderRequest;
import services.OrderService;
import utils.TokenManager;

public class OrderTest extends BaseTest {

	private static String orderId;

	OrderService service = new OrderService();

	@Test
	public void createOrder() {

		OrderRequest request = new OrderRequest(1, "Rajkumar");

		Response response = service.createOrder(TokenManager.getToken(), request);

		Assert.assertEquals(response.statusCode(), 201);

		Assert.assertTrue(response.jsonPath().getBoolean("created"));

		orderId = response.jsonPath().getString("orderId");
	}

	@Test(dependsOnMethods = "createOrder")
	public void getOrder() {

		Response response = service.getOrder(TokenManager.getToken(), orderId);

		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(dependsOnMethods = "getOrder")
	public void updateOrder() {

		UpdateOrderRequest request = new UpdateOrderRequest("Automation Tester");

		Response response = service.updateOrder(TokenManager.getToken(), orderId, request);

		Assert.assertEquals(response.statusCode(), 204);
	}

	@Test(dependsOnMethods = "updateOrder")
	public void verifyUpdatedOrder() {

		Response response = service.getOrder(TokenManager.getToken(), orderId);

		response.then().statusCode(200).body("customerName", org.hamcrest.Matchers.equalTo("Automation Tester"));
	}

	@Test(dependsOnMethods = "verifyUpdatedOrder")
	public void deleteOrder() {

		Response response = service.deleteOrder(TokenManager.getToken(), orderId);

		Assert.assertEquals(response.statusCode(), 204);
	}
}
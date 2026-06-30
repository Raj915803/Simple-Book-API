package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class NegativeTest extends BaseTest {

	@Test
	public void invalidTokenTest() {

		given()

				.header("Authorization", "Bearer InvalidToken")

				.when()

				.get("/orders")

				.then()

				.statusCode(401);
	}
}
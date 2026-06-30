package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StatusTest extends BaseTest {

	@Test
	public void verifyStatus() {

		given()

				.when()

				.get("/status")

				.then()

				.statusCode(200)

				.body("status", equalTo("OK"));
	}
}
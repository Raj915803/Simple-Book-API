package services;

import constants.EndPoints;
import io.restassured.http.ContentType;
import payloads.ClientRequest;

import static io.restassured.RestAssured.*;

public class AuthService {

	public String generateToken() {

		ClientRequest request = new ClientRequest("Rajkumar", "raj" + System.currentTimeMillis() + "@gmail.com");

		return

		given()

				.contentType(ContentType.JSON)

				.body(request)

				.when()

				.post(EndPoints.CLIENTS)

				.then()

				.statusCode(201)

				.extract()

				.path("accessToken");
	}
}
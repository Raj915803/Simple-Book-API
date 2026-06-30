package services;

import constants.EndPoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BookService {

	public Response getBooks() {

		return given()

				.when()

				.get(EndPoints.BOOKS);
	}

	public Response getBooksByType(String type, int limit) {

		return given()

				.queryParam("type", type)

				.queryParam("limit", limit)

				.when()

				.get(EndPoints.BOOKS);
	}
}
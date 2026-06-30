package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.BookService;

public class BooksTest extends BaseTest {

	BookService service = new BookService();

	@Test
	public void getAllBooks() {

		Response response = service.getBooks();

		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test
	public void getFictionBooks() {

		Response response = service.getBooksByType("fiction", 2);

		Assert.assertEquals(response.statusCode(), 200);
	}
}
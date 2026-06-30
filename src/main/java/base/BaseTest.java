package base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;
import utils.LogUtil;

public class BaseTest {

	@BeforeSuite
	public void setup() {

		RestAssured.baseURI = "https://simple-books-api.click";

		RestAssured.filters(

				new RequestLoggingFilter(), new ResponseLoggingFilter(),

				new RequestLoggingFilter(LogUtil.getPrintStream()),

				new ResponseLoggingFilter(LogUtil.getPrintStream()));
	}
}

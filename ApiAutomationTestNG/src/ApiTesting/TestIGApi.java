package ApiTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.ApiTestIG;
import utility.Common;
import utility.RequestUtility;

public class TestIGApi {
	@Test(priority = 0)
	public void AssertStatusCode() {
		Common.assertStatus();

	}

	@Test(priority = 1)
	public void AssertHeaderContent() {
		Common.assertHeaders();

	}

	@Test(priority = 2)
	public void AssertBodyIGApi() {
		Common.validateBodyIG();
	}

	@Test(priority = 3)
	public void validateCompanyName() {
		Common.validateCompany();
	}

	
	@BeforeClass
	public void beforeClass() {
		String url = "http://demo4032024.mockable.io";
		String basicpath = "/apitest";

		String response = "";
		RestAssured.baseURI = url;
		Response res = RequestUtility.httpRequest(basicpath);
		response = res.asString();
		new ApiTestIG(response);
		Common.validateStatus(res);
		Common.validateHeaders(res);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TestCompleted");
	}
}

package utility;

import models.ApiTestIG;
import org.testng.Assert;

import io.restassured.response.Response;

public class Common {
	private static int succesful_get = 200;
	private static String contentType = "application/json; charset=UTF-8";
	private static String server = "Google Frontend";
	private static int statusCode;
	private static String contentTypeRes;
	private static String serverNameRes;

	public static void validateStatus(Response responseMsg) {
		setStatusCode(responseMsg.statusCode());

	}

	public static void validateHeaders(Response responseMsg) {
		responseMsg.then().header("Content-Type", contentType).header("Server", server);
		setContentType(responseMsg.header("Content-Type"));
		setServerName(responseMsg.header("Server"));

	}

	public static void validateBodyIG() {
		Assert.assertEquals(ApiTestIG.status, 200);
		Assert.assertEquals(ApiTestIG.age, 25);
		Assert.assertEquals(ApiTestIG.role, "QA Automation Developer");
		Assert.assertEquals(ApiTestIG.message, "data retrieved successful");

	}

	public static void validateCompany() {
		Assert.assertEquals(ApiTestIG.company, "ABC Infotech");
	}

	public static int getStatusCode() {
		return statusCode;
	}

	private static void setStatusCode(int statusCode) {
		Common.statusCode = statusCode;
	}

	public static String getServerName() {
		return serverNameRes;
	}

	private static void setServerName(String serverName) {
		Common.serverNameRes = serverName;
	}

	public static String getContentType() {
		return contentTypeRes;
	}

	private static void setContentType(String contentType) {
		Common.contentTypeRes = contentType;
	}

	public static void assertStatus() {
		Assert.assertEquals(getStatusCode(), succesful_get);
	}

	public static void assertHeaders() {
		Assert.assertEquals(getServerName(), server);
		Assert.assertEquals(getContentType(), contentType);
	}

}

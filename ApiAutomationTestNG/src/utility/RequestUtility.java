package utility;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class RequestUtility {
	

	public static Response httpRequest(String urlPath) {
		return given().log().all().header("Content-Type", "application/json").get(urlPath);
	}

}

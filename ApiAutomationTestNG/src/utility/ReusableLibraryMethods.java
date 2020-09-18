package utility;
import io.restassured.path.json.JsonPath;

public class ReusableLibraryMethods {

	public static JsonPath convertToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}
}

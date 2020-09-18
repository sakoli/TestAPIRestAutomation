package models;

import io.restassured.path.json.JsonPath;
import utility.ReusableLibraryMethods;

public class ApiTestIG {
public static int status;
public static String id;
public static int age;
public static String name;
public static String dob;
public static String company;
public static String role;
public static String message;

	public ApiTestIG(String response){
		JsonPath js = ReusableLibraryMethods.convertToJson(response);
		 
		ApiTestIG.status = js.get("status");
		ApiTestIG.id = js.getString("employeeData[0].id");
		ApiTestIG.age = js.get("employeeData[0].age");
		ApiTestIG.name = js.getString("employeeData[0].name");
		ApiTestIG.dob = js.getString("employeeData[0].dob");
		ApiTestIG.company = js.getString("employeeData[0].company");
		ApiTestIG.role = js.getString("employeeData[0].role");
		ApiTestIG.message = js.getString("message");
		
		
	}
}

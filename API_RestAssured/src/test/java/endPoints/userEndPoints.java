package endPoints;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.AddressDetails;
import payload.UserDetails;

public class userEndPoints {
	

	private static int USER_ID;
	private static String USER_FIRST_NAME;
	
	public static String getUSER_FIRST_NAME() {
		return USER_FIRST_NAME;
	}

	public static void setUSER_FIRST_NAME(String uSER_FIRST_NAME) {
		USER_FIRST_NAME = uSER_FIRST_NAME;
	}

	public static int getUSER_ID() {
		return USER_ID;
	}

	public static void setUSER_ID(int userId) {
		USER_ID = userId;
	}

	public static Response create_user(String userPayload,String endpoint)
	{
		Response response=
		given().auth().basic("Numpy@gmail.com", "userapi@2025")
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(userPayload)
		
		.when()
		.post(endpoint);
		
		return response;
		
		 

	}

	public static Response get_allusers(String endpoint)
	{
		Response response=
		given()
		.auth().basic("Numpy@gmail.com", "userapi@2025")		
		.when()
		.get(endpoint);
		
		return response;
		
	}

	public static Response get_byusername(String endpoint)
	{
		Response response=
		given()
		.auth().basic("Numpy@gmail.com", "userapi@2025")		
		.when()
		.get(endpoint);
		
		return response;
		
	}

	public static Response getBy_userId(String payload)
	{
		Response response=
		given()
		.auth().basic("Numpy@gmail.com", "userapi@2025")
		.when()
		.get(payload);
		
		return response;
		
	}

	public static Response update_user(String payload,String endpoint)
	{
		Response response=
		given()
		.auth().basic("Numpy@gmail.com", "userapi@2025")
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.put(endpoint);
		
		return response;
		
	}

	public static Response delete_byuserId(String payload)
	{
		Response response=
		given()
		.auth().basic("Numpy@gmail.com", "userapi@2025")
		.when()
		.delete(payload);
		
		return response;
		
	}
	
	public static Response delete_byuserName(String endpoint)
	{
		Response response=
		given()
		.auth().basic("Numpy@gmail.com", "userapi@2025")
		.when()
		.delete(endpoint);
		
		return response;
		
	}

 public UserDetails setRequestBody(String user_first_name, String user_last_name, String user_contact_number, 
			String user_email_id, String plotNumber, String street, String state, 
		String country, String zipCode)
{
	
	UserDetails userDetailsObj=new UserDetails();
	AddressDetails addressDetailsObj=new AddressDetails();
	
	
	addressDetailsObj.setPlotNumber(plotNumber);
	addressDetailsObj.setStreet(street);
	addressDetailsObj.setState(state);
	addressDetailsObj.setCountry(country);
	addressDetailsObj.setZipCode(zipCode);
	
	userDetailsObj.setUser_first_name(user_first_name);
	userDetailsObj.setUser_last_name(user_last_name);
	userDetailsObj.setUser_contact_number(user_contact_number);
	userDetailsObj.setUser_email_id(user_email_id);
	userDetailsObj.setUserAddress(addressDetailsObj);
	
	return userDetailsObj;
}
}

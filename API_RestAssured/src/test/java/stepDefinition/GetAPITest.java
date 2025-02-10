package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.CommonUtilities;
import utilities.ExcelReader;
 
 

public class GetAPITest  {
	
	String baseURl="https://userserviceapp-f5a54828541b.herokuapp.com/uap";
	String userId;
	String userFirstname;
	String updateJson;
	Response createresponse,response,response1,response2,response3,getresponse, getresponse2,Update_response1;
	 ExcelReader excelreader = new ExcelReader("/Users/praveenag/Desktop/API/excel1New.xlsx", "excel1New");

	JSONObject request,request1;
//	private Map<String, Object> requestBody = new HashMap<>();
//	private Response response;
 
 

	@Given("user is given base url")
	public void user_is_given_base_url() {
	 	 
		
	     RestAssured.baseURI=baseURl;
 		

	}

	@When("User make a GET request to get all users with endpoint")
	public void user_make_a_get_request_to_get_all_users_with_endpoint() {
		
 
		RestAssured.requestSpecification = given();
		 response = RestAssured.requestSpecification
				 .auth().basic("Numpy@gmail.com", "userapi@2025")
				 .when()
				  .get("/users").then().extract().response();
		
 
	}

	@Then("User get response with all the users with staus code")
	public void user_get_response_with_all_the_users_with_staus_code() {
//		response.getStatusCode();
//		Assert.assertEquals(response.getStatusCode(),200);
		System.out.print("All Users : Response--> " + response.getBody().asPrettyString());
		int actRespStatCode=response.getStatusCode();
//		Assertions.assertEquals(actRespStatCode, 200);
 	}

	@Given("Admin create 1st user with base url")
	public void admin_create_1st_user_with_base_url() {
		
		RestAssured.baseURI= baseURl;
		
	}

	@When("user make a post request with end point {string}")
	public void user_make_a_post_request_with_end_point(String string) {
	   
		try
		
		{
	        List<List<String>> data;
 		    data = ExcelReader.readExcelData(); // Replace with your actual Excel reading method

		    // Assuming the first row is a header and data starts from the second row
		    for (int i = 1; i < data.size(); i++)
		    {
		    	 
		        List<String> row = data.get(i);

		        // Adjust these indices based on your Excel structure
		        String user_first_name = row.get(1);
		        String user_last_name =row.get(2);
		        String user_contact_number = row.get(3);
		        String user_email_id = row.get(4);
		        String plotNumber = row.get(5);
		        String street =row.get(6);
		        String state = row.get(7);
		        String country = row.get(8);
		        String zipCode = row.get(9);
		         

		        // Construct the JSON payload
		       String jsonBody = String.format(
		        	    "{\n" +
		        	    "  \"userAddress\": {\n" +
		        	    "    \"plotNumber\": \"%s\",\n" +
		        	    "    \"street\": \"%s\",\n" +
		        	    "    \"state\": \"%s\",\n" +
		        	    "    \"country\": \"%s\",\n" +
		        	    "    \"zipCode\": \"%s\"\n" +
		        	    "  },\n" +
		        	    "  \"user_first_name\": \"%s\",\n" +
		        	    "  \"user_last_name\": \"%s\",\n" +
		        	    "  \"user_contact_number\": \"%s\",\n" +
		        	    "  \"user_email_id\": \"%s\"\n" +
		        	    "}", 
		        	    plotNumber, street, state, country, zipCode, 
		        	    user_first_name, user_last_name, user_contact_number, user_email_id
		        	);
		              
		            
////		        System.out.println("Request Body : " + jsonBody);
				RestAssured.requestSpecification = given();
//				  
				  
				   response1 = RestAssured.requestSpecification.auth().
						    basic("Numpy@gmail.com", "userapi@2025").
						    contentType("application/json").
						    body(jsonBody).when().
						    post("/createusers")
						    .then().extract().response();
//				String responseBody = response1.getBody().asPrettyString();

				JsonPath js = new JsonPath(jsonBody);
				 userId = js.getString("user_id");
				userFirstname= js.getString("user_first_name");
			
		 		System.out.println("Response Body: " +  jsonBody);
			        System.out.println("Response Status Code:\n " + response1.getStatusCode());
			        userId = js.getString("user_id");
					userFirstname= js.getString("user_first_name");
		    }
		
		}
			catch (IOException e) {
					 System.err.println("Error: " + e.getMessage());
						e.printStackTrace();
					}		
		    	      
			}

	 


	@Then("user should get response body and status code")
	public void user_should_get_response_body_and_status_code()
	{	 
	
 		if (response.getStatusCode() == 201) {
            // Successfully created
            System.out.println("User creates successfully.");
        } else if (response.getStatusCode() == 400) {
            // Bad request - log error message
            System.out.println("Error: " + response.getBody().asString());
        }else if(response.getStatusCode() == 409) {
            System.out.println("Error: " + response.getBody().asString());

        }
	}

	@When("user make a get request using ID with end point")
	public void user_make_a_get_request_using_id_with_end_point() {
		RestAssured.baseURI = baseURl;

		response1 = RestAssured.requestSpecification.auth().
			    basic("Numpy@gmail.com", "userapi@2025").when().get("/user/"+userId).then().extract().response();
		
	
	}

	@Then("user should get status code and responsebody")
	public void user_should_get_status_code_and_responsebody() {
		Assert.assertEquals(response1.statusCode(), 200);

		System.out.println("\n Status code is:" + response1.statusCode());

	}

	@When("user make a get request using FirstName with end point")
	public void user_make_a_get_request_using_first_name_with_end_point() {
		response1 = RestAssured.requestSpecification.auth().
			    basic("Numpy@gmail.com", "userapi@2025").when().get("/users/username/"+ userFirstname).then().extract().response();

	}

	@Then("user should get status code and response")
	public void user_should_get_status_code_and_response() {
		Assert.assertEquals(getresponse2.statusCode(), 200);

		System.out.println("\n Status code is:" + response1.statusCode());
	
	}

	@When("User make a PUT request to update program by using userId\\(update 1st user) with endpoint")
	public void user_make_a_put_request_to_update_program_by_using_user_id_update_1st_user_with_endpoint() {
		 
		 String updateJson = "{ \"street\": \"Newzen\" }";
		 
		 Update_response1=RestAssured.given()
        .contentType(ContentType.JSON)
        .body(updateJson)
        .when().auth().
		    basic("Numpy@gmail.com", "userapi@2025").when().put("/updateuser/" + userId).then().extract()
			.response();
        
		 System.out.println("Response Body: " +  Update_response1);

	}
	@Then("User should get status code and updated response body")
	public void user_should_get_status_code_and_updated_response_body() {

		if (Update_response1.getStatusCode() == 200) {
            // Successfully updated
            System.out.println("User updated successfully.");
        } else if (Update_response1.getStatusCode() == 400) {
            // Bad request - log error message
            System.out.println("Error: " + Update_response1.getBody().asString());
        }         
        

        // Assert that the response code is as expected (e.g., 200)
        Assert.assertEquals(Update_response1.getStatusCode(), 200);
    
	
	}

	@When("User make a DELETE request using FirstName with end point")
	public void user_make_a_delete_request_using_first_name_with_end_point() {
		 response3 = RestAssured.requestSpecification.auth().
				    basic("Numpy@gmail.com", "userapi@2025").when().delete("/deleteuser/username/" + userFirstname).then().extract().response();

	}

	@Then("User gets status code and user will be deleted")
	public void user_gets_status_code_and_user_will_be_deleted() {

		if ( response3.getStatusCode() == 200) {
             
            System.out.println("User deleted successfully.");
        }   else {
            // Not found
            System.out.println("Error: User not found.");
        }
		Assert.assertEquals(response3.statusCode(), 200);
	}

	@When("User make a DELETE request using ID with end point")
	public void user_make_a_delete_request_using_id_with_end_point() {
		RestAssured.baseURI = baseURl;
		 response2 = RestAssured.requestSpecification.auth().
			    basic("Numpy@gmail.com", "userapi@2025").when().delete("/deleteuser/" + userId).then().extract().response();

	}

	@Then("User gets status code with message")
	public void user_gets_status_code_with_message() {
 if ( response2.getStatusCode() == 200) {
            
            System.out.println("User deleted successfully.");
        }  else {
            // Not found
            System.out.println("Error: User not found.");
        }
		Assert.assertEquals( response2.statusCode(), 200);

	
	}
}

	
	
	
	
	
	
	
	 
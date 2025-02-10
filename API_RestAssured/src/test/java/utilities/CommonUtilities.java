package utilities;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class CommonUtilities {
	
	public static ArrayList<Integer> userIDArrList= new ArrayList<>();
	public static ArrayList<String> userFnameArrList= new ArrayList<>();
	public static ResourceBundle endpoints = ResourceBundle.getBundle("endpoint");

	public static String BASE_URI = endpoints.getString("baseURI");
	public static String EXCEL_PATH = endpoints.getString("excelPath");
	public static String USERNAME = endpoints.getString("username");
	public static String PASSWORD = endpoints.getString("password");
	public static String createUserEndpoint = endpoints.getString("createUserEndpoint");
	public static String getUserByIDEndpoint = endpoints.getString("getUserByIDEndPoint");
 	public static String getAllUsersEndPoint = endpoints.getString("getAllUsersEndPoint");
	public static String getUserByFirstNameEndPoint = endpoints.getString("getUserByFirstNameEndPoint");
	public static String updateUserEndpoint = endpoints.getString("updateUserByIDEndPoint");
	public static String deleteUserByIDEndPoint = endpoints.getString("deleteUserByIDEndPoint");
	public static String deleteUserByFNameEndPoint = endpoints.getString("deleteUserByFNameEndPoint");
	
	

    public static void setUserID(int userId) {
    	 System.out.println("In Set id array>>>"+userIDArrList);    	 
    	 userIDArrList.add(userId);
    	 System.out.println("In Set userID >>>"+ userIDArrList);
    }

    public static ArrayList<Integer> getUserID() {
    	
    	 System.out.println("In Get >>>"+userIDArrList);
        return userIDArrList;
    }

	public static void setUserFirstName(String userFirstName) {
		userFnameArrList.add(userFirstName);
		System.out.println("In Set user FName >>>"+ userFnameArrList);
	}
	
	  public static ArrayList<String> getUserFirstName() {
	    	
	    	 System.out.println("In Get >>>"+userFnameArrList);
	        return userFnameArrList;
	    }
}

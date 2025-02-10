package endPoints;

public class Routes {
	 

		public static String base_URL="https://userserviceapp-f5a54828541b.herokuapp.com/uap/";
		public static String filePath="src/test/resources/sample1.json";
		
		public static String post_URL=base_URL+"createusers";
		public static String getAllUsers_URL=base_URL+"users";
		public static String getByUserID_URL=base_URL+"user/{userID}";
		public static String getByUserName_URL=base_URL+"users/username/{userFirstName}";
		public static String put_URL=base_URL+"updateuser/{userId}";
		public static String deleteByUserName_URL=base_URL+"deleteuser/username/{userfirstname";
		public static String deleteByUserId_URL=base_URL+"deleteuser/{userId}";
	}


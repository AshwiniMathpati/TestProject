
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Create extends Search {
	
	  
	 @Test
	 public void Create1() throws Exception {
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
		Response res=given().auth().oauth(prop.getProperty("consumerkey"), prop.getProperty("consumerSecret"),prop.getProperty("Token"), prop.getProperty("TokenSecret")).
		queryParam("status","I am learning API testing using RestAssured    Java1  #Qualitest")
		.when().post("/update.json").then().extract().response();
				
		String response=res.asString();                 
		System.out.println(response);
		JsonPath js=new JsonPath(response);                
		String id=js.get("id").toString();
		System.out.println(id);
		String text=js.get("text").toString();
		System.out.println(text);
				
				
	}

}
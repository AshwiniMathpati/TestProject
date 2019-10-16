import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Search {
	public static Properties prop=new Properties();
	@Test
	public void searchTweet() throws Exception {
	FileInputStream fis=new FileInputStream("C:\\Users\\Online Test\\Desktop\\Ashwini\\TwitterApi\\src\\data.properties");
       prop.load(fis);
       
	RestAssured.baseURI="https://api.twitter.com/1.1/search/";
	Response res=given().auth().oauth(prop.getProperty("consumerkey"), prop.getProperty("consumerSecret"),prop.getProperty("Token"), prop.getProperty("TokenSecret")).
	queryParam("q","Qualitest")
	.when().get("/tweets.json").then().extract().response();
    String response=res.asString();
    System.out.println(response);
  }

}

	

	



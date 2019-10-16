
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Username {
	String consumerkey="2Xtd4ILUtinfACHehAvCNcbjW";
	String consumerSecret="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	
	@Test
	public void usernameTweet() {
		RestAssured.baseURI="https://api.twitter.com/1.1/search/tweets.json";
		Response res=given().auth().oauth(consumerkey, consumerSecret, Token, TokenSecret).
	   queryParam("q","Qualitest")
	   .when().get().then().statusCode(200).and().contentType(ContentType.JSON).
        extract().response();
		String response=res.asString();
		JsonPath js=new JsonPath(response);
		int count=js.get("status.size()");
		System.out.println(count);
		
		for(int i=0;i<count;i++)
		{
			String username=js.get("statuses["+i+"].user.screen_name");
			System.out.println(username);
			
		}

		
		
	}
		
}




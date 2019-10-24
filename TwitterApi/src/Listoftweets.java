import static io.restassured.RestAssured.given;
import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Listoftweets {
	
	String consumerkey="2Xtd4ILUtinfACHehAvCNcbjW";
	String consumerSecret="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	
	 public void searchTweet() throws IOException
	    {
	       operation  p = new operation();
	        
	        
	        RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
	        Response res=given().auth().oauth(consumerkey, consumerSecret, Token, TokenSecret).
	        param("screen_name",p.getUsers()).
	        when().
	        get("/user_timeline.json").
	        then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
	        extract().response();
	        
	        System.out.println(p.getUsers());
	        String response = res.asString();
	        //System.out.println(response);

	 

	        JsonPath js = new JsonPath(response);
	         String Text = js.get("text").toString();
	        System.out.println(Text);
	        
	    }
	}



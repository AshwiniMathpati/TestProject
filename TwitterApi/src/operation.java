import static io.restassured.RestAssured.given;
import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

 public class operation {
	
	String consumerkey="2Xtd4ILUtinfACHehAvCNcbjW";
	String consumerSecret="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
 

  public String getUsers() throws IOException
    {
        RestAssured.baseURI = "https://api.twitter.com/1.1/users/search.json";
        Response res=given().auth().oauth(consumerkey, consumerSecret, Token, TokenSecret).
        param("q","Barack Obama").
        when().
        get().
        then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
        extract().response();
        
        String response = res.asString();
        //System.out.println(response);
        
        JsonPath js = new JsonPath(response);
        int count = js.get("size()");
        //System.out.println(count);
        
        for(int i=0;i<count;i++)
        {
            String User = js.get("["+i+"].screen_name");
            //System.out.println(User);
            if(User.equalsIgnoreCase("Barack Obama"))
            {
                return User;
            }
        }
        return null;
    }
}
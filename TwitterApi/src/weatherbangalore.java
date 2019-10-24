import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;

public class weatherbangalore {
	

	String consumerkey="2Xtd4ILUtinfACHehAvCNcbjW";
	String consumerSecret="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
	
	@Test
    public void Bengaluru()
    {
    RestAssured.baseURI = "https://api.twitter.com/1.1/search";
    Response res= given().auth().oauth(consumerkey,consumerSecret,Token,TokenSecret).
    param("q","weather.Banglore").
    when().get("/tweets.json").
    then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
    extract().response();
   
    String response = res.asString();
    System.out.println(response);
    
    JsonPath js = new JsonPath(response);
    int count = js.get("statuses.size()");
    //System.out.println(count);
   
    String resp;
    for(int i=0;i<count;i++)
    {
    	 String place = js.get("statuses["+i+"].user.location").toString();
         if(place.contains("Bengaluru")||place.contains("Bangalore"))
         {
             resp = js.get("statuses["+i+"]").toString();
             System.out.println(resp);
    
    }
    }
    }
}







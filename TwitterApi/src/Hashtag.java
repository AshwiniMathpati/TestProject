import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

 

public class Hashtag {

	String consumerkey="2Xtd4ILUtinfACHehAvCNcbjW";
	String consumerSecret="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
	String Token="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
	String TokenSecret="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";

   @Test
    public void DisplayHashtag() throws IOException
    {
	   RestAssured.baseURI="https://api.twitter.com/1.1/trends";
    	Response res=given().auth().oauth(consumerkey, consumerSecret, Token, TokenSecret).
        when().
        get("/available.json").then().assertThat().statusCode(200).contentType(ContentType.JSON).
        extract().response();
        
        String response=res.asString();
        //System.out.println(response);
        JsonPath js=new JsonPath(response);
        int count=js.get("size()");
        for(int i=0;i<count;i++)
        {
           String country=js.get("["+i+"].country").toString();
           if(country.equalsIgnoreCase("India"))
            {
             String id=js.get("["+i+"].parentid").toString();
             Response res1=given().auth().oauth(consumerkey, consumerSecret, Token, TokenSecret).
             param("id",id).
             when().
             get("/place.json").then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
               String response1=res1.asString();
                //System.out.println(response1);
                 JsonPath js1=new JsonPath(response1);
                 int count1=js1.get("["+0+"].trends.size()");
                  for(int j=0;j<count1;j++)
                   {
                 String Hashtag = js1.getString("["+0+"].trends["+j+"].name");
                  String actual = js1.getString("["+0+"].trends["+j+"]");
                  if(Hashtag.charAt(0)=='#' && j<=5)
                  {
                   System.out.println(actual);
                  }
                  }
                    break;
            }
        }
    }
}
 
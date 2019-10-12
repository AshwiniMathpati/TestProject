import org.testng.annotations.Test;

 public class Registration extends Function
{
	
	LaunchBrowser l1=new LaunchBrowser();
	Function s1=new Function();
	
	@Test
	 public void demo() throws Exception {
        
     l1.browser();
     s1.SignUpPage();
    

 

   }
    
    
    
    
}
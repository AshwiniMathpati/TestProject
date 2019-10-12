import org.testng.annotations.Test;

public class HotelSearch extends Function{
	@Test
	public void login1()throws Exception {
		LaunchBrowser l1=new LaunchBrowser();
		l1.browser();
		hotelsearch();
		
	
	}
	

}

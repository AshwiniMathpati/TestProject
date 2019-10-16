import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


 public class Function extends LaunchBrowser{
    
	      By MyAccountButton = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@class='dropdown-toggle go-text-right'][contains(text(),'My Account')]");
          By SignUpButton = By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Sign Up')]");
          By Firstname = By.xpath("//input[@name='firstname']");
          By Lastname = By.xpath("//input[@name='lastname']");
          By MNumber = By.xpath("//input[@name='phone']");
          By MailId = By.xpath("//input[@name='email']");
          By Password = By.xpath("//input[@name='password']");
          By CnfPassword = By.xpath("//input[@name='confirmpassword']");
          By SighnupBtn = By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']");
          By cookie=By.xpath("//button[@id='cookyGotItBtn']");
          By loginButton=By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Login')]");
          By Hmail=By.xpath("//input[@placeholder='Email']");
          By Hpassword=By.xpath("//input[@placeholder='Password']");
          By loginbutt = By.xpath("//button[@class='btn btn-action btn-lg btn-block loginbtn']");
          By HotelSearchField=By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']");
          By TextFromSearchDropdown=By.xpath("//div[contains(text(),'galore, India')]");
          By checkin=By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']");
         // By next=By.xpath("//div[14]//div[1]//tr[1]//th[3]");
          By checkout=By.xpath("//input[@placeholder='Check out']");
		  By Guest=By.xpath("//input[@id='htravellersInput']");
		  By Adult=By.xpath("//input[@id='hadultInput']");
		  By Child=By.xpath("//input[@id='hchildInput']");
          By Click_Search=By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']");
          By Tours=By.xpath("//a[@title='Tours']");
          By ToursSearch=By.xpath("//div[@id='s2id_autogen3']//a[@class='select2-choice select2-default']");
          By TourSearchKeys=By.xpath("/html[1]/body[1]/div[6]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/a[1]");
          By TourLink=By.xpath("/html[1]/body[1]/div[20]/ul[1]/li[1]/ul[1]/li[1]/div[1]");
          By Checkin=By.xpath("//div[@id='tchkin']//input[@placeholder='Check in']");
          By Guests=By.xpath("//select[@id='adults']");
          By TourType=By.xpath("//select[@id='tourtype']");
          By Searchbtn=By.xpath("//div[@class='col-md-2 form-group go-right col-xs-12 search-button']//button[@class='btn-primary btn btn-lg btn-block pfb0 loader'][contains(text(),'Search')]");

          //registration
          public void SignUpPage() 
          {
        	  driver.findElement(MyAccountButton).click();
        	  driver.findElement(SignUpButton).click();
        	  driver.findElement(Firstname).sendKeys(prop.getProperty("Firstname"));
        	  driver.findElement(Lastname).sendKeys(prop.getProperty("Lastname"));
        	  driver.findElement(MNumber).sendKeys(prop.getProperty("Mobilenumber"));
        	  driver.findElement(MailId).sendKeys(prop.getProperty("EMailId"));
        	  driver.findElement(Password).sendKeys(prop.getProperty("password"));
        	  driver.findElement(CnfPassword).sendKeys(prop.getProperty("password"));
        	  driver.findElement(cookie).click();
        	  driver.findElement(SighnupBtn).click();
        	  
        
         }
          
          //hotel search
          
          public void hotelsearch() throws Exception{
        	  driver.findElement(HotelSearchField).click();
        	  driver.findElement(HotelSearchField).sendKeys(prop.getProperty("cityname"));
        	  driver.findElement(HotelSearchField).sendKeys(Keys.DOWN);
        	  driver.findElement(TextFromSearchDropdown).click();
        	  
       //checkin 	  
        	  driver.findElement(checkin).click();
        	  
        	  while(true)
         {
        		String str= driver.findElement(By.xpath("/html[1]/body[1]/div[14]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
    
         	 if(str.equals(prop.getProperty("inmonth")))
         	 {
         		 break;
         		 
         	 }
         	 else
         	 {
         		 driver.findElement(By.xpath("//input[@placeholder='Check out']")).click();
         		 
         	 }
         }
        	  driver.findElement(By.xpath("//div[14]//tr//td[contains(text(),"+prop.getProperty("indate")+")]")).click();
          
          
          //checkout
          while(true)

          {

          String str=driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[2]")).getText();

          if(str.equalsIgnoreCase(prop.getProperty("outmonth")))

          {

          break;

          }

          else

          {

          driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[3]")).click();

          }

          }

          driver.findElement(By.xpath("//div[15]//tr//td[contains(text(),"+prop.getProperty("outdate")+")]")).click();
          
        //number of guest
          driver.findElement(Guest).click();
          driver.findElement(Adult).sendKeys(Keys.BACK_SPACE);
          driver.findElement(Adult).sendKeys(prop.getProperty("Adults"));
          driver.findElement(Child).sendKeys(Keys.BACK_SPACE);
          driver.findElement(Child).sendKeys(prop.getProperty("child"));
          driver.findElement(Click_Search).click();
          }
 //Tour serach
        public void Tour() throws Exception {
        driver.findElement(Tours).click();
        driver.findElement(ToursSearch).click();
        driver.findElement(TourSearchKeys).sendKeys(prop.getProperty("TourPickUp"));
		 driver.findElement(TourLink).click();

        driver.findElement(Checkin).click();

        	  Thread.sleep(1000);
        	  
        	  while(true)

        	  {

        	  String str=driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[2]")).getText();

        	  if(str.equalsIgnoreCase(prop.getProperty("inmonth")))

        	  {

        	  break;

        	  }

        	  else

        	  {

        	  driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[3]")).click();

        	  }

        	  }

        	  driver.findElement(By.xpath("//div[11]//tr//td[contains(text(),"+prop.getProperty("indate")+")]")).click();
        	 driver.findElement(Guests).click();

        	 driver.findElement(TourType).click();

        	 driver.findElement(Searchbtn).click();
        	  
          }
          
          
        
          
      
        
          
          
          
         //login
          
        public void Login() throws Exception {
    	  driver.findElement(MyAccountButton).click();
    	  driver.findElement(loginButton).click();
    	  driver.findElement(Hmail).sendKeys(prop.getProperty("Hemailid"));
    	  driver.findElement(Hpassword).sendKeys(prop.getProperty("Hpass"));
    	  driver.findElement(loginbutt).click();
    	  String currentUrl=driver.getCurrentUrl();
    	  String homeUrl=prop.getProperty("https://www.phptravels.net/account/");
	  
	  if(currentUrl!=homeUrl) 
	  {
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File ("C:\\Users\\Online Test\\Desktop\\Ashwini\\ScriptScreenshort\\login.png"));
	  }
	  else
	  {
		  System.out.println("sucessfully login into account home page");
	  }
	  
      }
        
        
        
      }
      
      
      
    	  
    	  
    	
      
 
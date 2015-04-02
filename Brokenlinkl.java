package seleniumTutorial.ff;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.thoughtworks.selenium.Wait;

 

public class Brokenlinkl {

       static int statuscode;

 

       public static void main(String[] args) throws Exception {

WebDriver driver=new FirefoxDriver();

driver.get("http://mi.tv");

Thread.sleep(2000);

driver.findElement(By.xpath(".//*[@id='js-country-select-child-container']/li[1]/a")).click();

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

List<WebElement> linklist = driver.findElements(By.tagName("a"));
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

//System.out.println(linklist.size());

for (int j=0;j<linklist.size();j++)

{
	String links = linklist.get(j).getAttribute("href");

    System.out.println(links);
    if(!(linklist.get(j).getAttribute("href")==null) && !(linklist.get(j).getAttribute("href")).equals(""))

    {

           if(linklist.get(j).getAttribute("href").contains("http"))

           {
    statuscode=getresponsecode(linklist.get(j).getAttribute("href").trim());

    if(statuscode==404)

    {

          System.out.println("Broken link is "+linklist.get(j).getAttribute("href"));

    }
           }
    }
} 
    
System.out.println(linklist.size());
System.out.println("There is no broken link");


        }

public static int getresponsecode(String a ) throws IOException

{

       URL url=new URL(a);

       HttpURLConnection b = (HttpURLConnection) url.openConnection();

       b.getRequestMethod();

       b.connect();

       return b.getResponseCode();

       }

       }


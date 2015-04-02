package seleniumTutorial.ff;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Addingtvlinks {
 
	public static void main(String[] args) throws Exception {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://mi.tv");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='js-country-select-child-container']/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.findElement(By.xpath("html/body/div[1]/div[5]/nav/div[2]/div[4]/a")).click();
driver.findElement(By.xpath("html/body/div[1]/div[6]/div/div/div[2]/fieldset/ul/li[2]/button")).click();
driver.findElement(By.xpath("html/body/div[1]/div[6]/div/div/div[3]/a")).click();
driver.findElement(By.xpath("html/body/div[1]/div[6]/div/div/div[2]/form/fieldset[2]/ul/li[1]/input")).sendKeys("meyamz@gmail.com");;
driver.findElement(By.xpath("html/body/div[1]/div[6]/div/div/div[2]/form/fieldset[2]/ul/li[2]/input")).sendKeys("s1s!k@l@");
driver.findElement(By.xpath("html/body/div[1]/div[6]/div/div/div[2]/form/fieldset[2]/ul/li[3]/button")).click();
driver.findElement(By.xpath("html/body/div[1]/div[6]/section/div[2]/div/ul/li[2]/a")).click();
//driver.findElements(By.xpath("//a[@class='selected']"));
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//List<WebElement> removeelement =driver.findElements(By.xpath("//a[@class='selected']/ancestor:://*[@class='cover']"));
//System.out.println("removeelement");

List<WebElement> now =  driver.findElements(By.xpath("//a[@class='selected']"));
for (int j=0;j<now.size();j++)
{
now.get(j).click();
}
driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//getting all the image textS ( )
HashSet<String> set1 = new HashSet<String>();
List<WebElement> def = driver.findElements(By.xpath("//div[2]/div[2]/h3/span"));
//for (int i=0;i<def.size();i++)
	int index1=0;
	for(WebElement var1:def )
	{
	String selection1 = var1.getText();
index1=index1+1;
set1.add(selection1);
	}
	System.out.println("inside loop");
for(Object var1:set1)
{
System.out.println(var1);
}

driver.findElement(By.xpath("html/body/div[1]/div[5]/nav/div[1]/a[1]/img")).click();
driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
System.out.println("check in home page");
HashSet<String> set2 = new HashSet<String>();
List<WebElement> hometext = driver.findElements(By.xpath("//a[@class='channel-link']"));
int index2=0;
	for(WebElement var2:hometext )
	{
	String selection2 = var2.getAttribute("title");
	System.out.println(selection2);
	Thread.sleep(2000);
index2=index2+1;
set2.add(selection2);
	}
	System.out.println("inside second loop");
for(Object var2:set2)
{
System.out.println(var2);
//System.out.println("no element exist");
}
if(set1.equals(set2))
//if(home.equals(set1))
//if(set2.equals(set1))
{
	System.out.println("removed channels exist in home page");
}
else
{
System.out.println("removed channels does not exist in home page");
}

	}
	
}


/*List<WebElement> abc = driver.findElements(By.xpath("//a[@class='selected']"));
for (int i=0;i<abc.size();i++)

{
System.out.println(abc.get(i).getText());
}*/

//getting all the channels
/*List<WebElement> imagetext=driver.findElements(By.xpath("//a[@class='selected']/ancestor::div//div[@class='title']/h3/span"));
for(int i=0;i<imagetext.size();i++)
{
	System.out.println("- one");
System.out.println(imagetext.get(i).getText());
}*/
/*
If(hometext.get(k).getText().equals(def.get(j).getText()) 
		{
	
		}*/
				
//*[@class='cover']    - all image icons 
//a[@class='selected']-   - icon
//div[2]/div[2]/h3/span - icon text 

 
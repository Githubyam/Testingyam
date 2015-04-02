package seleniumTutorial.ff;

import java.util.HashSet;

import java.util.List;

import java.util.Set;

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

 

public class Broadcast {

String starttime;

String endtime;

public static String showtime;

public static String correcttime;

       public static void main(String[] args) throws InterruptedException {

              WebDriver driver =new FirefoxDriver();

              driver.get("http://mi.tv");

              driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

              driver.findElement(By.xpath(".//*[@id='js-country-select-child-container']/li[1]/a")).click();

              Thread.sleep(1000);

              driver.findElement(By.xpath(".//*[@id='login']")).click();

              driver.findElement(By.xpath(".//*[@id='app-main-region']/div/div/div[2]/fieldset/ul/li[2]/button")).click();

              driver.findElement(By.xpath(".//*[@id='app-main-region']/div/div/div[3]/a")).click();

              driver.findElement(By.xpath(".//*[@id='app-main-region']/div/div/div[2]/form/fieldset[2]/ul/li[1]/input")).sendKeys("meyamz@gmail.com");

              driver.findElement(By.xpath(".//*[@id='app-main-region']/div/div/div[2]/form/fieldset[2]/ul/li[2]/input")).sendKeys("s1s!k@l@");

              driver.findElement(By.xpath(".//*[@id='app-main-region']/div/div/div[2]/form/fieldset[2]/ul/li[3]/button")).click();

              Thread.sleep(1000);

              driver.findElement(By.xpath(".//*[@id='app-navigation-region']/nav/div[1]/a[1]/img")).click();

              System.out.println("Logged in succesfully");

              driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

              System.out.println("displayed home page");

              //getting the timings in home page

        List<WebElement> timings = driver.findElements(By.xpath("//a[@class='program-link']/span/time"));

        Thread.sleep(2000);

        HashSet set1=new HashSet();

              for(int i=0;i<timings.size()-1;i++)

              {

              String starttime=timings.get(i).getText();

              String endtime=timings.get(i+1).getText();

              String showtime=starttime.concat(" - "+endtime);

              //System.out.println(showtime);

              set1.add(showtime);

              }

              for(Object set1var:set1)

              {

              System.out.println(set1var);

              }

              System.out.println("printed all the timings");

              //click on program links

              List<WebElement> shows =driver.findElements(By.xpath("//a[@class='program-link']"));

              HashSet set2=new HashSet();

                  for(int j=0;j<shows.size()-1;j++)

                  {

                                  List<WebElement> nextshow = driver.findElements(By.xpath("//a[@class='program-link']"));

                                  nextshow.get(j).click();

                                  String timing=driver.findElement(By.xpath("//time")).getText();

                                  String correcttime=timing.replaceAll(".*, ", "");

                                   //System.out.println(correcttime);

                                  set2.add(correcttime);

                                   driver.findElement(By.xpath(".//*[@id='app-navigation-region']/nav/div[1]/a[1]/img")).click();

                  }

               

                                   for(Object set2var:set2)

                                   {

                                                   System.out.println(set2var);

                                   }

                  try{  

                     if(set1.equals(set2))

                     {

                           System.out.println("There is no gap between the programs");

                     }     

                     else{

                                 System.out.println("There is a gap between the program");

                     }

                    

                    }

              catch(Exception e)

              {

                  e.printStackTrace();

              }

           

                }

            

}
package Training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WebTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/WebTable/");
        driver.manage().window().maximize();
        WebElement global_search = driver.findElement(By.xpath("//input[@type='search' and @placeholder='global search']"));
        global_search.sendKeys("PolGermain@whatever.com");
//        global_search.sendKeys("Pol");
        global_search.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        List<WebElement> row =driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
        List<List<String>> webRows = new ArrayList<>();
        for(int i=0;i<row.size();i++){

            List<String> rowdata =new ArrayList<>();
            List<WebElement> values = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr["+(i+1)+"]/td"));
            for(int j=0;j<values.size();j++){
                rowdata.add(values.get(j).getText());
            }
            webRows.add(rowdata);
        }

        for (int s = 0; s < webRows.size(); s++) {
            List<String> row1 = webRows.get(s);
            System.out.println(row1);
            System.out.println(row1.get(1));
        }
    }
}

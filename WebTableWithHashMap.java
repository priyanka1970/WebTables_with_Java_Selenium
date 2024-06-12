package Training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebTableWithHashMap {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/WebTable/");
        driver.manage().window().maximize();
        WebElement global_search = driver.findElement(By.xpath("//input[@type='search' and @placeholder='global search']"));
        global_search.sendKeys("PolGermain@whatever.com");
//        global_search.sendKeys("Pol");
        global_search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
        System.out.println("size-"+rows.size());
        List<Map<String, String>> webRows = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> keys = driver.findElements(By.xpath("//table[@class='table table-striped']/thead/tr[1]/th"));
            List<WebElement> values = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr["+(i+1)+"]/td"));
            Map<String, String> webColumn = new HashMap<>();
            try {
                for (int j = 0; i < keys.size(); j++) {
                    webColumn.put(keys.get(j).getText(), values.get(j).getText());
                }
            } catch (Exception e) {
            }
            webRows.add(webColumn);
        }

        for (int s = 0; s < webRows.size(); s++) {
            System.out.println(webRows.get(s).get("lastName"));
            System.out.println(webRows.get(s));
        }

    }
}

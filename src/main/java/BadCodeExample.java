import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) {
        //System.out.println("Hello world!!!");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SkillUP_Student\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //driver.findElement(new By.ByName("q")).sendKeys("Selenium", Keys.ENTER);

        String searchTerm = "Selenium";

        WebElement searchField1 = driver.findElement(By.xpath("//input[@name='q']"));
        searchField1.sendKeys(searchTerm);
        searchField1.sendKeys(Keys.ENTER);

        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='srg']/div"));
        //List<WebElement> searchResultElements = driver.findElements(By.xpath("//span[@class='st']"));
        System.out.println("Serch Results Count: " + searchResultElements.size());


        //For each WebElement in searchResultElements print text
        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText();
            System.out.println(searchResultElementText);
            if (searchResultElementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("searchTerm found");
            } else {
                System.out.println("searchTerm not found");
            }
        }

    }
}

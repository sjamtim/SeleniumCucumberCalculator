package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {
WebDriver driver;
    // Background
    @Given("I have navigated to the website")
    public void iHaveNavigatedToTheWebsite() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Given("I have entered {int} into the calculator")
    public void i_have_entered_into_the_calculator(int firstNumber) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement searchBox = driver.findElement(By.name("n01"));
        searchBox.sendKeys(Integer.toString(firstNumber));
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
    @And("I have also entered {int} into the calculator")
    public void i_have_also_entered_into_the_calculator(int secondNumber) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement searchBox = driver.findElement(By.name("n02"));
        searchBox.sendKeys(Integer.toString(secondNumber));
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);  //
    }
    @When("I press add")
    public void i_press_add() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement addBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
        addBox.click();
        Thread.sleep(1000);
    }
    @Then("the result should be {int} on the screen")
    public void the_result_should_be_on_the_screen(int thirdNumber) {
        // Write code here that turns the phrase above into concrete actions
        WebElement searchBox = driver.findElement(By.name("answer"));
        assertEquals(thirdNumber, Integer.parseInt(searchBox.getAttribute("value")));
        driver.quit();

    }


}

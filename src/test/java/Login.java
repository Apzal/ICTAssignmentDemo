import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    private By txtUserName=By.id("txtUsername");
    private By txtPassword=By.id("txtPassword");
    private By txtLogin=By.id("btnLogin");
    public Login(WebDriver driver){
        this.driver=driver;
    }

    public void Login(String userName,String password){
        driver.findElement(txtUserName).sendKeys(userName);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(txtLogin).click();
    }


}

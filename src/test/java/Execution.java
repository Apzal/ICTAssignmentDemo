import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Execution {

    ExtentReports reports;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;

    @Test
    public void LoginTest() throws IOException {

        String path=System.getProperty("user.dir");
        reports=new ExtentReports();
        extentSparkReporter=new ExtentSparkReporter(path+"\\report\\report.html");
        reports.setSystemInfo("Machine Name", InetAddress.getLocalHost().getHostName());

        reports.attachReporter(extentSparkReporter);
        extentTest=reports.createTest("LoginTest");
        WebDriver driver=Driver.openBrowser("ie","https://opensource-demo.orangehrmlive.com/");
        Login loginPage=new Login(driver);
        loginPage.Login("admin","admin123");
        extentTest.log(Status.PASS,"Login Passed");
        extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        Driver.closeBrowser();
        reports.flush();

    }
}

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Tests {

    private static WebDriver driver;
    private static final Setting setting=new Setting();
    private PageMain pageMain;
    @BeforeMethod
    private void setUp(){
        driver = setting.CreateDriver();
        driver.get("http://automationpractice.com/");
        pageMain = new PageMain(driver);
        pageMain.register();
    }

    @Test
    public void bank_wire_test(){
        pageMain.bankWireBuy();
        assert driver.getTitle().equals("Order confirmation - My Store");
    }
    @Test
    public void check_test(){
        pageMain.checkBuy();
        assert driver.getTitle().equals("Order confirmation - My Store");
    }
    @AfterMethod
    public static void finishTest() {
        driver.quit();
    }

}

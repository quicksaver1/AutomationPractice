import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class PageSignIn
{
    private final By eMailLocator = By.xpath("//*[@id='email']");
    private final By passwordLocator = By.xpath("//*[@id='passwd']");
    private final By submitLoginLocator = By.xpath("//[@id='SubmitLogin']]");

    private final WebDriver driver;

    private final String eMail ="quicksaver13@gmail.com";
    private final String password ="12345";

    public PageSignIn(WebDriver driver) {
        this.driver=driver;
        if (!driver.getTitle().equals("Login - My Store"))
        {
            throw new IllegalStateException("Wrong page title " +driver.getTitle());
        }
    }

    public void signIn()
    {
        typeEMail(eMail);
        typePassword(password);
        clickSignIn();
    }

    private void clickSignIn()
    {
        driver.findElement(submitLoginLocator).click();
    }

    private void typePassword(String password_)
    {
        driver.findElement(passwordLocator).sendKeys(password_);
    }

    private void typeEMail(String eMail_)
    {
        driver.findElement(eMailLocator).sendKeys(eMail_);
    }
}

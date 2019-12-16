import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class PageOrder
{
    private final By proceedToCheckoutLocator1 =By.xpath("//*[@class='cart_navigation clearfix']//*[@title='Proceed to checkout']");
    private final By proceedToCheckoutLocator2 =By.xpath("//*[@name='processAddress']");
    private final By proceedToCheckoutLocator3 =By.xpath("//*[@name='processCarrier']");
    private final By agreeToTermsLocator = By.xpath("//*[@type='checkbox']");

    private final WebDriver driver;

    PageOrder(WebDriver driver)
    {
        this.driver=driver;
        if (!driver.getTitle().equals("Order - My Store"))
        {
            throw new IllegalStateException("Wrong page title " +driver.getTitle());
        }
    }


    public void proceed()
    {
        clickProceed1();
        clickProceed2();
        agreeToTerms();
        clickProceed3();
    }

    private void agreeToTerms()
    {
        driver.findElement(agreeToTermsLocator).click();
    }

    private void clickProceed1()
    {
        driver.findElement(proceedToCheckoutLocator1).click();
    }
    private void clickProceed2()
    {
        driver.findElement(proceedToCheckoutLocator2).click();
    }
    private void clickProceed3()
    {
        driver.findElement(proceedToCheckoutLocator3).click();
    }
}

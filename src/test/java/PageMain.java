import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

class PageMain
{
    private final By signInLocator =By.xpath("//*[@class='login']");
    private final By firstItemLocator = By.xpath("//*[@id='homefeatured']/*[1]//*[@class='product-image-container']");
    private final By addToCartLocator =By.xpath("//*[@class='button ajax_add_to_cart_button btn btn-default']");
    private final By proceedToCheckoutLocator =By.xpath("//*[@title='Proceed to checkout']");
    private final By bankWireLocator =By.xpath("//*[@class='bankwire']");
    private final By chequeLocator =By.xpath("//*[@class='cheque']");
    private final By confirmOrderLocator = By.xpath("//*[text()='I confirm my order']");

    private final WebDriver driver;
    public PageMain(WebDriver driver) {
        this.driver=driver;
        if (!driver.getTitle().equals("My Store"))
        {
            throw new IllegalStateException("Wrong page title " +driver.getTitle());
        }

    }
    public void register(){
        signInClick();
        PageSignIn pageSignIn = new PageSignIn(driver);
        pageSignIn.signIn();
        if (!driver.getTitle().equals("My account - My Store"))
        {
            throw new IllegalStateException("Wrong page title " +driver.getTitle());
        }
        driver.get("http://automationpractice.com/");
    }
    private void signInClick(){
        WebElement signInButton =driver.findElement(signInLocator);
        signInButton.click();

    }


    private void addToCart()
    {
        Actions action = new Actions(driver);
        WebElement firstItem = driver.findElement(firstItemLocator);
        action.moveToElement(firstItem).perform();
        driver.findElement(addToCartLocator).click();
        driver.findElement(proceedToCheckoutLocator).click();
        PageOrder pageOrder = new PageOrder(driver);
        pageOrder.proceed();
    }

    public void bankWireBuy()
    {
        addToCart();
        driver.findElement(bankWireLocator).click();
        confirmOrder();
    }

    private void confirmOrder()
    {
        driver.findElement(confirmOrderLocator).click();
    }

    public void checkBuy()
    {
        addToCart();
        driver.findElement(chequeLocator).click();
        confirmOrder();
    }
}

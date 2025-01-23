import org.openqa.selenium.WebElement;

public abstract class Page {

    public Page(){

    }

    protected void type(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.click();
            webElement.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

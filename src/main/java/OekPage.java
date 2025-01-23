import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class OekPage {

    public SelenideElement  accountNumber = $x("//input[@name='accountNumber']"),
                            buttonNext = $x("/html/body/div[1]/div/div/div/div/div/div/div[2]/form/div/div/div[2]/button[1]"),
                            fio = $x("//input[@placeholder='Фамилия Имя Отчество']"),
                            buttonPay = $x("//a[contains(@href, '/storage/b/2016/02/01/soglashenie.pdf')]/parent::label/parent::div/button");

    public OekPage setData(String value){
        accountNumber.shouldBe(visible).setValue(value);
        buttonNext.shouldBe(visible).click();
        return this;}

    public OekPage setData(String fIo, String serviceName, String amount){
        fio.shouldBe(visible).setValue(fIo);
        actions().sendKeys(Keys.TAB).perform();
        String xpath = String.format("//label[text()='Вид платежа и сумма']/parent::div/child::div/child::div/child::div/div/label[contains(text(), '%s')]/../following-sibling::div/input", serviceName);
        SelenideElement service = $x(xpath);
        service.shouldBe(visible).setValue(amount);
        return this;}

    public BasketPage processedToPayment(){
        buttonPay.shouldBe(visible).click();
        return new BasketPage();}

}

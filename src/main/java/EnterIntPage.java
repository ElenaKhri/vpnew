import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class EnterIntPage extends Page {
    public SelenideElement  accountNumber = $x("//label[text()='Номер договора']/parent::div/child::div/input"),
                            count = $x("//label[text()='Сумма']/parent::div/child::div/span/input"),
                            buttonPay = $x("//a[contains(@href, '/storage/b/2016/02/01/soglashenie.pdf')]/parent::label/parent::div/button");

public EnterIntPage setData(String an, String summa){
   // accountNumber.shouldBe(visible).setValue(an);
   // count.shouldBe(visible).setValue(summa);
    type(accountNumber, an);
    type(count,summa);
    return this;
}

public BasketPage processedToPayment(){
    buttonPay.shouldBe(visible).click();
    return new BasketPage();
    }

}

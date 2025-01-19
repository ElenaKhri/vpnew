import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {
      public SelenideElement href = $x("//h4[text()='Оплата платежей']");
      public SelenideElement buttonPay = $x("//div[@data-source-type='BANK_CARD']/child::div/button[text()='Оплатить']");

public GatewayPage payFromBasket(){
      buttonPay.shouldBe(visible).click();
      return new GatewayPage();

}



}

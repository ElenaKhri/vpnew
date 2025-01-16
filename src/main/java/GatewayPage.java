import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GatewayPage {

    public SelenideElement cardNumber = $x("//input[@id='card-pan-input']"),
                            month = $x("//input[@id='pMonth']"),
                            year = $x("//input[@id='pYear']"),
                            cvc = $x("//input[@id='cvv2-input']"),
                            userEmail = $x("//input[@name='userEmail']"),
                            userPhone = $x("//input[@name='userPhone']"),
                            payButton= $x("//button[@id='pay-button']");

    public GatewayPage setCardData(String cnValue, String mValue, String yValue, String cvcValue, String emailValue, String phoneValue){
            cardNumber.shouldBe(visible).setValue(cnValue);
            month.shouldBe(visible).setValue(mValue);
            year.shouldBe(visible).setValue(yValue);
            cvc.shouldBe(visible).setValue(cvcValue);
            userEmail.shouldBe(visible).setValue(emailValue);
            userPhone.shouldBe(visible).setValue(phoneValue);
        return this;
    }
    public GwSuccessPayPage goToPayByCard (){
    payButton.shouldBe(visible).click();
    return new GwSuccessPayPage();
}

}

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MytishhiPage {
    public SelenideElement  nameProvider = $("#heading-muprcmytishhi"),
                            accountNumber = $x("//*[@id=\"command\"]/div[1]/div/input"),
                            buttonNext = $x("/html/body/div[1]/div/div/div/div/div/div/div[2]/form/div/div/div[2]/button[1]"),
                            accoutNumberForm2=$x("//input[@value='0600124054']"),
                            lastName = $x("//input[contains(@placeholder, 'Фамилия')]"),
                            firstName = $x("//input[contains(@placeholder, 'Имя')]"),
                            patranomic = $x("//input[contains(@placeholder, 'Отчество')]"),
                            buttonPay = $x("//a[contains(@href, '/storage/b/2016/02/01/soglashenie.pdf')]/parent::label/parent::div/button");

public MytishhiPage setAccountNumber(String value){
    accountNumber.shouldBe(visible).setValue(value);
    return this;
}

public MytishhiPage pressButtonNext (){
    buttonNext.shouldBe(visible).click();
    return this;
}

public MytishhiPage setFio(String lastNam, String firstNam, String patranom ){
    lastName.shouldBe(visible).setValue(lastNam);
    firstName.shouldBe(visible).setValue(firstNam);
    patranomic.shouldBe(visible).setValue(patranom);
    return this;
}

public BasketPage processedToPayment(){
buttonPay.shouldBe(visible).click();
return new BasketPage();
}

}

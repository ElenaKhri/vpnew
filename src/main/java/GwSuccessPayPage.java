import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GwSuccessPayPage {

public SelenideElement href = $x("//h2[contains(text(),'Оплата прошла успешно')]");

}

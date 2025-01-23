import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GwSuccessPayPage {

public SelenideElement href = $x("//h2[contains(text(),'Оплата прошла успешно')]");


    public String getHref() throws InterruptedException {
        Thread.sleep(4000);
        return href.shouldBe(visible).text();
    }
}

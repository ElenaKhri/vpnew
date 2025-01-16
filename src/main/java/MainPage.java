import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement searchInput = $x("//*[@id=\"supplier-autocomplete\"]"),
            vodokanalLink = $x("//div[text()='МУП «РЦ» г. о. Мытищи']");


    public MainPage search(String value) {
        //   open("/"); // Используйте базовый URL, установленный в Configuration
        searchInput.shouldBe(visible).click();
        searchInput.setValue(value);
        return this;
    }

    public MytishhiPage selectMuprcmytishhi() {
        vodokanalLink.shouldBe(visible).click();
        return new MytishhiPage();
    }
}


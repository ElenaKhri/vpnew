import com.codeborne.selenide.Configuration;
import org.example.MytishhiPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www-test.vseplatezhi.ru/";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "131.0.6778.205"; // Укажите версию вашего браузера
        Configuration.browserBinary = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; // Укажите путь к исполняемому файлу Chrome, если необходимо
        Configuration.timeout = 60000; // Увеличьте тайм-аут до 60 секунд
    }

    @Test
    @Disabled("Тест временно отключен")
    @DisplayName("Поиск")
    void checkSearchInput(){
        MainPage mainPage = new MainPage();
        open("");
        mainPage.search("ОЭК");
    }

    @Test
    @DisplayName("Выбор поставщика с главной страницы")
    void selectProviderVodokanalFromMainPage() throws InterruptedException {
        MainPage mainPage = new MainPage();
        open("");
        mainPage.selectMuprcmytishhi();
        Thread.sleep(12000);
        MytishhiPage muprcmytishhiPage = new MytishhiPage();
        muprcmytishhiPage.nameProvider.shouldHave(text("МУП «РЦ» г. о. Мытищи"));
        Thread.sleep(12000);
    }


}

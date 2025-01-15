import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.Basket;
import org.example.MytishhiPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;


public class MytishhiPageTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www-test.vseplatezhi.ru/providers/muprcmytishhi/";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "131.0.6778.205"; // Укажите версию вашего браузера
        Configuration.browserBinary = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; // Укажите путь к исполняемому файлу Chrome, если необходимо
        Configuration.timeout = 60000; // Увеличьте тайм-аут до 60 секунд
    }

    @Disabled("Временно отключен")
    @Test
        @DisplayName("Поиск начислений по лс")
        void setLs () throws InterruptedException {
            MytishhiPage muprcmytishhiPage = new MytishhiPage();
            open("");
            muprcmytishhiPage.setAccountNumber("0600124054");
            muprcmytishhiPage.pressButtonNext();
            muprcmytishhiPage.accoutNumberForm2.shouldHave(exactValue("0600124054"));
        }

        @Test
        @Feature("Оплата") //общее название для сторей, функционала
        @Story("Проводим оплату") //отдельное название функции
        @Owner("Елена Христич")
        @DisplayName("Создание платежа")
        void createPayment(){
        SelenideLogger.addListener("allure", new AllureSelenide()); // логирует все команды селенида, подробное описание шагов
        MytishhiPage muprcmytishhiPage = new MytishhiPage();
        step(("Открываем главную страницу"),()-> {
            open("");});
            step(("Вводим лицевой счёт и нажимаем кнопку далее"),()-> {
                muprcmytishhiPage.setAccountNumber("0600124054");
                muprcmytishhiPage.pressButtonNext();});
            step(("Вводим ФИО и нажимаем на кнопку перейти к оплате"),()-> {
                muprcmytishhiPage.setFio("Иванов", "Иван","Иванович");
                muprcmytishhiPage.processedToPayment();});
            step(("Проверяем, что платеж попал в корзину путём сравнения загаловка корзины"),()-> {
                Basket basket = new Basket();
                assertEquals("Оплата платежей", basket.href.getText());});
        }


}
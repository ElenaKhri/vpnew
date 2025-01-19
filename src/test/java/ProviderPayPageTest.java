import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.*;


public class ProviderPayPageTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://vp.ru/providers";
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
    @Story("Проводим успешный платёж поставщиком МУП Мытищи") //отдельное название функции
    @Owner("Елена Христич")
    @DisplayName("Проведение успешного платёжа на форме поставщика МУП Мытищи")
    void createSuccesPaymentMytishhi(){
        SelenideLogger.addListener("allure", new AllureSelenide()); // логирует все команды селенида, подробное описание шагов
        MytishhiPage muprcmytishhiPage = new MytishhiPage();
        step(("Открываем главную страницу"),()-> {
            open("/muprcmytishhi/");
        attachment("Source", webdriver().driver().source());
       screenshot("screenshot");});
        step(("Вводим лицевой счёт и нажимаем кнопку далее"),()-> {
            muprcmytishhiPage.setAccountNumber("0600124054");
            muprcmytishhiPage.pressButtonNext();});
        step(("Вводим ФИО и нажимаем на кнопку перейти к оплате"),()-> {
            muprcmytishhiPage.setFio("Иванов", "Иван","Иванович");
            muprcmytishhiPage.processedToPayment();});
        step(("Переходим на страницу шлюза"),()-> {
            BasketPage basketPage = new BasketPage();
            /*ssertEquals("Оплата платежей", basketPage.href.getText());});*/
            basketPage.payFromBasket();
    });
        step(("Заполняем данные карты и переходим к оплате"),()-> {
        GatewayPage gatewayPage = new GatewayPage();
        gatewayPage.setCardData("5555555555555599", "12",
                "24","123", "ekhristich@vp.ru", "9136533897");
        gatewayPage.goToPayByCard();
        });

        step(("Проверка,что перешли на страницу успешной оплаты"),()-> {
            GwSuccessPayPage gwSuccessPayPage = new GwSuccessPayPage();
            assertEquals("Оплата прошла успешно", gwSuccessPayPage.href.getText()); });
}


@Test
@Feature("Оплата")
@Story("Проводим успешный платёж поставщиком ENTER (ООО «ЭНТЕР»), Интернет")
@Owner("Елена Христич")
@DisplayName("Проведение успешного платежа на форме поставщика ENTER (ООО «ЭНТЕР»), Интернет")
void createSuccesPaymentEnterInt(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    EnterIntPage enterIntPage = new EnterIntPage();
    step(("Открываем страницу поставщика"),()-> {
        open("/enter_int/");
        attachment("Source", webdriver().driver().source());
        screenshot("screenshot");});
    step(("Вводим номер договора и сумму и нажимаем кнопку перейти к оплате"),()-> {
        enterIntPage.setData("12345612","10.00");
        enterIntPage.processedToPayment();});
    step(("Переходим на страницу шлюза"),()-> {
        BasketPage basketPage = new BasketPage();
        basketPage.payFromBasket();});
    step(("Заполняем данные карты и переходим к оплате"),()-> {
        GatewayPage gatewayPage = new GatewayPage();
        gatewayPage.setCardData("5555555555555599", "12",
                "24","123", "ekhristich@vp.ru", "9136533897");
        gatewayPage.goToPayByCard();});
    step(("Проверка,что перешли на страницу успешной оплаты"),()-> {
        GwSuccessPayPage gwSuccessPayPage = new GwSuccessPayPage();
        assertEquals("Оплата прошла успешно", gwSuccessPayPage.href.getText());});
    }

@Test
@Feature("Оплата")
@Story("Проводим успешный платёж поставщиком ENTER (ООО «ЭНТЕР»), Интернет")
@Owner("Елена Христич")
@DisplayName("Проведение успешного платежа на форме поставщика «Омская энергосбытовая компания» (ООО «ОЭК»)")
void createSuccesPaymentOek(){
    SelenideLogger.addListener("allure", new AllureSelenide());
}
}

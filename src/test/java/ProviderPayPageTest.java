import config.ProviderConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdata.ProviderTestData;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

public class ProviderPayPageTest extends BaseTest {

    @Disabled("Временно отключен")
    @Test
    @Feature("Оплата") //общее название для сторей, функционала
    @Story("Проводим успешный платёж поставщиком МУП Мытищи") //отдельное название функции
    @Owner("Елена Христич")
    @DisplayName("Проведение успешного платёжа на форме поставщика МУП Мытищи")
    void createSuccesPaymentMytishhi(){
        MytishhiPage muprcmytishhiPage = new MytishhiPage();
        step(("Открываем главную страницу"),()-> {
            open("/muprcmytishhi/");
       screenshot("screenshot");});
        step(("Вводим лицевой счёт и нажимаем кнопку далее"),()-> {
            muprcmytishhiPage.setAccountNumber("0600124054");
            muprcmytishhiPage.pressButtonNext();});
        step(("Вводим ФИО и нажимаем на кнопку перейти к оплате"),()-> {
            muprcmytishhiPage.setFio("Иванов", "Иван","Иванович");
            muprcmytishhiPage.processedToPayment();});
        step(("Переходим на страницу шлюза"),()-> {
            BasketPage basketPage = new BasketPage();
            /*AssertEquals("Оплата платежей", basketPage.href.getText());});*/
            basketPage.payFromBasket();});
        step(("Заполняем данные карты и переходим к оплате"),()-> {
        GatewayPage gatewayPage = new GatewayPage();
        gatewayPage.setCardData("5555555555555599", "12",
                "24","123", "ekhristich@vp.ru", "9136533897");
        gatewayPage.goToPayByCard();
        });

/*        step(("Проверка,что перешли на страницу успешной оплаты"),()-> {
            GwSuccessPayPage gwSuccessPayPage = new GwSuccessPayPage();
           assertEquals("Оплата прошла успешно", gwSuccessPayPage.href.getText()); });*/
}


@Test
@Feature("Оплата")
@Story("Проводим успешный платёж поставщиком ENTER (ООО «ЭНТЕР»), Интернет")
@Owner("Елена Христич")
@DisplayName("Проведение успешного платежа на форме поставщика ENTER (ООО «ЭНТЕР»), Интернет")
void createSuccesPaymentEnterInt(){
    ProviderTestData providerTestData = new ProviderTestData();
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

@Disabled("Временно отключен")
@Test
@Feature("Оплата")
@Story("Проводим успешный платёж поставщиком ОЭК")
@Owner("Елена Христич")
@DisplayName("Проведение успешного платежа на форме поставщика «Омская энергосбытовая компания» (ООО «ОЭК»)")
void createSuccesPaymentOek(){
    ProviderConfig config = ConfigFactory.create(ProviderConfig.class, System.getProperties());
    OekPage oekPage = new OekPage();
    step(("Открываем страницу поставщика"),()-> {
        open("/oek/");});
    step(("Вводим лицевой счёт и нажимаем кнопку далее"),()-> {
       oekPage.setData(config.getAccountOek());});
    step(("Вводим ФИО пользователя и заполняем сумму услуги"),()-> {
        oekPage.setData(config.getFio(), "Горячая вода","10");});
    step(("Нажимаем на кнопку перейти к оплате"),()-> {
        oekPage.processedToPayment();});
    step(("Проверяем создание платежа"),()-> {
        BasketPage basketPage = new BasketPage();
        assertEquals("Оплата платежей", basketPage.href.getText());});}
}

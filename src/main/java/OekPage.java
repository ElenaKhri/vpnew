import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OekPage {

    public SelenideElement  accountNumber = $x("//input[@name='accountNumber']"),
                            buttonNext = $x("/html/body/div[1]/div/div/div/div/div/div/div[2]/form/div/div/div[2]/button[1]"),
                            fio = $x("//input[@placeholder='Фамилия Имя Отчество']"),
                            service = $x("//label[text()='Вид платежа и сумма']/parent::div/child::div/child::div/child::div/div/label[contains (text(), 'Электроэнергия')]/../following-sibling::div/input"),
                            buttonPay = $x("//a[contains(@href, '/storage/b/2016/02/01/soglashenie.pdf')]/parent::label/parent::div/button");


}

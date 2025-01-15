package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Basket {
      public SelenideElement href = $x("//h4[text()='Оплата платежей']");
      public SelenideElement buttonPay = $x("//a[contains(@href, '/storage/b/2016/02/01/soglashenie.pdf')]/parent::label/parent::div/button");
}

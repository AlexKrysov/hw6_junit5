package com.krysov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestVS {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        open("https://www.sportmaster.ru/");
      $(".sm-header__catalog").$(byText("ВИДЫ СПОРТА")).click();

    }
    @ValueSource(strings = {
            "Карате",
            "Настольные игры",
            "Дартс",
            "Регби",
            "Шахматы",
            "Самбо"})

    @ParameterizedTest(name = "Отображение поля \"{0}\" в видах спорта")
    @Tag("Critical")
    void steamMenuNewTest(String arg) {
        $$(".catalog-sports").find(text(arg)).shouldHave(text(arg));
    }
}
